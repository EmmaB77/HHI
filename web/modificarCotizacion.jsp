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
        <script>
            $(document).ready(function (e) {
                $('#Concepto').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var inci = $(e.relatedTarget).data().inc;
                    var desc = $(e.relatedTarget).data().desc;
                    var cant = $(e.relatedTarget).data().cant;
                    var prec = $(e.relatedTarget).data().prec;
                    $(e.currentTarget).find('#idcotDet').val(id);
                    $(e.currentTarget).find('#inciso').val(inci);
                    $(e.currentTarget).find('#descon').val(desc);
                    $(e.currentTarget).find('#canti').val(cant);
                    $(e.currentTarget).find('#pu').val(prec);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Eliminar').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var idCot = $(e.relatedTarget).data().id2;
                    var nom = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idDetCot').val(id);
                    $(e.currentTarget).find('#idCoti').val(idCot);
                    $(e.currentTarget).find('#nombreDetCot').val(nom);
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
            <form class="form" role="form" method="post" action="modificar_cot">
                <div class="table container">
                    <c:forEach var="cotizacion" items="${cotizaciones}" varStatus="iter">
                        <div class="row form-group">
                            <div class="col-lg-2">ID Cotizacion <input type="text" class="form-control" id="idCoti" name="idCoti" value="${cotizacion.idCot}"></div>
                            <div class="col-lg-6">Título:<input type="text" class="form-control" id="titulo" name="titulo" value="${cotizacion.tituloCot}"></div>
                            <div class="col-lg-4">Referencia: <input type="text" class="form-control" id="referencia" name="referencia" value=" ${cotizacion.referencia}"></div>
                        </div>
                        <div class="row form-group">
                            <div class="col-lg-3">Fecha de Solicitud: <input type="date" class="form-control" id="fechasol" name="fechasol" value="${cotizacion.fechaSolCot}"></div>
                            <div class="col-lg-3">Fecha de Cotizacion: <input type="date" class="form-control" id="fechacot" name="fechacot" value="${cotizacion.fechaCot}"></div>
                            <div class="col-lg-3">Solicitud: <input type="text" class="form-control" id="solCot" name="solCot" value="${cotizacion.solCot}"></div>
                            <div class="col-lg-3">Cotización: <input type="text" class="form-control" id="coti" name="coti" value="${cotizacion.numCot}"></div>
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
                            <div class="col-lg-6">Descripción:<textarea class="form-control" style="resize:none" id="desc" name="desc" >${cotizacion.descCot}</textarea></div>
                            <div class="col-lg-3">Tiempo de Entrega: <input type="text" class="form-control" id="timen" name="timen" value="${cotizacion.tiempoEntrega}"></div>
                        </div>
                        <div><h4>Total</h4></div>
                        <div class="row form-group">
                            <div class="col-lg-3">Total: <input type="text" class="form-control" id="totalnum" name="totalnum" value="${cotizacion.total}"></div>
                            <div class="col-lg-6">Total Letra: <input type="text" class="form-control" id="totaletra" name="totaletra" value="${cotizacion.canLetCot}"></div>
                        </div>
                        <button type="summit" class="btn btn-success">Modificar</button>
                    </c:forEach>
                </div>
            </form><br><br>
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
                            <th style="color: #1C77D8"><h5><b>ACCIONES</b></h5></th>
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
                                <td>
                                    <a title="Modificar Concepto" data-toggle="modal" href="#" class="btn btn-sm btn-success" role="button" data-target="#Concepto" data-id="${detalle.idCotDet}" data-inc="${detalle.incisoCotDet}" data-desc="${detalle.descCotDet}" data-cant="${detalle.cantCotDet}" 
                                       data-uni="${detalle.uniCotDet}" data-prec="${detalle.precioUni}"><i class="glyphicon glyphicon-file"></i></a>
                                    <a title="Eliminar Detalle Cotizacion" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#Eliminar" data-id="${detalle.idCotDet}" data-nombre="${detalle.descCotDet}" data-id2="${detalle.idCot}"><i class="glyphicon glyphicon-remove"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form" role="form" method="post" action="modificar_concp">
                <div class="modal fade" id="Concepto">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Modificar Concepto de Cotización</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="idcotDet" id="idcotDet" value="" readonly hidden="">
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
                                <button type="summit" class="btn btn-success">Modificar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <form class="form" role="form" method="get" action="eliminar_det">
                <div class="modal fade" id="Eliminar">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">¿Estas Seguro de Eliminar este Concepto?</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="form-group">
                                    <div class="col-lg-3">ID Detalle: <input type="text" class="form-control" name="idDetCot" id="idDetCot" readonly value=""></div>
                                    <div class="col-lg-3">ID Cotización: <input type="text" class="form-control" name="idCoti" id="idCoti" readonly value=""></div>
                                    <div class="col-lg-6">Cotizacion: <input type="text" readonly class="form-control" name="nombreDetCot" id="nombreDetCot" value=""></div>
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

