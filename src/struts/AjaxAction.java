package struts;

import negocio.Libro;
import negocio.LineaCompra;

import java.util.ArrayList;

/**
 * Created by MRCOGUSA on 03/06/2016.
 */
public class AjaxAction {
    private String nombre="santi";
    private ArrayList<LineaCompra> lineas = new ArrayList<>();

    public ArrayList<LineaCompra> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaCompra> lineas) {
        this.lineas = lineas;
    }

    public String execute(){
        lineas.add(new LineaCompra(2, new Libro("titluo","Author","xxx", 4, false, false, false, "cxbvx", 3.4f)));
        lineas.add(new LineaCompra(2, new Libro("titluo","Author","xxx", 4, false, false, false, "cxbvx", 3.4f)));
        lineas.add(new LineaCompra(2, new Libro("titluo","Author","xxx", 4, false, false, false, "cxbvx", 3.4f)));
        return "success";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
