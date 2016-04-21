<%-- 
    Document   : proyecto
    Created on : 23/10/2015, 07:39:05 AM
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %>
<%@page import="Modelo.Proyecto" %>
<!DOCTYPE html>
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
                $('#tabla_proy').dataTable();
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Eliminar').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nom = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idproy').val(id);
                    $(e.currentTarget).find('#nombreproy').val(nom);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Directo').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    $(e.currentTarget).find('#idProyecto').val(id);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Indirecto').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    $(e.currentTarget).find('#idProyecto').val(id);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Consumo').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    $(e.currentTarget).find('#idProyecto').val(id);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Mano_Obra').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    $(e.currentTarget).find('#idProyecto').val(id);
                });
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
                            </ul> 
                        </li>
                        <li class="dropdown"> 
                            <a class="dropdown-toggle" href="#" data-toggle="dropdown" >Control de Proyectos</a> 
                            <ul class="dropdown-menu"> 
                                <li><a href="proyecto.jsp">Ver Proyectos</a></li> 
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
                                <li><a href="persona">Ver Personal</a></li>
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
            <h3>Proyecto</h3>
            <div><a data-toggle="modal" href="#AgregarPro" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Agregar Proyecto</a></div>
            <br><br>
            <div class="table-responsive">
                <table class="table" id="tabla_proy" name="proyectos">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Orden de compra</th>
                            <th>Requisión</th>
                            <th>Presupuesto</th>
                            <th>Disponible</th>
                            <th>Fecha Inicio</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                            <tr>
                                <td>${proyecto.nombreProyecto}</td>
                                <td>${proyecto.ordenComProyecto}</td>
                                <td>${proyecto.requiProyecto}</td>
                                <td>$ ${proyecto.presupuestoProyecto}</td>
                                <td>$ ${proyecto.dispProyecto}</td>
                                <td>${proyecto.fehaIProyecto}</td>
                                <td>
                                    <a title="Agregar Material Directo" data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#Directo" data-id="${proyecto.idProyecto}"><i class="glyphicon glyphicon-plus"></i></a>
                                    <a title="Agregar Material Consumo" data-toggle="modal" href="#" class="btn btn-sm btn-success" role="button" data-target="#Consumo" data-id="${proyecto.idProyecto}"><i class="glyphicon glyphicon-plus"></i></a>
                                    <a title="Agregar Indirecto" data-toggle="modal" href="#" class="btn btn-sm btn-primary" role="button" data-target="#Indirecto" data-id="${proyecto.idProyecto}"><i class="glyphicon glyphicon-plus"></i></a>
                                    <a title="Agregar Mano de Obra" data-toggle="modal" href="#" class="btn btn-sm btn-warning" role="button" data-target="#Mano_Obra" data-id="${proyecto.idProyecto}"><i class="glyphicon glyphicon-plus"></i></a>
                                    <a title="Eliminar Cotizacion" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#Eliminar" data-id="${proyecto.idProyecto}" data-nombre="${proyecto.nombreProyecto}"><i class="glyphicon glyphicon-remove"></i></a>
                                    <a title="Ver Proyecto" href="ver_proyecto?idproy=${proyecto.idProyecto}" class="btn btn-sm btn-default" role="button"><i class="glyphicon glyphicon-eye-open"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form" role="form" method="post" action="agregar_proy">
                <div class="modal fade" id="AgregarPro">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Proyecto</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-6">Nombre Proyecto:<input type="text" class="form-control" id="titulo" name="titulo" required></div>
                                    <div class="col-lg-3">Orden de Compra<input type="text" class="form-control" id="orden" name="orden" required></div>
                                    <div class="col-lg-3">Requisición<input type="text" class="form-control" id="requisicion" name="requisicion" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-5">Fecha Inicio<input type="date" class="form-control" id="fechai" name="fechai" required></div>
                                    <div class="col-lg-5">Presupuesto<input type="number" class="form-control" id="presu" name="presu" required step="any"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-success">Agregar</button>
                                <button type="RESET" class="btn btn-info">Limpiar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="post" action="agregar_mat_direct">
                <div class="modal fade" id="Directo">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Material Directo</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">Id Proyecto <input type="text" class="form-control" id="idProyecto" name="idProyecto" readonly></div>
                                    <div class="col-lg-3">Fecha <input type="date" class="form-control" id="fechaf" name="fechaf" required></div>
                                    <div class="col-lg-3">Proveedor <input type="text" class="form-control" id="proveedor" name="proveedor" required></div>
                                    <div class="col-lg-3">Factura <input type="text" class="form-control" id="factura" name="factura" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Descripción <input type="text" class="form-control" id="descripcion" name="descripcion" required></div>
                                    <div class="col-lg-4">Subtotal <input type="number" class="form-control" id="subtotal" name="subtotal" required step="any"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-success">Agregar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="post" action="agregar_mat_indirect">
                <div class="modal fade" id="Indirecto">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Material Indirecto</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">Id Proyecto <input type="text" class="form-control" id="idProyecto" name="idProyecto" readonly></div>
                                    <div class="col-lg-3">Fecha <input type="date" class="form-control" id="fechaf" name="fechaf" required></div>
                                    <div class="col-lg-3">Proveedor <input type="text" class="form-control" id="proveedor" name="proveedor" required></div>
                                    <div class="col-lg-3">Factura <input type="text" class="form-control" id="factura" name="factura" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Descripción <input type="text" class="form-control" id="descripcion" name="descripcion" required></div>
                                    <div class="col-lg-4">Subtotal <input type="number" class="form-control" id="subtotal" name="subtotal" required step="any"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-success">Agregar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="post" action="agregar_mat_consu">
                <div class="modal fade" id="Consumo">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Material Consumo</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">Id Proyecto <input type="text" class="form-control" id="idProyecto" name="idProyecto" readonly></div>
                                    <div class="col-lg-3">Fecha <input type="date" class="form-control" id="fechaf" name="fechaf" required></div>
                                    <div class="col-lg-3">Proveedor <input type="text" class="form-control" id="proveedor" name="proveedor" required></div>
                                    <div class="col-lg-3">Factura <input type="text" class="form-control" id="factura" name="factura" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Descripción <input type="text" class="form-control" id="descripcion" name="descripcion" required></div>
                                    <div class="col-lg-4">Subtotal <input type="number" class="form-control" id="subtotal" name="subtotal" required step="any"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-success">Agregar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="post" action="mano_obra">
                <div class="modal fade" id="Mano_Obra">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Mano de Obra</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">Id Proyecto <input type="text" class="form-control" id="idProyecto" name="idProyecto" readonly></div>
                                    <div class="col-lg-5">Descripción <input type="text" class="form-control" id="descripcion" name="descripcion" required></div>
                                    <div class="col-lg-3">Subtotal <input type="number" class="form-control" id="subtotal" name="subtotal" required step="any"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-success">Agregar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="get" action="eliminar_proy">
                <div class="modal fade" id="Eliminar">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar este Proyecto?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-3">ID: <input type="text" class="form-control" name="idproy" id="idproy" readonly value=""></div>
                                    <div class="col-lg-5">Cotizacion: <input type="text" readonly class="form-control" name="nombreproy" id="nombreproy" value=""></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-danger">Eliminar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
