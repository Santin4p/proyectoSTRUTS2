<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<table class="table table-striped table-hover ">
    <thead>
    <tr class="active">
        <th>Id Usuario</th>
        <th>Numero Factura</th>
        <th>Fecha de la Factura</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="listaFacturas">
        <tr class="warning">
                <td><s:label name="numeroFactura" value="%{idUsuario}"></s:label></td>
                <td><s:label name="numeroFactura" value="%{numeroFactura}"></s:label></td>
                <td><s:label name="fecha" value="%{fecha}"></s:label></td>
                <td><s:a class="btn btn-primary btn-sm">Ver detalle</s:a></td>
        </tr>
    </s:iterator>
    </tbody>
</table>

