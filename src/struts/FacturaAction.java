package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import comun.Errores;
import negocio.*;

import java.util.Date;

/**
 * Created by MRCOGUSA on 02/06/2016.
 */
public class FacturaAction extends ActionSupport {
    ControlAccesoFacturaDao controlAccesoFacturaDao;
    Usuario usuarioActual;

    public String generar(){
        usuarioActual=(Usuario) ActionContext.getContext().getSession().get("usuario");
        controlAccesoFacturaDao=new ControlAccesoFacturaDao(usuarioActual);
        Factura factura=new Factura();
        Carro carro= (Carro) ActionContext.getContext().getSession().get("carro");
        factura.ponerLineas(carro.getLineasCompras());
        factura.setIdUsuario(usuarioActual.getCodigo());
        factura.setFecha(new Date());
        try {
            controlAccesoFacturaDao.insertar(factura);
        } catch (Errores errores) {
            errores.printStackTrace();
        }
        return "index";
    }

}
