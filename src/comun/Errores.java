package comun;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Errores extends Exception {

	private static final long serialVersionUID = -4346796310185181350L;
	private final Exception causa;
	
	public Errores(Exception e) {
		this.causa = e;		
	}

	@Override
	public String getMessage() {
		/*if(causa.getClass().equals(com.mysql.jdbc.exceptions.jdbc4.CommunicationsException.class))
			return  "Problemas en la conexión de la base de datos";*/

		if(causa.getClass().equals(ArithmeticException.class))
			return "Excepcion de operacion aritmetica";

		if(causa.getClass().equals(NullPointerException.class))
			return "Excepcion de variable u objeto nulo/no inicializado";

		if(causa.getClass().equals(IOException.class))
			return "Excepcion de entrada/salida";

		if(causa.getClass().equals(FileNotFoundException.class))
			return "Excepcion de archivo no encontrado";

		if(causa.getClass().equals(NumberFormatException.class))
			return "Excepcion de formato incorrecto";

		if(causa.getClass().equals(ClassNotFoundException.class))
			return "Excepcion de clase no encontrada";

		if(causa.getClass().equals(ArrayIndexOutOfBoundsException.class))
			return "Excepcion de array con un indice ilegal";
		
		return "Error desconocido: "+causa.getMessage();
	}

}
