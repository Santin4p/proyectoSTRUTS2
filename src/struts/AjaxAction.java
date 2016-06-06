package struts;

import com.opensymphony.xwork2.ActionContext;
import comun.Errores;
import negocio.Carro;
import negocio.ControlAccesoLibroDao;
import negocio.Libro;
import negocio.LineaCompra;

import java.util.ArrayList;

/**
 * Created by MRCOGUSA on 03/06/2016.
 */
public class AjaxAction {
    private String nombre="santi";
    private ArrayList<LineaCompra> lineas = new ArrayList<>();
    String titulo;
    float cantidad;
    ControlAccesoLibroDao controlAccesoLibroDao=new ControlAccesoLibroDao();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String execute(){
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

        return "success";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<LineaCompra> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaCompra> lineas) {
        this.lineas = lineas;
    }
}
