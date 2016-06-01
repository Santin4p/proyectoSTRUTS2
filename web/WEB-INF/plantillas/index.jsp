<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul>
    <s:iterator value="listaLibro">
    <li><s:a action="verLibro"> <s:property value="titulo"></s:property><s:param name="titulo" value="titulo"></s:param> </s:a></li>
    </s:iterator>
</ul>
