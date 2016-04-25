<%-- 
    Document   : proyectoDisponible
    Created on : 21/10/2015, 01:41:54 PM
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
        <title>Detalles del Proyecto</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/logo.jpg">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function (e) {
                $('#EliminarMD').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var idDet = $(e.relatedTarget).data().id2;
                    var nom = $(e.relatedTarget).data().nombre;
                    var imp = $(e.relatedTarget).data().sub;
                    $(e.currentTarget).find('#idProy').val(id);
                    $(e.currentTarget).find('#idMD').val(idDet);
                    $(e.currentTarget).find('#nombreDetCot').val(nom);
                    $(e.currentTarget).find('#subT').val(imp);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#EliminarMI').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var idDet = $(e.relatedTarget).data().id2;
                    var nom = $(e.relatedTarget).data().nombre;
                    var imp = $(e.relatedTarget).data().sub;
                    $(e.currentTarget).find('#idProy').val(id);
                    $(e.currentTarget).find('#idMI').val(idDet);
                    $(e.currentTarget).find('#nombreDetCot').val(nom);
                    $(e.currentTarget).find('#subT').val(imp);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#EliminarMC').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var idDet = $(e.relatedTarget).data().id2;
                    var nom = $(e.relatedTarget).data().nombre;
                    var imp = $(e.relatedTarget).data().sub;
                    $(e.currentTarget).find('#idProy').val(id);
                    $(e.currentTarget).find('#idMC').val(idDet);
                    $(e.currentTarget).find('#nombreDetCot').val(nom);
                    $(e.currentTarget).find('#subT').val(imp);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#EliminarMO').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var idDet = $(e.relatedTarget).data().id2;
                    var nom = $(e.relatedTarget).data().nombre;
                    var imp = $(e.relatedTarget).data().sub;
                    $(e.currentTarget).find('#idProy').val(id);
                    $(e.currentTarget).find('#idMO').val(idDet);
                    $(e.currentTarget).find('#nombreDetCot').val(nom);
                    $(e.currentTarget).find('#subT').val(imp);
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
        <div class="table container" align="center">
            <div class="row" style="background-color: #000">
                <div class="col-lg-12">
                    <img src="img/encabezado.jpg" class="img-responsive img-rounded" align="center">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6"><h2>CONTROL DE PROYECTO</h2></div>
                <div class="col-lg-3"><a title="Ver Proyectos" href="proyecto" class="btn btn-lg btn-info" role="button"><i class="glyphicon glyphicon-arrow-left"> Volver</i></a></div>
            </div>
            <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6"><h3>${proyecto.nombreProyecto}</h3></div>
                    <div class="col-lg-3"></div>
                </div>
                <div class="row">
                    <div class="col-lg-4"><b>Orden de Compra:</b> ${proyecto.ordenComProyecto}</div>
                    <div class="col-lg-4"><b>Requisición:</b> ${proyecto.requiProyecto}</div>
                    <div class="col-lg-4"><b>Fecha Inicio:</b> ${proyecto.fehaIProyecto}</div>
                </div>
                <div class="row">
                    <div class="col-lg-4"><b>Presupuesto:</b> $ ${proyecto.presupuestoProyecto} M.N.</div>
                    <div class="col-lg-4"><b>I.V.A:</b> $ ${proyecto.ivaProyecto} M.N.</div>
                    <div class="col-lg-4"><b>Total:</b> $ ${proyecto.totalproyecto} M.N.</div>
                </div>
                <div class="row">
                    <div class="col-lg-4"><b>Incurrido:</b> $ ${proyecto.incurridoProyecto} M.N.</div>
                    <div class="col-lg-4"><b>Disponible:</b> $ ${proyecto.dispProyecto} M.N.</div>
                    <div class="col-lg-4"><b>Utilidad:</b> ${proyecto.utilidadProyecto}%</div>
                </div>
            </c:forEach><br><br>
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6"><h4><b>MATERIAL DIRECTO</b></h4></div>
                <div class="col-lg-3"></div>
            </div>
            <div class="table">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b>FECHA</b></th>
                            <th><b>PROVEEDOR</b></th>
                            <th><b>DESCRIPCION</b></th>
                            <th><b>FACTURA</b></th>
                            <th><b>SUBTOTAL</b></th>
                            <th><b>I.V.A</b></th>
                            <th><b>TOTAL</b></th>
                            <th><b>ACCIONES</b></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detalle" items="${detallesd}" varStatus="iter">
                            <tr>
                                <td>${detalle.fechaFactMatDirect}</td>
                                <td>${detalle.preveedorMatDirect}</td>
                                <td>${detalle.descripMatDirect}</td>
                                <td>${detalle.numFactMatDirect}</td>
                                <td>$ ${detalle.subtMatDirect} M.N.</td>
                                <td>$ ${detalle.ivaMatDirect} M.N.</td>
                                <td>$ ${detalle.totalMatDirect} M.N.</td>
                                <td>
                                    <a title="Eliminar Material" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#EliminarMD" data-id="${detalle.idProyecto}" data-nombre="${detalle.descripMatDirect}" data-id2="${detalle.idMatDirect}" data-sub="${detalle.subtMatDirect}"><i class="glyphicon glyphicon-remove"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b>TOTAL PARCIAL</b></th>
                            <th><b>TOTAL I.V.A</b></th>
                            <th><b>TOTAL FINAL</b></th>   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="total" items="${totalesmd}" varStatus="iter">
                            <tr>
                                <td>$ ${total.totalParcialMD} M.N.</td>
                                <td>$ ${total.totalIvaMD} M.N.</td>
                                <td>$ ${total.totalMD} M.N.</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6"><h4><b>MATERIAL INDIRECTO</b></h4></div>
                <div class="col-lg-3"></div>
            </div>
            <div class="table">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b>FECHA</b></th>
                            <th><b>PROVEEDOR</b></th>
                            <th><b>DESCRIPCION</b></th>
                            <th><b>FACTURA</b></th>
                            <th><b>SUBTOTAL</b></th>
                            <th><b>I.V.A</b></th>
                            <th><b>TOTAL</b></th>
                            <th><b>ACCIONES</b></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detalle" items="${detallesi}" varStatus="iter">
                            <tr>
                                <td>${detalle.fechaFactMatIn}</td>
                                <td>${detalle.preveedorMatIn}</td>
                                <td>${detalle.descripMatIn}</td>
                                <td>${detalle.numFactMatIn}</td>
                                <td>$ ${detalle.subtMatIn} M.N.</td>
                                <td>$ ${detalle.ivaMatIn} M.N.</td>
                                <td>$ ${detalle.totalMatIn} M.N.</td>
                                <td>
                                    <a title="Eliminar Material" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#EliminarMI" data-id="${detalle.idProyecto}" data-nombre="${detalle.descripMatIn}" data-id2="${detalle.idMatIn}" data-sub="${detalle.subtMatIn}"><i class="glyphicon glyphicon-remove"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b>TOTAL PARCIAL</b></th>
                            <th><b>TOTAL I.V.A</b></th>
                            <th><b>TOTAL FINAL</b></th>   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="total" items="${totalesmi}" varStatus="iter">
                            <tr>
                                <td>$ ${total.totalParcialMI} M.N.</td>
                                <td>$ ${total.totalIvaMI} M.N.</td>
                                <td>$ ${total.totalMI} M.N.</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6"><h4><b>MATERIAL DE CONSUMO</b></h4></div>
                <div class="col-lg-3"></div>
            </div>
            <div class="table">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b>FECHA</b></th>
                            <th><b>PROVEEDOR</b></th>
                            <th><b>DESCRIPCION</b></th>
                            <th><b>FACTURA</b></th>
                            <th><b>SUBTOTAL</b></th>
                            <th><b>I.V.A</b></th>
                            <th><b>TOTAL</b></th>
                            <th><b>ACCIONES</b></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detalle" items="${detallesc}" varStatus="iter">
                            <tr>
                                <td>${detalle.fechaFactMatCon}</td>
                                <td>${detalle.preveedorMatCon}</td>
                                <td>${detalle.descripMatCon}</td>
                                <td>${detalle.numFactMatCon}</td>
                                <td>$ ${detalle.subtMatCon} M.N.</td>
                                <td>$ ${detalle.ivaMatCon} M.N.</td>
                                <td>$ ${detalle.totalMatCon} M.N.</td>
                                <td>
                                    <a title="Eliminar Material" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#EliminarMC" data-id="${detalle.idProyecto}" data-nombre="${detalle.descripMatCon}" data-id2="${detalle.idMatCon}" data-sub="${detalle.subtMatCon}"><i class="glyphicon glyphicon-remove"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b>TOTAL PARCIAL</b></th>
                            <th><b>TOTAL I.V.A</b></th>
                            <th><b>TOTAL FINAL</b></th>   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="total" items="${totalesmc}" varStatus="iter">
                            <tr>
                                <td>$ ${total.totalParcialMC} M.N.</td>
                                <td>$ ${total.totalIvaMC} M.N.</td>
                                <td>$ ${total.totalMC} M.N.</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6"><h4><b>MANO DE OBRA</b></h4></div>
                <div class="col-lg-3"></div>
            </div>
            <div class="table">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b>DESCRIPCION</b></th>
                            <th><b>TOTAL</b></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detalle" items="${detallesmo}" varStatus="iter">
                            <tr>
                                <td>${detalle.descMaO}</td>
                                <td>$ ${detalle.subtMaO} M.N.</td>
                                <td>
                                    <a title="Eliminar Material" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#EliminarMO" data-id="${detalle.idProyecto}" data-nombre="${detalle.descMaO}" data-id2="${detalle.idMaO}" data-sub="${detalle.subtMaO}"><i class="glyphicon glyphicon-remove"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th><b></b></th>
                            <th><b>TOTAL</b></th>
                            <th><b></b></th>   
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="total" items="${totalesmo}" varStatus="iter">
                            <tr>
                                <td></td>
                                <td>$ ${total.subTotalMao} M.N.</td>
                                <td></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form" role="form" method="get" action="eliminar_md">
                <div class="modal fade" id="EliminarMD">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar este Concepto?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-2">ID Material: <input type="text" class="form-control" name="idMD" id="idMD" readonly value=""></div>
                                    <div class="col-lg-2">ID Proyecto: <input type="text" class="form-control" name="idProy" id="idProy" readonly value=""></div>
                                    <div class="col-lg-4">Descripcion: <input type="text" readonly class="form-control" name="nombreDetCot" id="nombreDetCot" value=""></div>
                                    <div class="col-lg-4">Importe: <input type="text" readonly class="form-control" name="subT" id="subT" value=""></div>
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
            <form class="form" role="form" method="get" action="eliminar_mi">
                <div class="modal fade" id="EliminarMI">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar este Concepto?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-2">ID Material: <input type="text" class="form-control" name="idMI" id="idMI" readonly value=""></div>
                                    <div class="col-lg-2">ID Proyecto: <input type="text" class="form-control" name="idProy" id="idProy" readonly value=""></div>
                                    <div class="col-lg-4">Descripcion: <input type="text" readonly class="form-control" name="nombreDetCot" id="nombreDetCot" value=""></div>
                                    <div class="col-lg-4">Importe: <input type="text" readonly class="form-control" name="subT" id="subT" value=""></div>
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
            <form class="form" role="form" method="get" action="eliminar_mc">
                <div class="modal fade" id="EliminarMC">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar este Concepto?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-2">ID Material: <input type="text" class="form-control" name="idMC" id="idMC" readonly value=""></div>
                                    <div class="col-lg-2">ID Proyecto: <input type="text" class="form-control" name="idProy" id="idProy" readonly value=""></div>
                                    <div class="col-lg-4">Descripcion: <input type="text" readonly class="form-control" name="nombreDetCot" id="nombreDetCot" value=""></div>
                                    <div class="col-lg-4">Importe: <input type="text" readonly class="form-control" name="subT" id="subT" value=""></div>
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
            <form class="form" role="form" method="get" action="eliminar_mo">
                <div class="modal fade" id="EliminarMO">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar este Concepto?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-2">ID Material: <input type="text" class="form-control" name="idMO" id="idMO" readonly value=""></div>
                                    <div class="col-lg-2">ID Proyecto: <input type="text" class="form-control" name="idProy" id="idProy" readonly value=""></div>
                                    <div class="col-lg-5">Material: <input type="text" readonly class="form-control" name="nombreDetCot" id="nombreDetCot" value=""></div>
                                    <div class="col-lg-3">Importe: <input type="text" readonly class="form-control" name="subT" id="subT" value=""></div>
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
