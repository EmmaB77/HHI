<%-- 
    Document   : controlInventario
    Created on : 21/10/2015, 11:48:14 AM
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Modelo.Inventario" %>
<%@page import="Conexion.Conexion" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Herramientas</title>
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
                $('#tabla_tool').dataTable();
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Update').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var desc = $(e.relatedTarget).data().desc;
                    var obs = $(e.relatedTarget).data().osb;
                    var cant = $(e.relatedTarget).data().cant;
                    $(e.currentTarget).find('#idu').val(id);
                    $(e.currentTarget).find('#descu').val(desc);
                    $(e.currentTarget).find('#obseu').val(obs);
                    $(e.currentTarget).find('#cantu').val(cant);
                });
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Eliminar').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id;
                    var nom = $(e.relatedTarget).data().nombre;
                    $(e.currentTarget).find('#idHerramienta').val(id);
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
            <h3>Herramienta en el Inventario</h3>
            <div><a data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Agregar</a></div>
            <br><br>
            <div class="table table-responsive">
                <table class="table" id="tabla_tool" name="inventario">
                    <thead>
                        <tr>
                            <td class="col-lg-1">ID</td>
                            <td class="col-lg-4">Descripción</td>
                            <td class="col-lg-1">Cantidad</td>
                            <td class="col-lg-1">Unidad</td>
                            <td class="col-lg-2">Observaciones</td>
                            <td class="col-lg-2">Estatus</td>
                            <td class="col-lg-1">Eliminar/Actualizar</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="herramienta" items="${herramientas}" varStatus="iter">
                            <tr>
                                <td>${herramienta.idHerramienta}</td>
                                <td>${herramienta.descHerramienta}</td>
                                <td>${herramienta.cantidadHerramienta}</td>
                                <td>${herramienta.tipoUniHerramienta}</td>
                                <td>${herramienta.observacionesHerramienta}</td>
                                <td>${herramienta.estatusHerramienta}</td>
                                <td>
                                    <a title="Eliminar Concepto" data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#Eliminar" data-id="${herramienta.idHerramienta}" data-nombre="${herramienta.descHerramienta}"><i class="glyphicon glyphicon-remove"></i></a>
                                    <a data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#Update" data-id="${herramienta.idHerramienta}" data-osb="${herramienta.observacionesHerramienta}" data-cant="${herramienta.cantidadHerramienta}" data-desc="${herramienta.descHerramienta}"><i class="glyphicon glyphicon-floppy-open"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table">
                <form class="form" role="form" method="post" action="agregar_tool" >
                    <div class="modal fade" id="myModal">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Agregar Herramienta</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <div>Descripcion:<input type="text" class="form-control" name="desc" id="desc" required></div>
                                        <div>Cantidad:<input type="number" class="form-control" name="cant" id="cant" required></div>
                                        <div>Unidad:<select class="form-control" name="uni" id="uni" required>
                                                <option value="PIEZA">PIEZA</option>
                                                <option value="JUEGO">JUEGO</option>
                                            </select>
                                        </div>
                                        <div>Observaciones:<textarea class="form-control" style="resize: none" name="obse" id="obse" required></textarea></div>
                                        <div>Estatus:<select class="form-control" name="est" id="est">
                                                <option value="En Almacen">En Almacen</option>
                                                <option value="Por Reparar">Por Reparar</option>
                                                <option value="Prestada">Prestado</option>
                                                <option value="Reemplazar">Reemplazar</option>
                                                <OPTION value="Perdida">Perdida</OPTION>
                                            </select></div>
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
                <form class="form" role="form" method="post" action="modificar_tool">
                    <div class="modal" id="Update">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Actualizar Herramienta</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        ID de la Herramienta:<input type="text" class="form-control" name="idu" id="idu" value="" readonly><br>
                                        Descripcion:<input type="text" class="form-control" name="descu" id="descu" required>
                                        Cantidad:<input type="number" class="form-control" name="cantu" id="cantu" required>
                                        Unidad:<select class="form-control" name="uniu" id="uniu">
                                            <option value="PIEZA">PIEZA</option>
                                            <option value="JUEGO">JUEGO</option>
                                        </select>
                                        Observaciones:<textarea class="form-control" style="resize: none" name="obseu" id="obseu" required></textarea>
                                        Estatus:<select class="form-control" name="estu" id="estu">
                                            <option value="En Almacen">En Almacen</option>
                                            <option value="Roto">Roto</option>
                                            <option value="Prestada">Prestado</option>
                                            <option value="Reemplazar">Reemplazar</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="summit" class="btn btn-success">Actualizar</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <form class="form" role="form" method="get" action="eliminar_tool">
                    <div class="modal fade" id="Eliminar">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h3 class="modal-title">¿Estas Seguro de Eliminar esta Herramienta?</h3>
                                </div>
                                <div class="table container modal-body">
                                    <div class="form-group">
                                        <div class="col-lg-3">ID: <input type="text" class="form-control" name="idHerramienta" id="idHerramienta" readonly value=""></div>
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
            </div>
        </div>
    </body>
</html>