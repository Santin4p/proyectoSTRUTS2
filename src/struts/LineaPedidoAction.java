package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import comun.Errores;
import negocio.Carro;
import negocio.ControlAccesoLibroDao;
import negocio.Libro;
import negocio.LineaCompra;

/**
 * Created by MRCACAMA on 01/06/2016.
 */
public class LineaPedidoAction extends ActionSupport {
    ControlAccesoLibroDao controlAccesoLibroDao=new ControlAccesoLibroDao();
    String titulo;
    int cantidad;

    public String add(){
        LineaCompra lineaCompra=new LineaCompra();
        Libro libro;
        Carro carro;

        try{
            libro=controlAccesoLibroDao.buscar(titulo);
            lineaCompra.setProducto(libro);
            lineaCompra.setCantidad(cantidad);
            carro= (Carro) ActionContext.getContext().getSession().get("carro");

            if(carro==null)
                carro=new Carro();

            carro.anadirLinea(lineaCompra);
            ActionContext.getContext().getSession().put("carro",carro);

        }catch(Errores errores) {
            errores.printStackTrace();
        }


        return "verLibro";
    }

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

}
