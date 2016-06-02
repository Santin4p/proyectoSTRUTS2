package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import comun.Errores;
import negocio.Carro;
import negocio.ControlAccesoLibroDao;
import negocio.Libro;
import negocio.LineaCompra;

import java.util.ArrayList;

/**
 * Created by MRCACAMA on 01/06/2016.
 */
public class LineaPedidoAction extends ActionSupport {
    ControlAccesoLibroDao controlAccesoLibroDao=new ControlAccesoLibroDao();
    String titulo;
    int cantidad;
    LineaCompra lineaActual;

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

    public String sumar(){
        Carro carrito=(Carro)ActionContext.getContext().getSession().get("carro");
        ArrayList<LineaCompra> lineasCompras=carrito.getLineasCompras();
        for (LineaCompra linea : lineasCompras) {
            if (linea.getProducto().equals(lineaActual.getProducto())){
                linea.setCantidad(linea.getCantidad()+1);
            }
        }
        carrito.setLineasCompras(lineasCompras);
        ActionContext.getContext().getSession().put("carro",carrito);

    return "";
    }

    public String restar(){
        Carro carrito=(Carro)ActionContext.getContext().getSession().get("carro");
        ArrayList<LineaCompra> lineasCompras=carrito.getLineasCompras();
        for (LineaCompra linea : lineasCompras) {
            if (linea.getProducto().equals(lineaActual.getProducto())){
                if ((linea.getCantidad()-1)==0){
                    lineasCompras.remove(linea);
                }else{
                    linea.setCantidad(linea.getCantidad()-1);
                }
            }
        }
        carrito.setLineasCompras(lineasCompras);
        ActionContext.getContext().getSession().put("carro",carrito);
        return "";
    }
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

}
