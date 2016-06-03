<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="h" uri="/struts-tags" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/estilo.css"/>
    <title>Insert title here</title>
</head>
<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown"><s:a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown" role="button"> <span
                            class="glyphicon glyphicon-menu-hamburger"></span>
                    </s:a>

                        <ul class="dropdown-menu" role="menu">

                            <li><s:a action="index">Libreria</s:a></li>
                            <li class="divider"></li>
                            <li><s:a action="nuevoLibro">Nuevo Libro</s:a></li>
                            <li class="divider"></li>
                            <li><s:a action="registrarUsuario">Registrarse</s:a></li>
                            <li class="divider"></li>
                            <li><s:a action="verFactura">Facturas</s:a></li>

                  <% if (ActionContext.getContext().getSession().get("usuario")==null){%>
                      <li class="divider"></li>
                      <li><s:a action="logearUsuario">Entrar</s:a></li>
                      <li class="divider"></li>
                  <%}else{ %>
                            <li><s:a action="deslogearUsuario"><span class="glyphicon glyphicon-off"></span>ut</s:a></li>
                 <%    }  %>
                        </ul></li>
                </ul>
                <h:form class="navbar-form navbar-left">
                    <div class="form-group">
                        <s:textfield class="form-control" placeholder="Titulo"></s:textfield>
                        <s:a class="btn btn-default"><span class="glyphicon glyphicon-search"></span></s:a>
                    </div>
                </h:form>
                <h:form class="navbar-form navbar-right">
                    <s:a action="verCarro" class="btn btn-default"><span class="glyphicon glyphicon-shopping-cart"></span></s:a>
                </h:form>

            </div>
        </div>
    </nav>



    <tiles:insertAttribute name="contenido" />



    <div class="jumbotron">

        <h4>
            <p class="text-primary">Maria</p>
        </h4>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>




