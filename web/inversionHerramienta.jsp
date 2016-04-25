<%-- 
    Document   : gastoIndirecto
    Created on : 21/10/2015, 09:59:07 AM
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %>
<%@page import="Modelo.InversionEquipo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inversion en Herramienta</title>
        <meta charset="charset=iso-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/logo.jpg">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/jquery.dataTables.css" rel="stylesheet">
        <script src="js/jquery.dataTables.js"></script>
        <script type="text/javascript">
            $(function () {
                $('#tabla_inve').dataTable();
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Update').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var prov = $(e.relatedTarget).data().prov;
                    var desc = $(e.relatedTarget).data().desc;
                    var fact = $(e.relatedTarget).data().fact;
                    var subt = $(e.relatedTarget).data().subt;
                    var date = $(e.relatedTarget).data().date;
                    $(e.currentTarget).find('#idU').val(id);
                    $(e.currentTarget).find('#provU').val(prov);
                    $(e.currentTarget).find('#factU').val(fact);
                    $(e.currentTarget).find('#descU').val(desc);
                    $(e.currentTarget).find('#subtU').val(subt);
                    $(e.currentTarget).find('#fechaU').val(date);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Eliminar').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nom = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idEquipo').val(id);
                    $(e.currentTarget).find('#nombreCot').val(nom);
                });
            });
        </script>
    </head>
    <body >
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
            <h3>Inversión en Equipo y Herramienta</h3>
            <div><a data-toggle="modal" href="#AgregarEquipo" class="btn btn-primary btn-lg">Agregar</a></div>
            <br><br>
            <div class="table table-responsive">
                <table class="table" id="tabla_inve" name="tabla_inve">
                    <thead>
                        <tr>
                            <td class="col-lg-1">ID</td>
                            <td class="col-lg-2">Fecha</td>
                            <td class="col-lg-2">Proveedor</td>
                            <td class="col-lg-1">Factura</td>
                            <td class="col-lg-3">Descripción</td>
                            <td class="col-lg-1">Sub-Total</td>
                            <td class="col-lg-1">IVA</td>
                            <td class="col-lg-1">Total</td>
                            <td class="col-lg-1">Eliminar/Actualizar</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="equipo" items="${equipos}" varStatus="iter">
                            <tr>
                                <td>${equipo.idEquipo}</td>
                                <td>${equipo.fechaEquipo}</td>
                                <td>${equipo.proveedorEquipo}</td>
                                <td>${equipo.facturaEquipo}</td>
                                <td>${equipo.descripEquipo}</td>
                                <td>$ ${equipo.subtEquipo} MXN</td>
                                <td>$ ${equipo.ivaEquipo} MXN</td>
                                <td>$ ${equipo.totalEquipo} MXN</td>
                                <td>
                                    <a title="Eliminar Concepto" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#Eliminar" data-id="${equipo.idEquipo}" data-nombre="${equipo.descripEquipo}"><i class="glyphicon glyphicon-remove"></i></a>
                                    <a data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#Update" data-id="${equipo.idEquipo}" data-prov="${equipo.proveedorEquipo}" data-fact="${equipo.facturaEquipo}" data-desc="${equipo.descripEquipo}" data-subt="${equipo.subtEquipo}" data-date="${equipo.fechaEquipo}"><i class="glyphicon glyphicon-floppy-open"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table">
                <div class="row">
                    <form class="form" role="form" method="post" action="agregar_equipo" >
                        <div class="modal fade" id="AgregarEquipo">
                            <div class="modal-dialog modal-sm">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">Agregar Equipo</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <div>Fecha:<input type="date" class="form-control" name="fecha" id="fecha" required></div>
                                            <div>Proveedor:<input type="text" class="form-control" name="prov" id="prov" required></div>
                                            <div>Factura:<input type="text" class="form-control" name="fact" id="fact" required></div>
                                            <div>Descripción:<textarea class="form-control" style="resize: none" name="desc" id="desc" required></textarea></div>
                                            <div>Subtotal: <input type="number" step="any" class="form-control" name="subt" id="subt" required></div>
                                            <div>I.V.A
                                                <select class="form-control" name="iva" id="iva">
                                                    <option value="si">SI</option>
                                                    <Option value="no">NO</option>
                                                </select>
                                            </div>
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
                    <form class="form" role="form" method="post" action="actualizar_inve" >
                        <div class="modal fade" id="Update">
                            <div class="modal-dialog modal-sm">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">Actualizar Inversiones</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            ID:<input type="text" class="form-control" name="idU" id="idU" readonly>
                                            Fecha:<input type="date" class="form-control" name="fechaU" id="fechaU" required>
                                            Proveedor:<input type="text" class="form-control" name="provU" id="provU" required>
                                            Factura:<input type="text" class="form-control" name="factU" id="factU" required>
                                            Descripción:<textarea class="form-control" style="resize: none" name="descU" id="descU" required></textarea>
                                            Subtotal: <input type="number" step="any" class="form-control" name="subtU" id="subtU" required>
                                            <div>I.V.A
                                                <select class="form-control" name="ivaU" id="ivaU">
                                                    <option value="si">SI</option>
                                                    <Option value="no">NO</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="summit" class="btn btn-success">Modificar</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <form class="form" role="form" method="get" action="eliminar_equipo">
                <div class="modal fade" id="Eliminar">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar este Concepto?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-3">ID: <input type="text" class="form-control" name="idEquipo" id="idEquipo" readonly value=""></div>
                                    <div class="col-lg-5">Concepto: <input type="text" readonly class="form-control" name="nombreCot" id="nombreCot" value=""></div>
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
            <footer class="navbar-inverse navbar-fixed-bottom">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-3"></div>
                        <div class="col-lg-3"><p class="text-primary">HHI INSTALACIONES INDUSTRIALES S.A. de C.V.</p></div>
                        <div class="col-lg-3"><p class="text-primary">HHI Gestión y Control v1.0b Copyright &COPY;</p></div>
                        <div class="col-lg-3"></div>
                    </div>
                </div>
            </footer>
        </div>
    </body>
</html>