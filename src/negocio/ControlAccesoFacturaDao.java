package negocio;

import comun.Errores;
import persistencia.AccesoFacturaDao;

import java.util.ArrayList;

/**
 * Created by MRCACAMA on 02/06/2016.
 */
public class ControlAccesoFacturaDao {
    private AccesoFacturaDao accesoFacturaDao=new AccesoFacturaDao();
    Usuario usuario;

    public ControlAccesoFacturaDao(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean insertar(Factura obj) throws Errores {
        return accesoFacturaDao.insertar(obj);
    }

    public boolean borrar(String nombre) throws Errores {
        return accesoFacturaDao.borrar(nombre);
    }

    public Factura buscar(String numero) throws Errores {
        return accesoFacturaDao.buscar(numero);
    }

    public ArrayList<Factura> obtener() throws Errores {
        return accesoFacturaDao.obtener();
    }

    public boolean modificar(String nombre, Factura obj) throws Errores {
        return accesoFacturaDao.modificar(nombre,obj);
    }
}
