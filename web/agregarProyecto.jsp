<%-- 
    Document   : agregarProyecto
    Created on : 21/10/2015, 08:58:36 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Proyecto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/logoT.jpg">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="" href="#">
                        <img src="img/logo_R.jpg" alt="" width="50%">
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Inicio</a></li>
                        <li class="dropdown"> 
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown" >Cotización</a> 
                            <ul class="dropdown-menu">
                                <li><a href="cotizacion">Ver Cotizaciones</a></li> 
                            </ul> 
                        </li>
                        <li class="dropdown"> 
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown" >Control de Proyectos</a> 
                            <ul class="dropdown-menu"> 
                                <li><a href="proyecto">Ver Proyectos</a></li> 
                                <li class="divider"></li>
                                <li><a href="indirecto">Gastos Indirectos</a></li>
                                <li><a href="inversion">Inversión en Herramienta</a></li>
                            </ul> 
                        </li>
                        <li class="dropdown"> 
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown" >Control de Inventario</a> 
                            <ul class="dropdown-menu"> 
                                <li><a href="tool">Inventario</a></li> 
                            </ul> 
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown">Personal</a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Ver Personal</a></li>
                                <li><a href="#">Agregar</a></li>
                                <li><a href="#">Actualizar</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown">Nómina</a>
                            <ul class="dropdown-menu">
                                <li><a href="nomina">Calcular Nómina</a></li>
                                <li><a href="reciboo">Imprimir Recibos</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="glyphicon glyphicon-user"></i> ${usuario.usuario} <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="ControladorCerrarSesion"><i class="glyphicon glyphicon-log-out"></i> Cerrar sesión</a></li>
                                <li role="separator" class="divider"></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <form class="form-horizontal container" style="background-color: #4fb8df">
            <h2>Datos de Proyecto:</h2>
            <div class="table">
                <div class="row form-group">
                    <div class="col-lg-2">Id Proyecto: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Nombre: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Cliente: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Orden de Compra: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Requisicion: <input type="text" class="form-control"></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-2">Fecha Inicio:<input type="date" class="form-control"></div>
                    <div class="col-lg-2">Fecha Fin: <input type="date" class="form-control"></div>
                    <div class="col-lg-2">Presupuesto: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Incurrido: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Disponible: <input type="text" class="form-control"></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-6">
                        <button type="summit" class="btn btn-success">Continuar</button>
                        <input type="button" class="btn btn-danger" onclick="location.href = 'index.html'" value="Cancelar">
                        <button type="RESET" class="btn btn-default">Limpiar</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>