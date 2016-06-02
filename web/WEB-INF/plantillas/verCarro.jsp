<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<table class="table table-striped table-hover ">
    <thead>
    <tr class="active">
        <th>Libro</th>
        <th>Cantidad</th>
    </tr>
    </thead>
    <tbody>
        <s:iterator value="lineasCompra">
            <tr class="warning">
                <s:form action="modificarLineaPedido" method="POST">
                    <td><s:label name="titulo" value="%{producto.titulo}"></s:label></td>
                    <td><s:textfield  type="number" name="cantidad" value="%{cantidad}"></s:textfield></td>
                    <td> <s:submit class="btn btn-default" value="Modificar"></s:submit></td>
                </s:form>
            </tr>
        </s:iterator>
    </tbody>
</table>

