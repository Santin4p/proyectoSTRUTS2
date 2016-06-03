package struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

/**
 * Created by Maria on 10/01/2016.
 */
public class Interceptor implements com.opensymphony.xwork2.interceptor.Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        if( ActionContext.getContext().getSession().get("usuario")!=null){
            return invocation.invoke();
        }else{
            return "logearUsuario";
        }

    }
}
