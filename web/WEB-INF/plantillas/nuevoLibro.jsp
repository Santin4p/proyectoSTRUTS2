<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="guardarNuevoLibro" method="POST" class="form-horizontal">

    <div class="container text-center">

        <div class="form-group row">
            <p class="col-lg-2 control-label">Titulo</p>
            <div class="col-lg-8">
                <s:textfield class="form-control" name="libroActual.titulo"></s:textfield>
            </div>
        </div>
        <div class="form-group row">
            <p class="col-lg-2 control-label">Autor</p>
            <div class="col-lg-8">
                <s:textfield class="form-control" name="libroActual.autor"></s:textfield>
            </div>
        </div>

        <div class="form-group row">
            <p class="col-lg-2 control-label">Estado</p>
            <div class="col-lg-8 text-left">

                <div class="radio">
                    <s:radio list="#{'Novedad':'novedad','Reedicion':'Reedicion'}" name="libroActual.estado"></s:radio>
                </div>

            </div>
        </div>

        <div class="form-group row">
            <p class="col-lg-2 control-label" value="Selects">Selects</p>
            <div class="col-lg-8" >
                <s:select class="form-control" list="#{'Action':'Action','Aventuras':'Aventuras','Biografia':'Biografia','Ciencia':'Ciencia',
                'Ciencia Ficcion':'Ciencia Ficcion','Cine':'Cine','Economia':'Economia'}" name="libroActual.tema"></s:select>
            </div>
        </div>

        <div class="form-group row">
            <p class="col-lg-2 control-label">Nº Paginas</p>

            <div class="col-lg-8">
                <s:textfield  class="form-control" type="number" name="libroActual.numPaginas"></s:textfield>
            </div>
        </div>

        <div class="form-group row">
            <p class="col-lg-2 control-label">Precio</p>

            <div class="col-lg-8">
                <s:textfield  class="form-control" type="number" name="libroActual.precio"></s:textfield>
            </div>
        </div>

        <div class="form-group row">
            <p class="col-lg-2 control-label">Formato</p>
            <div class="col-lg-8 text-left">
                <div class="checkbox">
                    <s:checkbox name="libroActual.rustico"/>Cartone
                </div>
                <div class="checkbox">
                    <s:checkbox name="libroActual.tapaDura"/>Rustico
                </div>
                <div class="checkbox">
                    <s:checkbox name="libroActual.cartone"/>Tapa dura
                </div>
            </div>
        </div>
        <s:hidden name="titulo"></s:hidden>
        <s:submit class="btn btn-default" value="Guardar"></s:submit>
    </div>

</s:form>


