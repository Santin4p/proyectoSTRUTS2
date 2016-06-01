<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container text-center">

    <div class="form-group row">
        <p class="col-lg-2 control-label">Titulo:</p>
        <div class="col-lg-1">
            <s:label name="libroActual.titulo"></s:label>
        </div>
    </div>
    <div class="form-group row">
        <p class="col-lg-2 control-label">Autor:</p>
        <div class="col-lg-1">
            <s:label  name="libroActual.autor"></s:label>
        </div>
    </div>

    <div class="form-group row">
        <p class="col-lg-2 control-label">Estado</p>
        <div class="col-lg-8 text-left">

            <div class="radio-menu-item">
                <s:radio  list="#{'Novedad':'novedad','Reedicion':'Reedicion'}" name="libroActual.estado" disabled="true"></s:radio>
            </div>

        </div>
    </div>

    <div class="form-group row">
        <p class="col-lg-2 control-label" value="Selects">Selects</p>
        <div class="col-lg-8" >
            <s:select class="form-control" list="#{'Action':'Action','Aventuras':'Aventuras','Biografia':'Biografia','Ciencia':'Ciencia',
                'Ciencia Ficcion':'Ciencia Ficcion','Cine':'Cine','Economia':'Economia'}" name="libroActual.tema" disabled="true"></s:select>
        </div>
    </div>

    <div class="form-group row">
        <p class="col-lg-2 control-label">Nº Paginas</p>

        <div class="col-lg-8">
            <p class="form-control" disabled="true"><s:property value="libroActual.numPaginas"></s:property></p>
        </div>
    </div>

    <div class="form-group row">
        <p class="col-lg-2 control-label">Formato</p>
        <div class="col-lg-1 text-left check-menu-item">
            <div class="checkbox">
                <s:checkbox name="libroActual.rustico" disabled="true"/>Cartone
            </div>
            <div class="checkbox">
                <s:checkbox name="libroActual.tapaDura" disabled="true"/>Rustico
            </div>
            <div class="checkbox">
                <s:checkbox name="libroActual.cartone" disabled="true"/>Tapa dura
            </div>
        </div>
    </div>

    <div class="form-group row">
        <p class="col-lg-2 control-label">Precio</p>

        <div class="col-lg-8">
            <p class="form-control" disabled="true"><s:property value="libroActual.precio"></s:property></p>
        </div>
    </div>

    <s:a action="verEditarLibro" class="btn btn-default">Modificar<s:param name="titulo" value="libroActual.titulo"></s:param></s:a>

    <s:form action="addLineaPedido" method="POST">
        <s:textfield class="form-control" name="cantidad"></s:textfield>
        <s:hidden name="titulo" value="%{libroActual.titulo}"></s:hidden>
        <s:submit class="btn btn-default" value="Comprar"></s:submit>
    </s:form>
</div>