package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import comun.Errores;
import negocio.*;

import java.util.ArrayList;

/**
 * Created by MRCOGUSA on 02/06/2016.
 */
public class FacturaAction extends ActionSupport {

    ArrayList<Factura> listaFacturas;

    public String ver(){
        Usuario user=(Usuario)ActionContext.getContext().getSession().get("usuario");
        ControlAccesoFacturaDao instancia=new ControlAccesoFacturaDao(user);
        try {
            listaFacturas=instancia.obtener();
        } catch (Errores errores) {
            errores.printStackTrace();
        }
        return"verFactura";
    }
}
