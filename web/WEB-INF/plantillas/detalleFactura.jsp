<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="container text-center">
    <div class="form-group row">
        <p class="col-lg-2 control-label pull-left">Usuario:</p>

        <div class="col-lg-2">
            <p disabled="true"><s:property value="%{usuarioActual.nombre}"></s:property></p>
        </div>
    </div>

    <div class="form-group row">
        <p class="col-lg-2 control-label pull-left">Fecha:</p>

        <div class="col-lg-2">
            <p disabled="true"><s:property value="%{facturaActual.fecha}"></s:property></p>
        </div>
    </div>

    <div class="form-group row">
        <p class="col-lg-2 control-label">Lineas de la factura:</p>
    </div>

    <table class="table table-striped table-hover ">

        <thead>
        <tr class="active">
            <th>Libro</th>
            <th>Cantidad</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="facturaActual.lineas">
            <tr class="warning">
                <td><s:label name="tituloLibro" value="%{tituloLibro}"></s:label></td>
                <td><s:label name="cantidad" value="%{cantidad}"></s:label></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

</div>