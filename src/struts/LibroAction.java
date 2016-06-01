package struts;

import com.opensymphony.xwork2.ActionSupport;
import comun.Errores;
import negocio.ControlAccesoLibroDao;
import negocio.Libro;

/**
 * Created by Maria on 10/01/2016.
 */
public class LibroAction extends ActionSupport {
    ControlAccesoLibroDao controlAccesoLibroDao=new ControlAccesoLibroDao();
    Libro libroActual=new Libro();
    String titulo;

 public String ver(){


     try {
         libroActual=controlAccesoLibroDao.buscar(titulo);
     } catch (Errores errores) {
         errores.printStackTrace();
     }
     return "verLibro";
 }
    public String verEditar(){
        try {
            libroActual=controlAccesoLibroDao.buscar(titulo);
        } catch (Errores errores) {
            errores.printStackTrace();
        }
        return "modificarLibro";
    }

    public String guardarModificacion(){
        try {
            controlAccesoLibroDao.modificar(titulo,libroActual);
        } catch (Errores errores) {
            errores.printStackTrace();
        }
        return "index";
    }

    public String nuevo(){
        libroActual=new Libro();
        return "nuevoLibro";
    }

    public String guardarNuevo(){
        try {
            controlAccesoLibroDao.insertar(libroActual);
        } catch (Errores errores) {
            errores.printStackTrace();
        }
        return "index";
    }

    public Libro getLibroActual() {
        return libroActual;
    }

    public void setLibroActual(Libro libroActual) {
        this.libroActual = libroActual;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


}
