package negocio;

import java.util.ArrayList;

import persistencia.AccesoLibroDao;

import comun.Errores;

public class ControlAccesoLibroDao {

	/**
	 * ESTA CLASE ES INTERMEDIA ENTRE LA VISTA DEL USUARIO Y LA MAQUINARIA, PARA QUE EL NO PUEDA
	 * ACCEDER DIRECTAMENTE A ESTA.
	 */
	///implements IAcceso<Libro>
	//Creo un objeto para trabajar toda la clase.
	private AccesoLibroDao obAccesoLibroDao=new AccesoLibroDao();
	
	public boolean insertar(Libro obLibro) throws Errores {
		return obAccesoLibroDao.insertar(obLibro);
	}//alta

	public boolean borrar(String nombre) throws Errores {
		return obAccesoLibroDao.borrar(nombre);
	}//borrar

	public Libro buscar(String nombre) throws Errores {
		return obAccesoLibroDao.buscar(nombre);
	}//buscar

	public ArrayList<Libro> obtener() throws Errores {
		return obAccesoLibroDao.obtener();
	}//obtenerObjetos

	public boolean modificar(String tituloAnterior, Libro obLibro) throws Errores {
		return obAccesoLibroDao.modificar(tituloAnterior, obLibro);
	}//modificar

}
