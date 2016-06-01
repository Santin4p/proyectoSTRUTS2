package persistencia;

import java.util.ArrayList;

import comun.Errores;

/*
 * ************************************************************************************************************|
 * ESTA INTERFACE USA EL PATRON FACTORY, LA DEFINICI�N DE ESTE NO ES MAS QUE :                                 |
 * UN PATR�N QUE SE IMPLEMENTA A UNA INTERFACE, HACIENDO QUE ESTA CREE UNOS METODOS GEN�RICOS                  |
 * Y SEAN SUS SUBCLASES(LAS QUE HEREDAN DE ESTA) LAS QUE SELECCIONEN EL TIPO DE OBJETO CON EL QUE TRABAJARAN   |
 * ************************************************************************************************************|                                                                                                            |                                                                                                           
 */
public interface IAcceso <ClaseGenerica>{
	/*
	 * INTERFACE DE M�TODOS GEN�RICOS 
	 */
	/**
	 * Ejecuta un update en accesoBD
	 * @param ob Generico
	 * @return True / false dependiendo del update
	 */
	public boolean insertar(ClaseGenerica obj) throws Errores;
	/*
	 * Inserta un objeto en la BBDD
	 */
	
	/**
	 * Borra un registro en la BBDD
	 * @param nombreABorrar
	 * @return True /false dependiendo del update
	 */
	public boolean borrar(String nombre) throws Errores;
	/*
	 * Borra un registro de la BBDD dependiendo del nombre del parametro
	 */
	/**
	 * Busca un registro ejecutando una consulta
	 * @param nombre
	 * @return El objeto que busquemos, si existe o null si no existe.
	 */
	public ClaseGenerica buscar(String nombre) throws Errores;
	/*
	 * Busca un registro en la BBDD a trav�s del nombre del parametro
	 */
	/**
	 * Ejecuta una consulta en la BBDD para obtener objetos de clase x
	 * @return ArrayList de Strings con los objetos
	 */
	public ArrayList<ClaseGenerica> obtener() throws Errores;
	/*
	 * Busca unos objetos X en la BBDD y los almacena uno a uno en un arrayList
	 */
	/**
	 * Modifica un registro en la BBDD, a trav�s de su nombre 
	 * @param tituloAnterior
	 * @param objModificado
	 * @return True / false dependiendo del update de la BBDD
	 */
	public boolean modificar(String nombre, ClaseGenerica obj) throws Errores;
	/*
	 * Entra por parametros un nombre del objeto y modifica los cambios deseados
	 */
}//IAcceso
