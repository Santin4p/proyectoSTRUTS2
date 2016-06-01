package persistencia;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//Importaciones de Paquetes
//EXCEPCIONES
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.SimpleFormatter;
//DATOS
import java.sql.PreparedStatement;
/**
 * 
 * 
 *
 */
public class UtilSql /* extends AccesoBD */{

	/**
	 * Genera una sentencia sql Insert obteniendo los campos del objeto
	 * @param obj
	 * @return sql
	 */
	public static final String sqlInsertar(Object obj) {
		Reflector reflector = new Reflector(obj);
		
		StringBuilder builder = new StringBuilder();
		StringBuilder values = new StringBuilder();
		builder.append("INSERT INTO ");
		builder.append(reflector.className);
		builder.append(" (");
		
		values.append(" VALUES (");
		
		try {
			Iterator<Entry<String, Method>> it = reflector.getters.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Method> field = it.next();
				builder.append(field.getKey());
				values.append(reflector.getValueOf(field.getKey()));
				
				if(it.hasNext())
				{
					builder.append(",");
					values.append(",");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		values.append(" )");
		builder.append(" )");
		builder.append(values);
				
		return builder.toString();
	}
	
	/**
	 * Genera una sentencia select where basandose en el id y el campo @Identificador de la clase
	 * @param id Valor del identificador a buscar
	 * @param clazz
	 * @return
	 */
	public static final String sqlBuscar(Object id, Class<?> clazz){
		String identificador = Reflector.getIdField(clazz);
		if(identificador.isEmpty() )
			throw new RuntimeException("Class not suported: missed @Identificador field");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM ");
		builder.append(Reflector.getClassShortName(clazz));
		builder.append(" WHERE ");
		builder.append(identificador);
		builder.append(" = ");
		builder.append(id instanceof String ? ("'" + id + "'") : id);
		return builder.toString();
	}
	
	/**
	 * Genera una sentencia sql delete where basandose en el campo @Identificador del objeto
	 * @param obj
	 * @return
	 */
	public static final String sqlBorrar(Object obj){		
		
		Reflector reflector = new Reflector(obj);
		String identificador = reflector.identificador;
		if(identificador.isEmpty() )
			throw new RuntimeException("Class not suported: missed @Identificador field");
		
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM ");
		builder.append(reflector.className);
		builder.append(" WHERE ");
		builder.append(identificador);
		builder.append(" = ");
		builder.append(reflector.getValueOf(identificador));
		return builder.toString();
	}

	/**
	 * Genera una sentencia sql Update basandose en el identificador anterior
	 * y extrayendo los campos del objeto
	 * @param id
	 * @param obj
	 * @return
	 */
	public static final String sqlModificar(Object id, Object obj){
		
		Reflector reflector = new Reflector(obj);		
		String identificador = reflector.identificador;
		
		if(identificador.isEmpty() )
			throw new RuntimeException("Class not suported: missed @Identificador field");
		
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append(reflector.className);
		builder.append(" SET ");				

		Iterator<Entry<String, Method>> it = reflector.getters.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Method> getter = it.next();
			builder.append(getter.getKey());
			builder.append(" = ");
			builder.append(reflector.getValueOf(getter.getKey()));

			if(it.hasNext())
				builder.append(",");
		}
		
		builder.append(" WHERE ");
		builder.append(identificador);
		builder.append(" = ");
		builder.append(id instanceof String ? ("'" + id + "'") : id);
		return builder.toString();
	}

	/**
	 * Genera una sentencia sql Select * basandose en el nombre de la clase
	 * @param clazz
	 * @return
	 */
	public static final String sqlObtenerTodos(Class<?> clazz){
		return "SELECT * FROM " + Reflector.getClassShortName(clazz);
	}
	
	/**
	 * 
	 * @author Marco A. Fernández Heras
	 * Clase auxiliar que extrae los campos, getter y setters de una clase
	 *
	 */
	private static class Reflector {
		HashMap<String, Class<?>> fields;
		HashMap<String, Method> getters;
		HashMap<String, Method> setters;
		String identificador;
		String className;
		final Object target;
		
		public Reflector(Object obj) {
			target = obj;
			try {				
				className = getClassShortName(obj.getClass());
				identificador = getIdField(obj.getClass());
				getFields(obj.getClass());
				getMetodhs(obj.getClass());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Get fields from class
		 * @param clazz
		 */
		private void getFields(Class<?> clazz) {
			fields = new HashMap<String, Class<?>>();
			for(Field field :  clazz.getDeclaredFields()){
				fields.put(field.getName().toLowerCase(), field.getType());
			}
		}

		/**
		 * Get getters & setters from a class
		 * @param clase
		 */
		private void getMetodhs(Class<?> clase){
			getters = new HashMap<String, Method>();
			setters = new HashMap<String, Method>();
			Method[] methods = clase.getDeclaredMethods();
			for (Method method : methods) {
				if(method.getName().startsWith("get")){
					method.setAccessible(true);
					getters.put(method.getName().substring(3, method.getName().length()).toLowerCase(), method);
				}
				else if(method.getName().startsWith("is")){//Boolean getter convection
					method.setAccessible(true);
					getters.put(method.getName().substring(2, method.getName().length()).toLowerCase(), method);
				}
				else if(method.getName().startsWith("set")){
					method.setAccessible(true);
					setters.put(method.getName().substring(3, method.getName().length()).toLowerCase(), method);
				}
			}
		}
		
		public String getValueOf(String field){
			if(!getters.containsKey(field) || !field.contains(field))
				throw new RuntimeException("Reflector::getValueOf: Invalid field");
			Class<?> fieldClass = fields.get(field);
			Object fieldValue = null;
			
			try {
				fieldValue = getters.get(field).invoke(target);
			} catch (Exception e) {}
			
			if(fieldClass.equals(String.class)){
				if(fieldValue == null){
					return "''";
				}
				else{
					return "'"+fieldValue+"'";
				}
			}
			else if(fieldClass.equals(Date.class)){
				if(fieldValue == null){
					return "''";
				}
				else{
					Date date = (Date)fieldValue;
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-hh");
					return "'"+format.format(date)+"'";
				}
			}
			else {//Numeric
				if(fieldValue == null){
					return "0";
				}
				else{
					return String.valueOf(fieldValue);
				}
			}
		}
		
		/**
		 * Get field marqued as @Identificador from a class
		 * @param class
		 * @return
		 */
		private static String getIdField(Class<?> clazz) {
			try {
				Field[] fields = clazz.getDeclaredFields();		
				for(Field field : fields){
					if(field.isAnnotationPresent(Identificador.class)){
						return field.getName();
					}
				}
			} catch (Exception e) {}
			return "";
		}
		
		/**
		 * Get class short name
		 * @param class
		 * @return
		 */
		private static String getClassShortName(Class<?> clazz) {
			return clazz.getName().substring(clazz.getName().lastIndexOf(".")+1).toLowerCase();
		}
				
	}
}
