package struts;

import com.opensymphony.xwork2.*;
import negocio.ControlAccesoLibroDao;
import negocio.Libro;
import persistencia.AccesoLibroDao;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Maria on 07/01/2016.
 */
public class IndexAction implements com.opensymphony.xwork2.Action{

    ArrayList<Libro>listaLibro;

    @Override
    public String execute() throws Exception {
        ControlAccesoLibroDao accesoLibroDao=new ControlAccesoLibroDao();
        listaLibro=accesoLibroDao.obtener();

        return SUCCESS;
    }

    public ArrayList<Libro> getListaLibro() {
        return listaLibro;
    }

    public void setListaLibro(ArrayList<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }
}
