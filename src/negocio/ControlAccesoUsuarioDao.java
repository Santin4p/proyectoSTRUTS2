package negocio;

import java.util.ArrayList;

import comun.Errores;
import persistencia.AccesoLibroDao;
import persistencia.AccesoUsuarioDao;

public class ControlAccesoUsuarioDao {
	private AccesoUsuarioDao obAccesoUsuarioDao = new AccesoUsuarioDao();

	public boolean insertar(Usuario usuario) throws Errores {
		return obAccesoUsuarioDao.insertar(usuario);
	}// alta

	public boolean borrar(String nombre) throws Errores {
		return obAccesoUsuarioDao.borrar(nombre);
	}// borrar

	public Usuario buscar(String nombre) throws Errores {
		return obAccesoUsuarioDao.buscar(nombre);
	}// buscar

	public ArrayList<Usuario> obtener() throws Errores {
		return obAccesoUsuarioDao.obtener();
	}// obtenerObjetos

	public boolean modificar(String tituloAnterior, Usuario usuario) throws Errores {
		return obAccesoUsuarioDao.modificar(tituloAnterior, usuario);
	}// modificar

}
