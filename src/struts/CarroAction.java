package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import negocio.Carro;
import negocio.LineaCompra;

import java.util.ArrayList;

/**
 * Created by MRCACAMA on 01/06/2016.
 */
public class CarroAction extends ActionSupport {

    ArrayList<LineaCompra> lineasCompra;
    Carro carro=null;

    public String ver(){
        carro= (Carro) ActionContext.getContext().getSession().get("carro");
        if(carro!=null){
            lineasCompra=carro.getLineasCompras();
        }
        return"verCarro";
    }

    public ArrayList<LineaCompra> getLineasCompra() {
        return lineasCompra;
    }

    public void setLineasCompra(ArrayList<LineaCompra> lineasCompra) {
        this.lineasCompra = lineasCompra;
    }

}
