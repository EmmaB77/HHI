<%-- 
    Document   : cotizar
    Created on : 04-abr-2016, 7:47:15
    Author     : windows
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %>
<%@page import="Modelo.Cotizacion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cotizacion</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/logo.jpg">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="css/jquery.dataTables.css" rel="stylesheet">
        <script src="js/jquery.dataTables.js"></script>
        <script type="text/javascript">
            $(function () {
                $('#tabla_cot').dataTable();
            });
        </script>
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
                                <li><a href="agregarCot.jsp">Agregar Nueva Cotización</a></li> 
                            </ul> 
                        </li>
                        <li class="dropdown"> 
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown" >Control de Proyectos</a> 
                            <ul class="dropdown-menu"> 
                                <li><a href="proyecto.jsp">Ver Proyectos</a></li> 
                                <li><a href="agregarProyecto.jsp">Agregar Nuevo Proyecto</a></li>
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
        <div class="container">
            <h2>Cotización:</h2>
            <div><a data-toggle="modal" href="#AgregarCot" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Agregar Cotización</a></div>
            <br>
            <br>
            <div class="table-responsive container">
                <table class="table" id="tabla_cot" name="cotizacion">
                    <thead>
                        <tr>
                            <th>Cotización</th>
                            <th>Referencia</th>
                            <th>Solicitud</th>
                            <th class="col-lg-2">Título</th>
                            <th>Fecha Cotización</th>
                            <th>Monto</th>
                            <th>Estatus</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cotizacion" items="${cotizaciones}" varStatus="iter">
                            <tr>
                                <td>${cotizacion.numCot}</td>
                                <td>${cotizacion.referencia}</td>
                                <td>${cotizacion.solCot}</td>
                                <td>${cotizacion.tituloCot}</td>
                                <td>${cotizacion.fechaCot}</td>
                                <td>$ ${cotizacion.montoCot} M.N.</td>
                                <td>${cotizacion.estatusCot}</td>
                                <td>
                                    <a href="#=${indirecto.idIndirect}" class="btn btn-sm btn-danger" role="button" title="Eliminar"><i class="glyphicon glyphicon-remove"></i></a>
                                    <a title="Actualizar / Modificar" data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#Update" data-id="${indirecto.idIndirect}" data-fecha="${indirecto.fechaIndirect}" data-mes="${indirecto.mesIndirect}" data-prov="${indirecto.proveeIndirect}" data-fact="${indirecto.numFactIndirect}" data-desc="${indirecto.descIndirect}" data-subt="${indirecto.subToIndirect}" ><i class="glyphicon glyphicon-floppy-open"></i></a>
                                    <a href="#=${indirecto.idIndirect}" class="btn btn-sm btn-success" role="button" title="Ver Detalles"><i class="glyphicon glyphicon-eye-open"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form" role="form" method="post" action="agregar_cot">
                <div class="modal fade" id="AgregarCot">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Cotización</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-6">Título:<input type="text" class="form-control" id="titulo" name="titulo"></div>
                                    <div class="col-lg-4">Referencia: <input type="text" class="form-control" id="referencia" name="referencia"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-3">Fecha de Solicitud: <input type="date" class="form-control" id="fechasol" name="fechasol"></div>
                                    <div class="col-lg-3">Fecha de Cotizacion: <input type="date" class="form-control" id="fechacot" name="fechacot"></div>
                                    <div class="col-lg-3">Orden de Compra: <input type="text" class="form-control" id="ordenC" name="ordenC"></div>
                                    <div class="col-lg-3">Solicitud: <input type="text" class="form-control" id="solCot" name="solCot"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-3">Cotización: <input type="text" class="form-control" id="coti" name="coti"></div>
                                    <div class="col-lg-3">Usuario: <select class="form-control" id="usuario" name="usuario"></select></div>
                                    <div class="col-lg-3">Monto: <input type="text" class="form-control" id="monto" name="monto"></div>
                                    <div class="col-lg-3">Factura: <input type="text" class="form-control" id="factura" name="factura"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-6">Descripción:<textarea class="form-control" style="resize:none" id="desc" name="desc"></textarea></div>
                                    <div class="col-lg-2">Ejecutor: <select class="form-control" id="ejecutor" name="ejecutor"></select></div>
                                    <div class="col-lg-2">Avance: <input type="texr" class="form-control" id="avance" name="avance"></div>
                                    <div class="col-lg-2">Estatus: <select class="form-control" name="estatus" id="estatus">
                                            <option value="...">...</option>
                                            <option value="Facturado">Facturado</option>
                                            <option value="Cotizado">Cotizado</option>
                                            <option value="En Proceso">En Proceso</option>
                                            <option value="Perdida">Perdida</option>
                                            <option value="Cancelada">Cancelada</option>
                                        </select></div>
                                </div>
                                <div><h4>Total</h4></div>
                                <div class="row form-group">
                                    <div class="col-lg-3">Total: <input type="text" class="form-control" id="totalnum" name="totalnum"></div>
                                    <div class="col-lg-6">Total Letra: <input type="text" class="form-control" id="totaletra" name="totaletra"></div>
                                </div>
                                <div class="modal-footer">
                                    <button type="summit" class="btn btn-success">Agregar</button>
                                    <button type="RESET" class="btn btn-info">Limpiar</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
