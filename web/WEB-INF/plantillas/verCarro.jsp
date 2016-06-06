<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<script>
    $('#modificarLineaPedido').submit(function(event){$.getJSON('ajaxAction.action', {}, function(jsonResponse) {
        console.info(jsonResponse);
    }); event.preventDefault();})
</script>

<table class="table table-striped table-hover ">
    <thead>
    <tr class="active">
        <th>Libro</th>
        <th>Cantidad</th>
        <th>Modificar</th>
    </tr>
    </thead>
    <tbody>
        <s:iterator value="lineasCompra">
            <tr class="warning">
                <s:form action="modificarLineaPedido" method="POST">
                    <s:hidden name="titulo" value="%{producto.titulo}"></s:hidden>
                    <td><s:label value="%{producto.titulo}"></s:label></td>
                    <td><s:textfield  type="number" name="cantidad" value="%{cantidad}"></s:textfield></td>
                    <td><s:submit class="btn btn-primary btn-sm" value="Modificar"></s:submit></td>
                </s:form>
            </tr>
        </s:iterator>
    </tbody>
</table>
<s:form action="generarFactura" method="POST">
    <s:submit class="btn btn-primary btn-sm" value="Comprar"></s:submit>
</s:form>
