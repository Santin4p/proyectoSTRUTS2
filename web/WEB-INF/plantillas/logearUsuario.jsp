<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="guardarLogearUsuario" method="POST" class="form-horizontal">

    <div class="container text-center">
        <div class="form-group row">
        <p class="col-lg-2 control-label">Usuario</p>
        <div class="col-lg-8">
        <s:textfield class="form-control" name="usuarioActual.usuario"></s:textfield>
        </div>
        </div>

        <div class="form-group row">
        <p class="col-lg-2 control-label">Contraseña</p>
        <div class="col-lg-8">
        <s:textfield class="form-control" name="usuarioActual.contrasenia"></s:textfield>
        </div>
        </div>

    <s:submit class="btn btn-default" value="Guardar"></s:submit>
    </div>
</s:form>
