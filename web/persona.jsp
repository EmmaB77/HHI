<%-- 
    Document   : persona
    Created on : 20/04/2016, 06:25:21 PM
    Author     : Emmanuel
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %><!DOCTYPE html>
<%@page import="Modelo.Persona"%>
<%@page import="Modelo.Empleado"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal</title>
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
                $('#tabla_per').dataTable();
                $('#tabla_perd').dataTable();
                $('#tabla_usu').dataTable();
                $('#tabla_emp').dataTable();
            });
        </script>
        <script>
            function mostrar(sel) {
                if (sel.value == "Todos") {
                    $("#tabla_personas").show();
                    $("#tabla_personasd").hide();
                    $("#tabla_usuarios").hide();
                    $("#tabla_empleados").hide();
                } else if (sel.value == "Empleados") {
                    $("#tabla_personas").hide();
                    $("#tabla_personasd").hide();
                    $("#tabla_usuarios").hide();
                    $("#tabla_empleados").show();
                } else if (sel.value == "Usuarios") {
                    $("#tabla_personas").hide();
                    $("#tabla_personasd").hide();
                    $("#tabla_usuarios").show();
                    $("#tabla_empleados").hide();
                } else {
                    $("#tabla_personas").hide();
                    $("#tabla_personasd").show();
                    $("#tabla_usuarios").hide();
                    $("#tabla_empleados").hide();
                }
            }
        </script>
        <script>
            $(document).ready(function (e) {
                $('#ModificarP').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nombre = $(e.relatedTarget).data().nomb;
                    var apellido1 = $(e.relatedTarget).data().app;
                    var apellido2 = $(e.relatedTarget).data().apm;
                    var calle = $(e.relatedTarget).data().call;
                    var num = $(e.relatedTarget).data().nc;
                    var colo = $(e.relatedTarget).data().col;
                    var ciudad = $(e.relatedTarget).data().cd;
                    var est = $(e.relatedTarget).data().edo;
                    var telefono = $(e.relatedTarget).data().tel;
                    var imss = $(e.relatedTarget).data().ns;
                    var curp = $(e.relatedTarget).data().curp;
                    var rfc = $(e.relatedTarget).data().rfc;
                    var fecha = $(e.relatedTarget).data().fec;
                    $(e.currentTarget).find('#idPer').val(id);
                    $(e.currentTarget).find('#nombre').val(nombre);
                    $(e.currentTarget).find('#apellidop').val(apellido1);
                    $(e.currentTarget).find('#apellidom').val(apellido2);
                    $(e.currentTarget).find('#calle').val(calle);
                    $(e.currentTarget).find('#num').val(num);
                    $(e.currentTarget).find('#col').val(colo);
                    $(e.currentTarget).find('#cd').val(ciudad);
                    $(e.currentTarget).find('#edo').val(est);
                    $(e.currentTarget).find('#tel').val(telefono);
                    $(e.currentTarget).find('#imss').val(imss);
                    $(e.currentTarget).find('#curp').val(curp);
                    $(e.currentTarget).find('#rfc').val(rfc);
                    $(e.currentTarget).find('#fechai').val(fecha);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#VerP').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nombre = $(e.relatedTarget).data().nomb;
                    var apellido1 = $(e.relatedTarget).data().app;
                    var apellido2 = $(e.relatedTarget).data().apm;
                    var calle = $(e.relatedTarget).data().call;
                    var num = $(e.relatedTarget).data().nc;
                    var colo = $(e.relatedTarget).data().col;
                    var ciudad = $(e.relatedTarget).data().cd;
                    var est = $(e.relatedTarget).data().edo;
                    var telefono = $(e.relatedTarget).data().tel;
                    var imss = $(e.relatedTarget).data().ns;
                    var curp = $(e.relatedTarget).data().curp;
                    var rfc = $(e.relatedTarget).data().rfc;
                    var fecha = $(e.relatedTarget).data().fec;
                    $(e.currentTarget).find('#idPer').val(id);
                    $(e.currentTarget).find('#nombre').val(nombre);
                    $(e.currentTarget).find('#apellidop').val(apellido1);
                    $(e.currentTarget).find('#apellidom').val(apellido2);
                    $(e.currentTarget).find('#calle').val(calle);
                    $(e.currentTarget).find('#num').val(num);
                    $(e.currentTarget).find('#col').val(colo);
                    $(e.currentTarget).find('#cd').val(ciudad);
                    $(e.currentTarget).find('#edo').val(est);
                    $(e.currentTarget).find('#tel').val(telefono);
                    $(e.currentTarget).find('#imss').val(imss);
                    $(e.currentTarget).find('#curp').val(curp);
                    $(e.currentTarget).find('#rfc').val(rfc);
                    $(e.currentTarget).find('#fechai').val(fecha);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#DefinirE').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nombre = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idPer').val(id);
                    $(e.currentTarget).find('#nombreE').val(nombre);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#DefinirU').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nombre = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idPer').val(id);
                    $(e.currentTarget).find('#nombreE').val(nombre);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#EliminarP').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nombre = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idPer').val(id);
                    $(e.currentTarget).find('#nombreE').val(nombre);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#ModificarE').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nombre = $(e.relatedTarget).data().nombre;
                    var puesto = $(e.relatedTarget).data().pue;
                    var salario = $(e.relatedTarget).data().sal;
                    var info = $(e.relatedTarget).data().info;
                    var cuenta = $(e.relatedTarget).data().cta;
                    var transa = $(e.relatedTarget).data().trans;
                    $(e.currentTarget).find('#idPer').val(id);
                    $(e.currentTarget).find('#nombreE').val(nombre);
                    $(e.currentTarget).find('#puesto').val(puesto);
                    $(e.currentTarget).find('#sal').val(salario);
                    $(e.currentTarget).find('#info').val(info);
                    $(e.currentTarget).find('#banco').val(cuenta);
                    $(e.currentTarget).find('#trans').val(transa);
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
            <h2>Nómina:</h2>
            <div class="row">
                <div class="col-lg-4">
                    <SELECT NAME="personal" onChange="mostrar(this)" class="form-control">
                        <OPTION VALUE="Todos">Todos</OPTION>
                        <OPTION VALUE="Empleados">Empleados</OPTION> 
                        <OPTION VALUE="Usuarios">Usuarios</OPTION> 
                        <OPTION VALUE="Sin Definir">Sin Definir</OPTION> 
                    </SELECT>
                </div>
                <div class="col-lg-3">
                    <a data-toggle="modal" href="#AgregarPersona" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Agregar Persona</a>
                </div>
            </div><br>
            <div class="table-responsive container" id="tabla_personas" style="display:">
                <div class="row">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4"><h3>TODAS LAS PERSONAS</h3></div>
                    <div class="col-lg-4"></div>
                </div>
                <table class="table" id="tabla_per" name="personas">
                    <thead>
                        <tr>
                            <th>NOMBRE</th>
                            <th>TELEFONO</th>
                            <th>RFC</th>
                            <th>CURP</th>
                            <th>NUMERO SEGURO</th>
                            <th>FECHA DE INGRESO</th>
                            <th>ESTATUS</th>
                            <th class="col-lg-2">ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="persona" items="${personas}" varStatus="iter">
                            <tr>
                                <td>${persona.nombrePersona}&nbsp;${persona.apellidoPpersona}&nbsp;${persona.apellidoMpersona}</td>
                                <td>${persona.telefonoPersona}</td>
                                <td>${persona.rfcPersona}</td>
                                <td>${persona.curpPersona}</td>
                                <td>${persona.numSeguroPersona}</td>
                                <td>${persona.fechaIngreso}</td>
                                <td>${persona.estatusPersona}</td>
                                <td class="btn-group">
                                    <a title="Eliminar Persona: Irreversible" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#EliminarP" data-id="${persona.idPersona}" data-nombre="${persona.nombrePersona}&nbsp;${persona.apellidoPpersona}&nbsp;${persona.apellidoMpersona}"><i class="glyphicon glyphicon-remove"></i></a>
                                    <a title="Modificar Persona" data-toggle="modal" href="#" class="btn btn-sm btn-success" role="button" data-target="#ModificarP" data-id="${persona.idPersona}" data-nomb="${persona.nombrePersona}" data-app="${persona.apellidoPpersona}" data-apm="${persona.apellidoPpersona}"
                                       data-call="${persona.callePersona}" data-nc="${persona.numeroPersona}" data-col="${persona.coloniaPersona}" data-cd="${persona.ciudadPersona}" data-edo="${persona.estadoPersona}" data-tel="${persona.telefonoPersona}" data-ns="${persona.numSeguroPersona}" data-curp="${persona.curpPersona}"
                                       data-rfc="${persona.rfcPersona}" data-fec="${persona.fechaIngreso}"><i class="glyphicon glyphicon-edit"></i></a>
                                    <a title="Ver Persona" data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#VerP" data-nomb="${persona.nombrePersona}" data-app="${persona.apellidoPpersona}" data-apm="${persona.apellidoPpersona}"
                                       data-call="${persona.callePersona}" data-nc="${persona.numeroPersona}" data-col="${persona.coloniaPersona}" data-cd="${persona.ciudadPersona}" data-edo="${persona.estadoPersona}" data-tel="${persona.telefonoPersona}" data-ns="${persona.numSeguroPersona}" data-curp="${persona.curpPersona}"
                                       data-rfc="${persona.rfcPersona}" data-fec="${persona.fechaIngreso}"><i class="glyphicon glyphicon-eye-open"></i></a>
                                    
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive container" id="tabla_personasd" style="display:none">
                <div class="row">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4"><h3>PERSONAS SIN DEFINIR</h3></div>
                    <div class="col-lg-4"></div>
                </div>
                <table class="table" id="tabla_perd" name="personas">
                    <thead>
                        <tr>
                            <th>NOMBRE</th>
                            <th>TELEFONO</th>
                            <th>RFC</th>
                            <th>CURP</th>
                            <th>NUMERO SEGURO</th>
                            <th>FECHA DE INGRESO</th>
                            <th>DEFINIR</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="persona" items="${personasd}" varStatus="iter">
                            <tr>
                                <td>${persona.nombrePersona}&nbsp;${persona.apellidoPpersona}&nbsp;${persona.apellidoMpersona}</td>
                                <td>${persona.telefonoPersona}</td>
                                <td>${persona.rfcPersona}</td>
                                <td>${persona.curpPersona}</td>
                                <td>${persona.numSeguroPersona}</td>
                                <td>${persona.fechaIngreso}</td>
                                <td class="btn-group">
                                    <a title="Definir Como Empleado" data-toggle="modal" href="#" class="btn btn-sm btn-warning" role="button" data-target="#DefinirE" data-id="${persona.idPersona}" data-nombre="${persona.nombrePersona} ${persona.apellidoPpersona} ${persona.apellidoMpersona}"><i class="glyphicon glyphicon-wrench"></i></a>
                                    <a title="Definir Como Usuario" data-toggle="modal" href="#" class="btn btn-sm btn-default" role="button" data-target="#DefinirU" data-id="${persona.idPersona}" data-nombre="${persona.nombrePersona} ${persona.apellidoPpersona} ${persona.apellidoMpersona}"><i class="glyphicon glyphicon-briefcase"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive container" id="tabla_empleados" style="display:none">
                <div class="row" align="center">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4"><h3>EMPLEADOS</h3></div>
                    <div class="col-lg-4"></div>
                </div>
                <table class="table" id="tabla_emp" name="personas">
                    <thead>
                        <tr>
                            <th>NOMBRE</th>
                            <th>SALARIO X DIA</th>
                            <th>PUESTO</th>
                            <th>INFONAVIT</th>
                            <th>CUENTA DE BANCO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}" varStatus="iter">
                            <tr>
                                <td>${empleado.persona.nombrePersona}&nbsp;${empleado.persona.apellidoPpersona}&nbsp;${empleado.persona.apellidoMpersona}</td>
                                <td>${empleado.salarioxdia}</td>
                                <td>${empleado.puesto}</td>
                                <td>${empleado.infonavit}</td>
                                <td>${empleado.cuentaB}</td>
                                <td>
                                    <a title="Modificar Empleado" data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#ModificarE" data-id="${empleado.idEmpleado}" data-nombre="${empleado.persona.nombrePersona}&nbsp;${empleado.persona.apellidoPpersona}&nbsp;${empleado.persona.apellidoMpersona}"
                                       data-sal="${empleado.salarioxdia}" data-pue="${empleado.puesto}" data-info="${empleado.infonavit}" data-cta="${empleado.cuentaB}" data-trans="${empleado.transa}"><i class="glyphicon glyphicon-edit"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive container" id="tabla_usuarios" style="display:none">
                <div class="row" align="center">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4"><h3>USUARIOS</h3></div>
                    <div class="col-lg-4"></div>
                </div>
                <table class="table" id="tabla_usu" name="personas">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuarios}" varStatus="iter">
                            <tr>
                                <td>${usuario.idUsuario}</td>
                                <td>${usuario.persona.nombrePersona}&nbsp;${usuario.persona.apellidoPpersona}&nbsp;${usuario.persona.apellidoMpersona}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form" role="form" method="post" action="agregar_persona">
                <div class="modal fade" id="AgregarPersona">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header" align="center">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Agregar Persona</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-4">Nombre:<input type="text" class="form-control" id="nombre" name="nombre" required></div>
                                    <div class="col-lg-4">Apellido Paterno: <input type="text" class="form-control" id="apellidop" name="apellidop"></div>
                                    <div class="col-lg-4">Apellido Materno: <input type="text" class="form-control" id="apellidom" name="apellidom"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Calle: <input type="text" class="form-control" id="calle" name="calle"></div>
                                    <div class="col-lg-2">Num: <input type="text" class="form-control" id="num" name="num"></div>
                                    <div class="col-lg-3">Colonia: <input type="text" class="form-control" id="col" name="col"></div>
                                    <div class="col-lg-3">Ciudad: <input type="text" class="form-control" id="cd" name="cd"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Estado:<input type="text" class="form-control" id="edo" name="edo" required></div>
                                    <div class="col-lg-4">Telefono: <input type="text" class="form-control" id="tel" name="tel"></div>
                                    <div class="col-lg-4">Numero IMSS: <input type="text" class="form-control" id="imss" name="imss"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">CURP:<input type="text" class="form-control" id="curp" name="curp" required></div>
                                    <div class="col-lg-4">RFC: <input type="text" class="form-control" id="rfc" name="rfc"></div>
                                    <div class="col-lg-4">Fecha de Ingreso: <input type="date" class="form-control" id="fechai" name="fechai"></div>
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
            <form class="form" role="form" method="post" action="modificar_persona">
                <div class="modal fade" id="ModificarP">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header" align="center">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Cambiar Datos de Persona</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">ID: <input type="text" class="form-control" id="idPer" name="idPer" readonly></div>
                                    <div class="col-lg-4">Nombre:<input type="text" class="form-control" id="nombre" name="nombre" required></div>
                                    <div class="col-lg-3">Apellido Paterno: <input type="text" class="form-control" id="apellidop" name="apellidop" required></div>
                                    <div class="col-lg-3">Apellido Materno: <input type="text" class="form-control" id="apellidom" name="apellidom" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Calle: <input type="text" class="form-control" id="calle" name="calle" required></div>
                                    <div class="col-lg-2">Num: <input type="text" class="form-control" id="num" name="num" required></div>
                                    <div class="col-lg-3">Colonia: <input type="text" class="form-control" id="col" name="col" required></div>
                                    <div class="col-lg-3">Ciudad: <input type="text" class="form-control" id="cd" name="cd" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Estado:<input type="text" class="form-control" id="edo" name="edo" required></div>
                                    <div class="col-lg-4">Telefono: <input type="text" class="form-control" id="tel" name="tel" required></div>
                                    <div class="col-lg-4">Numero IMSS: <input type="text" class="form-control" id="imss" name="imss" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">CURP:<input type="text" class="form-control" id="curp" name="curp" required></div>
                                    <div class="col-lg-4">RFC: <input type="text" class="form-control" id="rfc" name="rfc" required></div>
                                    <div class="col-lg-4">Fecha de Ingreso: <input type="date" class="form-control" id="fechai" name="fechai" required></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-info">Modificar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div class="modal fade" id="VerP">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h3 class="modal-title">Datos Persona</h3>
                        </div>
                        <div class="table container modal-body">
                            <div class="row form-group">
                                <div class="col-lg-4">Nombre:<input type="text" class="form-control" id="nombre" name="nombre" readonly></div>
                                <div class="col-lg-4">Apellido Paterno: <input type="text" class="form-control" id="apellidop" name="apellidop" readonly></div>
                                <div class="col-lg-4">Apellido Materno: <input type="text" class="form-control" id="apellidom" name="apellidom" readonly></div>
                            </div>
                            <div class="row form-group">
                                <div class="col-lg-4">Calle: <input type="text" class="form-control" id="calle" name="calle" readonly></div>
                                <div class="col-lg-2">Num: <input type="text" class="form-control" id="num" name="num" readonly></div>
                                <div class="col-lg-3">Colonia: <input type="text" class="form-control" id="col" name="col" readonly></div>
                                <div class="col-lg-3">Ciudad: <input type="text" class="form-control" id="cd" name="cd" readonly></div>
                            </div>
                            <div class="row form-group">
                                <div class="col-lg-4">Estado:<input type="text" class="form-control" id="edo" name="edo" readonly></div>
                                <div class="col-lg-4">Telefono: <input type="text" class="form-control" id="tel" name="tel" readonly></div>
                                <div class="col-lg-4">Numero IMSS: <input type="text" class="form-control" id="imss" name="imss" readonly></div>
                            </div>
                            <div class="row form-group">
                                <div class="col-lg-4">CURP:<input type="text" class="form-control" id="curp" name="curp" readonly></div>
                                <div class="col-lg-4">RFC: <input type="text" class="form-control" id="rfc" name="rfc" readonly></div>
                                <div class="col-lg-4">Fecha de Ingreso: <input type="date" class="form-control" id="fechai" name="fechai" readonly></div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                        </div>
                    </div>
                </div>
            </div>
            <form class="form" role="form" method="post" action="agregar_empleado">
                <div class="modal fade" id="DefinirE">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header" align="center">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Definir como empleado a:</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">ID: <input type="text" class="form-control" id="idPer" name="idPer" readonly></div>
                                    <div class="col-lg-6">Nombre:<input type="text" class="form-control" id="nombreE" name="nombreE" readonly></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Puesto: <input type="text" class="form-control" id="puesto" name="puesto" required></div>
                                    <div class="col-lg-4">Salario Por Día: <input type="number" class="form-control" id="sal" name="sal" required step="any"></div>
                                    <div class="col-lg-4">Infonavit: <input type="number" class="form-control" id="info" name="info" required step="any"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Cuenta Banco:<input type="text" class="form-control" id="banco" name="banco" required></div>
                                    <div class="col-lg-4">Transaccion: <input type="number" class="form-control" id="trans" name="trans" required step="any"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-warning">Definir</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="post" action="modificar_empleado">
                <div class="modal fade" id="ModificarE">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header" align="center">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Cambiar datos Empleado:</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">ID: <input type="text" class="form-control" id="idPer" name="idPer" readonly></div>
                                    <div class="col-lg-6">Nombre:<input type="text" class="form-control" id="nombreE" name="nombreE" readonly></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Puesto: <input type="text" class="form-control" id="puesto" name="puesto" required></div>
                                    <div class="col-lg-4">Salario Por Día: <input type="number" class="form-control" id="sal" name="sal" required step="any"></div>
                                    <div class="col-lg-4">Infonavit: <input type="number" class="form-control" id="info" name="info" required step="any"></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-4">Cuenta Banco:<input type="text" class="form-control" id="banco" name="banco" required></div>
                                    <div class="col-lg-4">Transaccion: <input type="number" class="form-control" id="trans" name="trans" required step="any"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-warning">Cambiar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="get" action="definir_usuario">
                <div class="modal fade" id="DefinirU">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header" align="center">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Definir como Usuario a:</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">ID: <input type="text" class="form-control" id="idPer" name="idPer" readonly></div>
                                    <div class="col-lg-6">Nombre:<input type="text" class="form-control" id="nombreE" name="nombreE" readonly></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-default">Definir</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="get" action="eliminar_persona">
                <div class="modal fade" id="EliminarP">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header" align="center">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Deseas dar de baja a?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-2">ID: <input type="text" class="form-control" id="idPer" name="idPer" readonly></div>
                                    <div class="col-lg-6">Nombre:<input type="text" class="form-control" id="nombreE" name="nombreE" readonly></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-danger">Aceptar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
