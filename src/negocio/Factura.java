package negocio;

import persistencia.Identificador;

import java.util.Date;
import java.util.List;

/**
 * Created by MRCOGUSA on 02/06/2016.
 */
public class Factura {

    @Identificador
    private int numeroFactura;
    private int idUsuario;
    private Date fecha;
    private List<LineaCompra> lineas;

    public int getIdUsuario() {
        return idUsuario;
    }

    public float total(){
        float total = 0;
        for (LineaCompra linea : lineas) {
            total += linea.total();
        }
        return total;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<LineaCompra> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaCompra> lineas) {
        this.lineas = lineas;
    }


    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }
}
