package persistencia;

import java.util.ArrayList;

import comun.Errores;
import negocio.Libro;
import negocio.Usuario;

public class AccesoUsuarioDao implements IAcceso<Usuario> {

	public boolean insertar(Usuario usuario) throws Errores {
		try (AccesoBD db = new AccesoBD()) {
			db.iniciarTransaccion();
			// Si el metodo buscarLibro me devuelve null, es que no lo ha
			// encontrado, que no existe.
			if (buscar(usuario.getUsuario()) == null) {
				if (db.ejecutarUpdate(UtilSql.sqlInsertar(usuario)) == 1) {
					db.aceptarTransaccion();
					return true;
				}
			}
			db.cancelarTransaccion();
		} catch (Exception e) {
			throw new Errores(e);
		}
		return false;
	}// insertar

	/**
	 * Paso un nombre por parametros, y borro el registro de la BBDD.
	 * 
	 * @param nombre
	 *            7
	 * @return True en caso de que el update se haya ejecutado, y se habr�
	 *         borrado el libro, false en caso contrario
	 */
	public boolean borrar(String nombre) throws Errores {
		try (AccesoBD db = new AccesoBD()) {
			db.iniciarTransaccion();
			Usuario usuario = buscar(nombre);
			if (usuario != null) {
				if (db.ejecutarUpdate(UtilSql.sqlBorrar(usuario)) == 1) {
					db.aceptarTransaccion();
					return true;
				}
			}
			db.cancelarTransaccion();
			return false;
		} catch (Exception e) {
			throw new Errores(e);
		}
	}// borrar

	/**
	 * Busca un libro en la BBDD a trav�s de un titulo
	 * 
	 * @return Un libro montado
	 */
	public Usuario buscar(String nombre) throws Errores {
		try (AccesoBD db = new AccesoBD()) {
			ArrayList<Object> objetos = db.ejecutarConsulta(
					UtilSql.sqlBuscar(nombre, Usuario.class), Usuario.class);
			if (objetos.isEmpty()) {
				return null;
			}
			return (Usuario) objetos.get(0);
		} catch (Exception e) {
			throw new Errores(e);
		}
	}// buscar

	/**
	 * Carga cada t�tulo de cada libro existente en la BBDD y monta un
	 * arrayList de Strings con estos.
	 * 
	 * @return ArrayList de Strings con los t�tulos.
	 * @throws Errores
	 */
	public ArrayList<Usuario> obtener() throws Errores {
		ArrayList<Object> objetos = new ArrayList<Object>();
		ArrayList<Usuario> usuarios;

		try (AccesoBD db = new AccesoBD()) {
			objetos = db.ejecutarConsulta(UtilSql.sqlObtenerTodos(Usuario.class),
					Usuario.class);
			usuarios = new ArrayList<Usuario>();
			for (int i = 0; i < objetos.size(); i++) {
				usuarios.add((Usuario) objetos.get(i));
			}
		} catch (Exception e) {
			throw new Errores(e);
		}
		return usuarios;
	}

	/**
	 * Modifica un libro de la BBDD, para ello entra el titulo que quieres
	 * modificar y el libro a modificar Lanza la sql al servidor
	 * ejecutandoUpdate y devuelve true en caso de modificar el libro, y false
	 * si ocurre algun error
	 */
	public boolean modificar(String usuarioAnterior, Usuario usuario)
			throws Errores {
		/*
		 * Modificas el libro cuyo titulo sea el que entra por parametros.
		 */

		try (AccesoBD db = new AccesoBD()) {
			db.iniciarTransaccion();
			if (db.ejecutarUpdate(UtilSql.sqlModificar(usuarioAnterior, usuario)) == 1) {
				db.aceptarTransaccion();
				return true;
			}
			db.cancelarTransaccion();
		} catch (Exception e) {

			throw new Errores(e);
		}
		return false;
	}

}// class
