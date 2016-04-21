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
        <script>
            $(document).ready(function (e) {
                $('#Concepto').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    $(e.currentTarget).find('#idcot').val(id);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Eliminar').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nom = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idCoti').val(id);
                    $(e.currentTarget).find('#nombreCot').val(nom);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Otros').on('show.bs.modal', function (e) {
                    var numcot = $(e.relatedTarget).data().cot;
                    var orden = $(e.relatedTarget).data().orden;
                    var avance = $(e.relatedTarget).data().avance;
                    var factura = $(e.relatedTarget).data().facturas;
                    var usuario = $(e.relatedTarget).data().usuario;
                    $(e.currentTarget).find('#numcot').val(numcot);
                    $(e.currentTarget).find('#orden').val(orden);
                    $(e.currentTarget).find('#avance').val(avance);
                    $(e.currentTarget).find('#fact').val(factura);
                    $(e.currentTarget).find('#user').val(usuario);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#OrdenComp').on('show.bs.modal', function (e) {
                    var numcot = $(e.relatedTarget).data().cot;
                    var usuario = $(e.relatedTarget).data().usuario;
                    $(e.currentTarget).find('#numcotoc').val(numcot);
                    $(e.currentTarget).find('#useroc').val(usuario);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Factura').on('show.bs.modal', function (e) {
                    var numcot = $(e.relatedTarget).data().cot;
                    var usuario = $(e.relatedTarget).data().usuario;
                    var factura = $(e.relatedTarget).data().fact;
                    $(e.currentTarget).find('#numcotfa').val(numcot);
                    $(e.currentTarget).find('#userfa').val(usuario);
                    $(e.currentTarget).find('#facturan').val(factura);
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
                                <td><h6>${cotizacion.numCot}</h6></td>
                                <td><h6>${cotizacion.referencia}</h6></td>
                                <td><h6>${cotizacion.solCot}</h6></td>
                                <td class="col-lg-4"><h6>${cotizacion.tituloCot}</h6></td>
                                <td><h6>${cotizacion.fechaCot}</h6></td>
                                <td class="col-lg-1"><h6>$ ${cotizacion.total} M.N.</h6></td>
                                <td><h6>${cotizacion.estatusCot}</h6></td>
                                <td class="col-lg-2 btn-group">
                                    <a title="Agregar Concepto" data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#Concepto" data-id="${cotizacion.idCot}"><i class="glyphicon glyphicon-plus"></i></a>
                                    <a title="Otros Detalles" data-toggle="modal" href="#" class="btn btn-sm btn-warning" role="button" data-target="#Otros" data-cot="${cotizacion.numCot}" data-orden="${cotizacion.ordComCot}" data-avance="${cotizacion.avanceCot}" data-facturas="${cotizacion.numFactCot}" data-usuario="${cotizacion.usuario.persona.nombrePersona}&nbsp;${cotizacion.usuario.persona.apellidoPpersona}&nbsp;${cotizacion.usuario.persona.apellidoMpersona}"><i class="glyphicon glyphicon-eye-open"></i></a>
                                    <a title="Asignar Orden de Compra" data-toggle="modal" href="#" class="btn btn-sm btn-default" role="button" data-target="#OrdenComp" data-cot="${cotizacion.numCot}" data-usuario="${cotizacion.usuario.persona.nombrePersona}&nbsp;${cotizacion.usuario.persona.apellidoPpersona}&nbsp;${cotizacion.usuario.persona.apellidoMpersona}"><i class="glyphicon glyphicon-star"></i></a>
                                    <a title="Agregar Factura" data-toggle="modal" href="#" class="btn btn-sm btn-success" role="button" data-target="#Factura" data-cot="${cotizacion.numCot}" data-usuario="${cotizacion.usuario.persona.nombrePersona}&nbsp;${cotizacion.usuario.persona.apellidoPpersona}&nbsp;${cotizacion.usuario.persona.apellidoMpersona}" data-fact="${cotizacion.numFactCot}"><i class="glyphicon glyphicon-copy"></i></a>
                                    <a title="Eliminar Cotizacion" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#Eliminar" data-id="${cotizacion.idCot}" data-nombre="${cotizacion.tituloCot}"><i class="glyphicon glyphicon-remove"></i></a>
                                    <a title="Ver Cotizacion" href="ver_cot?idCoti=${cotizacion.idCot}" class="btn btn-sm btn-info" role="button"><i class="glyphicon glyphicon-file"></i></a>
                                    <a title="Modificar Cotizacion" href="mod_cot?idCoti=${cotizacion.idCot}" class="btn btn-sm btn-success" role="button"><i class="glyphicon glyphicon-edit"></i></a>
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
                                    <div class="col-lg-3">Solicitud: <input type="text" class="form-control" id="solCot" name="solCot"></div>
                                    <div class="col-lg-3">Cotización: <input type="text" class="form-control" id="coti" name="coti"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Usuario: 
                                        <select class="form-control" id="usuario" name="usuario">
                                            <c:forEach var="usuario" items="${usuarios}" varStatus="iter">
                                                <option value="${usuario.idUsuario}">${usuario.persona.nombrePersona}&nbsp;${usuario.persona.apellidoPpersona}&nbsp;${usuario.persona.apellidoMpersona}</option>
                                            </c:forEach>
                                        </select></div>
                                    <div class="col-lg-4">Ejecutor: 
                                        <select class="form-control" id="ejecutor" name="ejecutor">
                                            <c:forEach var="empleado" items="${empleados}" varStatus="iter">
                                                <option value="${empleado.idEmpleado}">${empleado.persona.nombrePersona}&nbsp;${empleado.persona.apellidoPpersona}&nbsp;${empleado.persona.apellidoMpersona}</option>
                                            </c:forEach>
                                        </select></div>
                                    <div class="col-lg-3">Estatus: <select class="form-control" name="estatus" id="estatus">
                                            <option value="Cotizado">Cotizado</option>
                                            <option value="En Proceso">En Proceso</option>
                                            <option value="Cancelada">Cancelada</option>
                                        </select></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-6">Descripción:<textarea class="form-control" style="resize:none" id="desc" name="desc"></textarea></div>
                                    <div class="col-lg-3">Tiempo de Entrega: <input type="text" class="form-control" id="timen" name="timen"></div>
                                </div>
                                <div><h4>Total</h4></div>
                                <div class="row form-group">
                                    <div class="col-lg-3">Total: <input type="text" class="form-control" id="totalnum" name="totalnum"></div>
                                    <div class="col-lg-6">Total Letra: <input type="text" class="form-control" id="totaletra" name="totaletra"></div>
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
            <form class="form" role="form" method="post" action="agregar_concp">
                <div class="modal fade" id="Concepto">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Concepto de Cotización</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-1">ID:<input type="text" class="form-control" name="idcot" id="idcot" value="" readonly></div>
                                    <div class="col-lg-2">Inciso:<input type="number" class="form-control" name="inciso" id="inciso" required></div>
                                    <div class="col-lg-9">Descripcion<input type="text" class="form-control" name="descon" id="descon" required></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-3">Cantidad:<input type="number" class="form-control" name="canti" id="canti" required></div>
                                    <div class="col-lg-3">Unidad:
                                        <select class="form-control" name="unidad" id="unidad" required>
                                            <option value="SERVICIO">SERVICIO</option>
                                            <option value="PIEZA">PIEZA</option>
                                            <option value="LOTE">LOTE</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-4">Precio Unitario: <input type="number" class="form-control" name="pu" id="pu" required></div>
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
            <div class="modal fade" id="Otros">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h3 class="modal-title">Datos Adicionales</h3>
                        </div>
                        <div class="table container modal-body">
                            <div class="form-group">
                                <div class="col-lg-3">Cotizacion: <input type="text" class="form-control" name="numcot" id="numcot" readonly value=""></div>
                                <div class="col-lg-4">Orden de Compra: <input type="text" class="form-control" name="orden" id="orden" readonly value=""></div>
                                <div class="col-lg-4">Usuario: <input type="text" class="form-control" name="user" id="user" readonly value=""></div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-3">Avance: <input type="text" class="form-control" name="avance" id="avance" readonly value=""></div>
                                <div class="col-lg-4">Facturas: <input type="text" class="form-control" name="fact" id="fact" readonly value=""></div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                        </div>
                    </div>
                </div>
            </div>
            <form class="form" role="form" method="post" action="asignar_orden">
                <div class="modal fade" id="OrdenComp">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Asignar Orden de Compra</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-3">Cotizacion: <input type="text" class="form-control" name="numcotoc" id="numcotoc" readonly value=""></div>
                                    <div class="col-lg-4">Nueva Orden de Compra: <input type="text" class="form-control" name="ordenc" id="ordenc"></div>
                                    <div class="col-lg-4">Usuario: <input type="text" class="form-control" name="useroc" id="useroc" readonly value=""></div>
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
            <form class="form" role="form" method="post" action="facturar">
                <div class="modal fade" id="Factura">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Factura a Cotizacion</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-3">Cotizacion: <input type="text" class="form-control" name="numcotfa" id="numcotfa" readonly value=""></div>
                                    <div class="col-lg-3">Usuario: <input type="text" class="form-control" name="userfa" id="userfa" readonly value=""></div>
                                    <div class="col-lg-3">Nueva Factura: <input type="text" class="form-control" name="facturan" id="facturan"></div>
                                    <div class="col-lg-3">Avance:<input type="text" class="form-control" name="avance" id="avance"></div>
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
            <form class="form" role="form" method="get" action="eliminar_cot">
                <div class="modal fade" id="Eliminar">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar esta Cotización?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-3">ID: <input type="text" class="form-control" name="idCoti" id="idCoti" readonly value=""></div>
                                    <div class="col-lg-5">Cotizacion: <input type="text" readonly class="form-control" name="nombreCot" id="nombreCot" value=""></div>
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
