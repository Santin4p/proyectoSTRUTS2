package persistencia;

import java.sql.SQLException;

//IMPORTACIONES DE PAQUETES
//import java.sql.SQLException;

//PAQUETES DE HERRAMIENTAS
import java.util.ArrayList;

import javax.naming.NamingException;

import comun.Errores;
//PAQUETES EXTERNOS
import negocio.Libro;

/**
 * 
 * 
 *
 */
public class AccesoLibroDao implements IAcceso<Libro> {

	// ---------------------PROPIEDADES-------------------------------------------------

	/*
	 * ALERTA. ---- LOS METODOS QUE ENVIEN UNA QUERY MULTILINEA, ES DECIR mas de
	 * un update, insert or delete DE GOLPE FUNCIONAN CON TRANSACCIONES, ES
	 * DECIR, QUE PONEMOS EL AUTOCOMIT DE LA CONEXION A NULL, PARA QUE NO ENVIE
	 * NADA A MEMORIA FISICA HASTA QUE NOSOTROS NO ESTEMOS SEGUROS QUE TODO SE
	 * HA CARGADO EN MEMORIA VIRTUAL CORRECTAMENTE.
	 */

	// ------------------------------METODOS DE LA
	// CLASE--------------------------------
	/**
	 * Compruebo de que el libro que queremos introducir no exista ya, a
	 * trav�s del titulo Y lo introduzco en la BBDD a trav�s de una query
	 * 
	 * @param obLibro
	 * @return True en caso de que haya sido introducido, false en caso
	 *         contrario
	 */
	public boolean insertar(Libro obLibro) throws Errores {
		try (AccesoBD db = new AccesoBD()) {
			db.iniciarTransaccion();
			// Si el metodo buscarLibro me devuelve null, es que no lo ha
			// encontrado, que no existe.
			if (buscar(obLibro.getTitulo()) == null) {
				if (db.ejecutarUpdate(UtilSql.sqlInsertar(obLibro)) == 1) {
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
			Libro libro = buscar(nombre);
			if (libro != null) {
				if (db.ejecutarUpdate(UtilSql.sqlBorrar(libro)) == 1) {
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
	public Libro buscar(String nombre) throws Errores {
		try (AccesoBD db = new AccesoBD()) {
			ArrayList<Object> objetos = db.ejecutarConsulta(
					UtilSql.sqlBuscar(nombre, Libro.class), Libro.class);
			if (objetos.isEmpty()) {
				return null;
			}
			return (Libro) objetos.get(0);
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
	public ArrayList<Libro> obtener() throws Errores {
		ArrayList<Object> objetos = new ArrayList<Object>();
		ArrayList<Libro> libros;

		try (AccesoBD db = new AccesoBD()) {
			objetos = db.ejecutarConsulta(UtilSql.sqlObtenerTodos(Libro.class),
					Libro.class);
			libros = new ArrayList<Libro>();
			for (int i = 0; i < objetos.size(); i++) {
				libros.add((Libro) objetos.get(i));
			}
		} catch (Exception e) {
			throw new Errores(e);
		}
		return libros;
	}

	/**
	 * Modifica un libro de la BBDD, para ello entra el titulo que quieres
	 * modificar y el libro a modificar Lanza la sql al servidor
	 * ejecutandoUpdate y devuelve true en caso de modificar el libro, y false
	 * si ocurre algun error
	 */
	public boolean modificar(String tituloAnterior, Libro obLibro)
			throws Errores {
		/*
		 * Modificas el libro cuyo titulo sea el que entra por parametros.
		 */

		try (AccesoBD db = new AccesoBD()) {
			db.iniciarTransaccion();
			if (db.ejecutarUpdate(UtilSql.sqlModificar(tituloAnterior, obLibro)) == 1) {
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
