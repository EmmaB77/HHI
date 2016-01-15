<%-- 
    Document   : gastoIndirecto
    Created on : 21/10/2015, 09:59:07 AM
    Author     : Usuario
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %><!DOCTYPE html>
<%@page import="Modelo.GastoIndirecto"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gastos Indirectos</title>
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
                $('#tabla_indi').dataTable();
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
                    var date = $(e.relatedTarget).data().fecha;
                    var mes = $(e.relatedTarget).data().mes;
                    $(e.currentTarget).find('#idU').val(id);
                    $(e.currentTarget).find('#provU').val(prov);
                    $(e.currentTarget).find('#factU').val(fact);
                    $(e.currentTarget).find('#descU').val(desc);
                    $(e.currentTarget).find('#subtU').val(subt);
                    $(e.currentTarget).find('#fechaU').val(date);
                    $(e.currentTarget).find('#mesU').val(mes);
                });
            })                                                                                                                                                                                                                                                                                                                                                                                                              ;
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
            <h3>Gastos Indirectos</h3>
            <div><a data-toggle="modal" href="#AgregarIndirecto" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Agregar</a></div><br>
            <div class="table-responsive container">
                <table class="table" id="tabla_indi" name="indirectos">
                    <thead>
                        <tr>
                            <td>ID:</td>
                            <td class="col-lg-1">Fecha:</td>
                            <td>Mes:</td>
                            <td>Proveedor:</td>
                            <td>Numero de Factura:</td>
                            <td class="col-lg-2">Descripcion:</td>
                            <td>Sub-Total</td>
                            <td>IVA</td>
                            <td>TOTAL</td>
                            <td>Eliminar/Modificar </td>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="indirecto" items="${indirectos}" varStatus="iter">
                        <tr>
                            <td>${indirecto.idIndirect}</td>
                            <td>${indirecto.fechaIndirect}</td>
                            <td>${indirecto.mesIndirect}</td>
                            <td>${indirecto.proveeIndirect}</td>
                            <td>${indirecto.numFactIndirect}</td>
                            <td>${indirecto.descIndirect}</td>
                            <td>$ ${indirecto.subToIndirect}</td>
                            <td>$ ${indirecto.ivaIndirect}</td>
                            <td>$ ${indirecto.totalIndirect}</td>
                            <td>
                                <a href="eliminar_indi?idIndi=${indirecto.idIndirect}" class="btn btn-sm btn-danger" role="button"><i class="glyphicon glyphicon-remove"></i></a>
                                <a data-toggle="modal" href="#" class="btn btn-sm btn-info" role="button" data-target="#Update" data-id="${indirecto.idIndirect}" data-fecha="${indirecto.fechaIndirect}" data-mes="${indirecto.mesIndirect}" data-prov="${indirecto.proveeIndirect}" data-fact="${indirecto.numFactIndirect}" data-desc="${indirecto.descIndirect}" data-subt="${indirecto.subToIndirect}" ><i class="glyphicon glyphicon-floppy-open"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form" role="form" method="post" action="agregar_indi" >
                <div class="modal fade" id="AgregarIndirecto">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">Agregar Gasto Indirecto</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    Fecha:<input type="date" class="form-control" name="fecha" id="fecha">
                                    Mes:<select class="form-control" name="mes" id="mes">
                                        <option value="...">...</option>
                                        <option value="Enero">Enero</option>
                                        <option value="Febrero">Febrero</option>
                                        <option value="Marzo">Marzo</option>
                                        <option value="Abril">Abril</option>
                                        <option value="Mayo">Mayo</option>
                                        <option value="Junio">Junio</option>
                                        <option value="Julio">Julio</option>
                                        <option value="Agosto">Agosto</option>
                                        <option value="Septiembre">Septiembre</option>
                                        <option value="Octubre">Octubre</option>
                                        <option value="Noviembre">Noviembre</option>
                                        <option value="Diciembre">Diciembre</option>
                                    </select>
                                    Proveedor:<input type="text" class="form-control" name="prov" id="prov">
                                    Factura:<input type="text" class="form-control" name="fact" id="fact">
                                    Descripción:<textarea class="form-control" style="resize: none" name="desc" id="desc"></textarea>
                                    Subtotal: <input type="number" step="any" class="form-control" name="subt" id="subt">
                                    I.V.A
                                    <select class="form-control" name="iva" id="iva">
                                        <option value="#">...</option>
                                        <option value="si">SI</option>
                                        <Option value="no">NO</option>
                                    </select>
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
            <form class="form" role="form" method="post" action="actualizar_indi" >
                <div class="modal fade" id="Update">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">Modificar Gasto Indirecto</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    ID:<input type="text" class="form-control" name="idU" id="idU" readonly>
                                    Fecha:<input type="date" class="form-control" name="fechaU" id="fechaU">
                                    Mes:<select class="form-control" name="mesU" id="mesU">
                                        <option value="...">...</option>
                                        <option value="Enero">Enero</option>
                                        <option value="Febrero">Febrero</option>
                                        <option value="Marzo">Marzo</option>
                                        <option value="Abril">Abril</option>
                                        <option value="Mayo">Mayo</option>
                                        <option value="Junio">Junio</option>
                                        <option value="Julio">Julio</option>
                                        <option value="Agosto">Agosto</option>
                                        <option value="Septiembre">Septiembre</option>
                                        <option value="Octubre">Octubre</option>
                                        <option value="Noviembre">Noviembre</option>
                                        <option value="Diciembre">Diciembre</option>
                                    </select>
                                    Proveedor:<input type="text" class="form-control" name="provU" id="provU">
                                    Factura:<input type="text" class="form-control" name="factU" id="factU">
                                    Descripción:<textarea class="form-control" style="resize: none" name="descU" id="descU"></textarea>
                                    Subtotal: <input type="number" step="any" class="form-control" name="subtU" id="subtU">
                                    I.V.A
                                    <select class="form-control" name="ivaU" id="ivaU">
                                        <option value="#">...</option>
                                        <option value="si">SI</option>
                                        <Option value="no">NO</option>
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
        </div>
    </body>
</html>  