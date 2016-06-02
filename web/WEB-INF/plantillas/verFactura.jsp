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
    <s:iterator value="listaFacturas">
        <tr class="warning">
                <td><s:label name="numeroFactura" value="%{numeroFactura}"></s:label></td>
        </tr>
    </s:iterator>
    </tbody>
</table>

