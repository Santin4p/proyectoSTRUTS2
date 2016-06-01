package comun;

/*
 * *********************************************************
 * Clase formada por unas CONSTANTES, y un metodo estatico**
 * que se encarga de recibir por params un tipo de accion***
 * y a través de esta, devuelve un mensaje.*****************
 * *********************************************************
 */
public class Mensajes {

	public static final int MEN_ALTA_CREADA=1;
	public static final int MEN_LIBRO_SIN_TITULO=2;
	public static final int MEN_EL_LIBRO_YA_EXISTE=3;
	public static final int MEN_LIBRO_BORRADO_CORRECTAMENTE=4;
	public static final int MEN_NO_EXISTEN_LIBROS=5;
	public static final int MEN_IMPOSIBLE_BORRAR_LIBRO=6;
	public static final int MEN_LIBRO_MODIFICADO_CORRECTAMENTE=7;
	public static final int MEN_ALTA_UUARIO_CREADA=8;
	public static final int MEN_USUARIO_SIN_NOMBRE=9;
	public static final int MEN_EL_USUARIO_YA_EXISTE=10;
	public static final int MEN_USUARIO_BORRADO_CORRECTAMENTE=11;
	public static final int MEN_NO_EXISTEN_USUARIOS=12;
	public static final int MEN_IMPOSIBLE_BORRAR_USUARIO=13;
	public static final int MEN_USUARIO_MODIFICADO_CORRECTAMENTE=14;

	public static String mensaje(int tipo){
		switch (tipo) {
		case 1:
			return"Libro creado correctamente";
		case 2:
			return"El titulo esta en blanco";
		case 3:
			return"El libro ya existe";
		case 4:
			return"Libro borrado correctamente";
		case 5:
			return"No existen libros a Cargar";
		case 6:
			return"Error al borrar el libro";
		case 7:
			return"Libro modificado correctamente";
		case 8:
			return"Usuario creado correctamente";
		case 9:
			return"El nombre esta en blanco";
		case 10:
			return"El usuario ya existe";
		case 11:
			return"Usuario borrado correctamente";
		case 12:
			return"No existen usuarios a Cargar";
		case 13:
			return"Error al borrar el usuario";
		case 14:
			return"Usuario modificado correctamente";
		}//switch
		return "Error no conocido";
	}//mensaje
}//class
