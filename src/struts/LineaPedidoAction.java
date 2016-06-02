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
    Libro libroActual;

    public String add(){
        LineaCompra lineaCompra=new LineaCompra();
        Libro libro;
        Carro carro;
        ArrayList<LineaCompra>lineas;
        boolean repetida=false;
        try{
            libro=controlAccesoLibroDao.buscar(titulo);
            libroActual=libro;
            lineaCompra.ponerProducto(libro);
            lineaCompra.setTituloLibro(titulo);
            lineaCompra.setCantidad(cantidad);
            carro= (Carro) ActionContext.getContext().getSession().get("carro");

            if(carro==null)
                carro=new Carro();

            lineas=carro.getLineasCompras();

            for (int i = 0; i < lineas.size(); i++) {
                if(lineas.get(i).getProducto().getTitulo().equals(libro.getTitulo())){
                    Float cant=lineas.get(i).getCantidad();
                    lineas.get(i).setCantidad(cant+cantidad);
                    carro.setLineasCompras(lineas);
                    repetida=true;
                }


            }
            if(!repetida) {
                carro.anadirLinea(lineaCompra);
            }
            ActionContext.getContext().getSession().put("carro",carro);

        }catch(Errores errores) {
            errores.printStackTrace();
        }
        return "verLibro";
    }
    public String modificar(){
        try {
            Libro libro=controlAccesoLibroDao.buscar(titulo);
            Carro carro= (Carro) ActionContext.getContext().getSession().get("carro");
            ArrayList<LineaCompra>lineas= carro.getLineasCompras();

            for (int i = 0; i < lineas.size(); i++) {
                if(lineas.get(i).getProducto().getTitulo().equals(libro.getTitulo())){
                    if (cantidad == 0) {
                        lineas.remove(lineas.get(i));
                    }else {
                        lineas.get(i).setCantidad(cantidad);
                    }
                }
            }
        } catch (Errores errores) {
            errores.printStackTrace();
        }
        return "carrito";
    }

    /*public String sumar(){
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
    }*/

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public Libro getLibroActual() {return libroActual;}
    public void setLibroActual(Libro libroActual) {this.libroActual = libroActual;}

}
