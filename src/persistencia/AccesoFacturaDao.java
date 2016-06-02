package persistencia;

import comun.Errores;
import negocio.Factura;
import negocio.LineaCompra;
import negocio.Usuario;

import java.util.ArrayList;

/**
 * Created by MRCOGUSA on 02/06/2016.
 */
public class AccesoFacturaDao implements IAcceso<Factura> {

    Usuario usuario;

    public AccesoFacturaDao(Usuario usuario) {
        this.usuario = usuario;
    }
    public AccesoFacturaDao(){}

    @Override
    public boolean insertar(Factura obj) throws Errores {
        try (AccesoBD db = new AccesoBD()) {
            db.iniciarTransaccion();
            if (db.ejecutarUpdate(UtilSql.sqlInsertar(obj)) == 1) {
                ArrayList<Object> facturas = db.ejecutarConsulta(UtilSql.sqlObtenerTodos(Factura.class), Factura.class);
                int numeroFact = ((Factura) facturas.get(facturas.size() - 1)).getNumeroFactura();
                for (LineaCompra lineaFactura : obj.getLineas()) {
                    lineaFactura.setNumeroFactura(numeroFact);
                    if (db.ejecutarUpdate(UtilSql.sqlInsertar(lineaFactura)) != 1) {
                        throw new Exception("Error al insertar Lineas de factura");
                    }
                }
                db.aceptarTransaccion();
                return true;
            }
        } catch (Exception e) {
            throw new Errores(e);
        }
        return false;
    }

    @Override
    public boolean borrar(String nombre) throws Errores {
        return false;
    }

    @Override
    public Factura buscar(String numero) throws Errores {
        try (AccesoBD db = new AccesoBD()) {
            ArrayList<Object> facturas = db.ejecutarConsulta(UtilSql.sqlBuscarId(Integer.valueOf(numero),Factura.class), Factura.class);
            if(!facturas.isEmpty()){
                Factura factura = (Factura) facturas.get(0);
                //Solo la devolvemos si es de este usuario
                if(factura.getIdUsuario() == usuario.getCodigo()){
                    obtenerLineasFactura(db, factura);
                    return factura;
                }
            }
            throw new Exception("Factura no encontrada");
        } catch (Exception e) {
            throw new Errores(e);
        }
    }

    @Override
    public ArrayList<Factura> obtener() throws Errores {
        try (AccesoBD db = new AccesoBD()) {
            ArrayList<Object> facturas = db.ejecutarConsulta(UtilSql.sqlObtenerTodos(Factura.class), Factura.class);
            ArrayList<Factura> ret = new ArrayList<>();
            for (Object object : facturas) {
                Factura f = (Factura) object;
                if(f.getIdUsuario() == usuario.getCodigo()){
                    obtenerLineasFactura(db, f);
                    ret.add(f);
                }
            }
            return ret;
        } catch (Exception e) {
            throw new Errores(e);
        }
    }
    private void obtenerLineasFactura(AccesoBD db, Factura f) throws Errores {
        String sql = UtilSql.sqlObtenerTodos(LineaCompra.class) + " where numeroFactura = " + f.getNumeroFactura();
        ArrayList<Object> objects = db.ejecutarConsulta(sql, LineaCompra.class);
        for (Object object : objects) {
            f.getLineas().add((LineaCompra)object);
        }
    }

    @Override
    public boolean modificar(String nombre, Factura obj) throws Errores {
        return false;
    }
}
