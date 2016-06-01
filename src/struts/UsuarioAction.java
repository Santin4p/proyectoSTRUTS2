package struts;

import comun.Errores;
import negocio.ControlAccesoUsuarioDao;
import negocio.Usuario;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by MRCACAMA on 30/05/2016.
 */
public class UsuarioAction implements SessionAware{

    Usuario usuarioActual=new Usuario();
    ControlAccesoUsuarioDao controlAccesoUsuarioDao=new ControlAccesoUsuarioDao();

    public String registrar(){
        usuarioActual=new Usuario();
        return "registrarUsuario";
    }

    public String guardarRegistrar(){
        try {
           if(controlAccesoUsuarioDao.insertar(usuarioActual))
               return "index";
           return "registrarUsuario";
        } catch (Errores errores) {
            errores.printStackTrace();
            return "registrarUsuario";
        }
    }

    public String logear(){
        usuarioActual=new Usuario();
        return "logearUsuario";
    }

    public String guardarLogear(){
        try {
            Usuario usuarioLog=controlAccesoUsuarioDao.buscar(usuarioActual.getUsuario());
            if((usuarioLog.getUsuario().equals(usuarioActual.getUsuario())) && (usuarioLog.getContrasenia().equals(usuarioActual.getContrasenia()))){
                return "index";
            }else{
                return "logearUsuario";
            }
        } catch (Errores errores) {
            errores.printStackTrace();
            return "logearUsuario";
        }
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }
}
