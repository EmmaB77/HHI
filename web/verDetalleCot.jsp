<%-- 
    Document   : verDetalleCot
    Created on : 22/10/2015, 10:45:03 AM
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %>
<%@page import="Modelo.Cotizacion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle de Cotización</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/logo.jpg">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
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
                                <li><a href="recibo">Imprimir Recibos</a></li>
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
        <div class="table container" align="center">
            <div class="row" style="background-color: #000">
                <div class="col-lg-12">
                    <img src="img/encabezado.jpg" class="img-responsive img-rounded" align="center">
                </div>
            </div><br>
            <c:forEach var="cotizacion" items="${cotizaciones}" varStatus="iter">
                <div class="table" align="right">
                    <div class="row">
                        <div class="col-xs-7"><a title="Ver Proyectos" href="cotizacion" class="btn btn-lg btn-info" role="button"><i class="glyphicon glyphicon-arrow-left"> Volver</i></a></div>
                        <div class="col-xs-5"><b>Santiago de Querétaro, Qro. a ${cotizacion.fechaCot}</b></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-9"></div>
                        <div class="col-xs-3"><b>Cot. No: ${cotizacion.numCot}</b></div>
                    </div><br>
                    <div class="row">
                        <div class="col-xs-7"></div>
                        <div class="col-xs-5"><b>AT'N: ING. LILIANA MEHTA</b></div>
                    </div>
                </div>
                <div class="table" align="left">
                    <div class="row">
                        <div class="col-xs-6"><b>CLIENTE: INDORAMA VENTURES</b></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3"><b>REF:</b> ${cotizacion.referencia}</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3"><b>SOL COT:</b> ${cotizacion.solCot}</div>
                    </div>
                    <div class="row">
                        <div class="col-xs-5"><b>USUARIO:</b> ING. ${cotizacion.usuario.persona.nombrePersona}&nbsp;${cotizacion.usuario.persona.apellidoPpersona}</div>
                    </div>
                </div>
                <div class="table" align="center">
                    <div class="row">
                        <div class="col-xs-12"><b>COTIZACIÓN REFERENTE AL SIGUIENTE SERVICIO</b></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12" style="font-size: 150%"><b>${cotizacion.tituloCot}</b></div>
                    </div><br><br>
                    <div class="table table-bordered row" align="left">
                        <div class="col-xs-4"><b>Descripcion:</b></div>
                        <div class="col-xs-8">${cotizacion.descCot}</div>
                    </div>
                </div><br></c:forEach>
                <div class="table">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th style="color: #1C77D8"><h5><b>ID</b></h5></th>
                                <th class="col-xs-6" style="color: #1C77D8"><h5><b>DESCRIPCIÓN</b></h5></th>
                                <th style="color: #1C77D8"><h5><b>CANTIDAD</b></h5></th>
                                <th style="color: #1C77D8"><h5><b>UNIDAD</b></h5></th>
                                <th style="color: #1C77D8"><h5><b>PRECIO UNITARIO</h5></b></th>
                                <th style="color: #1C77D8"><h5><b>TOTAL</b></h5></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="detalle" items="${detalles}" varStatus="iter">
                            <tr>
                                <td><h5>${detalle.incisoCotDet}</h5></td>
                                <td><h5><b>${detalle.descCotDet}</h5></b></td>
                                <td><h5>${detalle.cantCotDet}</h5></td>
                                <td><h5>${detalle.uniCotDet}</h5></td>
                                <td><h5>$ ${detalle.precioUni}</h5></td>
                                <td><h5>$ ${detalle.importeCotDet}</h5></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div><br>
            <div class="table table-bordered" style="background-color: #a9b6d0">
                <c:forEach var="cotizacion" items="${cotizaciones}" varStatus="iter">
                    <div class="row">
                        <div class="col-xs-3"></div>
                        <div class="col-xs-6" style="font-size: 100%"><b>COSTO TOTAL DE LA OFERTA $ ${cotizacion.total} M.N.</b></div>
                        <div class="col-xs-3"></div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3"></div>
                        <div class="col-xs-6"><b>(${cotizacion.canLetCot}/100 M.N.)</b></div>
                    </div>
                </div><br>
                    <div class="row" align="left">
                        <div class="col-xs-6"><h6><b>PRECIO MAS EL 16% DE IVA</b></h6></div>
                    </div>
                <div class="table" align="left" style="background-color: #1C77D8">
                    <div class="row">
                        <div class="col-xs-6"><h6><b>TIEMPO DE ENTREGA: ${cotizacion.tiempoEntrega}</b></h6></div>
                    </div>
                </div></c:forEach>
            <div class="table" align="left">
                <table class="table-bordered">
                    <thead>
                        <tr>
                            <td>NOTAS</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><h6>1.-</h6></td>
                            <td><h6>ESTE PRESUPUESTO ESTA BASADO EN PRECIOS UNITARIOS EN TIEMPO NORMAL DE LUNES A VIERNES DE LAS 7:00 a.m. A LAS 6:00 p.m., EL TIEMPO EXTRA SE COBRARA POR SEPARADO.</h6></td>
                        </tr>
                        <tr>
                            <td><h6>2.-</h6></td>
                            <td><h6>EL INCREMENTO EN EL COSTO DE LOS MATERIALES MAYOR AL 3%, INVALIDARA ESTA COTIZACIÓN.</h6></td>
                        </tr>
                        <tr>
                            <td><h6>3.-</h6></td>
                            <td><h6>CUALQUIER TRABAJO ADICIONAL FUERA DE EL ALCANCE DE ESTE PRESUPUESTO SE NEGOCIARA CON EL CLIENTE Y SE COSTEARÁ POR SEPARADO.</h6></td>
                        </tr>
                        <tr>
                            <td><h6>4.-</h6></td>
                            <td><h6>CONDICIONES DE PAGO:  25 DÍAS CONTRA AVANCES</h6></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
