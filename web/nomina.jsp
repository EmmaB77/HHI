<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %><!DOCTYPE html>
<%@page import="Modelo.nomina"%>
<%@page import="Modelo.Proyecto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nómina</title>
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
                $('#tabla_pro').dataTable();
            });
        </script>
        <script>
            $(document).ready(function (e) {
                $('#Quitar').on('show.bs.modal', function (e) {
                    var id = $(e.relatedTarget).data().id1;
                    var prov = $(e.relatedTarget).data().id2;
                    $(e.currentTarget).find('#idEmD').val(id);
                    $(e.currentTarget).find('#idNomD').val(prov);
                });
            });
        </script>
        <script>
            function mostrar(sel) {
                if (sel.value == "horas") {
                    $("#tabla-horas").show();
                    $("#tabla-trabajos").hide();
                } else {
                    $("#tabla-horas").hide();
                    $("#tabla-trabajos").show();
                }
            }
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
        <div class="container">
            <h2>Nómina:</h2>
            <div class="row">
                <div class="col-lg-4">
                    <SELECT NAME="nominas" onChange="mostrar(this)" class="form-control">
                        <OPTION VALUE="horas">Ver por Horas</OPTION>
                        <OPTION VALUE="trabajos">Ver por Trabajos</OPTION> 
                    </SELECT>
                </div>
                <div class="col-lg-3">
                    <a data-toggle="modal" href="#calcularnom" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Calcular</a>
                </div>
            </div><br>
            <div class="table-responsive container" id="tabla-horas" style="display:">
                <table class="table" id="tabla_cot" name="nomina">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Empleado</th>
                            <th>Semana</th>
                            <th>Vie</th>
                            <th>Lun</th>
                            <th>Mar</th>
                            <th>Mier</th>
                            <th>Jue</th>
                            <th>T. EX</th>
                            <th>Total Hrs</th>
                            <th>Total</th>
                            <th>---</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="nomina" items="${nominas}" varStatus="iter">
                            <tr>
                                <td><h6>${nomina.idNom}</h6></td>
                                <td><h6>${nomina.empleado.persona.nombrePersona}&nbsp;${nomina.empleado.persona.apellidoPpersona}&nbsp;${nomina.empleado.persona.apellidoMpersona}</h6></td>
                                <td><h6>${nomina.semanaNom}</h6></td>
                                <td><h6>${nomina.hrsViernes}</h6></td>
                                <td><h6>${nomina.hrsLunes}</h6></td>
                                <td><h6>${nomina.hrsMartes}</h6></td>
                                <td><h6>${nomina.hrsMiercoles}</h6></td>
                                <td><h6>${nomina.hrsJueves}</h6></td>
                                <td><h6>${nomina.hrsExtra}</h6></td>
                                <td><h6>${nomina.hrsTotales}</h6></td>
                                <td><h6>$ ${nomina.sueldoT} 00/100 M.N.</h6></td>
                                <td>
                                    <a data-toggle="modal" href="#" class="btn btn-sm btn-danger" role="button" data-target="#Quitar" data-id1="${nomina.id_empleado}" data-id2="${nomina.idNom}"><i class="glyphicon glyphicon-minus"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive container" id="tabla-trabajos" style="display: none">
                <table class="table" id="tabla_pro" name="nomina">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Empleado</th>
                            <th>Semana</th>
                            <th>Vie</th>
                            <th>Lun</th>
                            <th>Mar</th>
                            <th>Mier</th>
                            <th>Jue</th>
                            <th>T. EX</th>
                            <th>Total Hrs</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="nomina" items="${nominas}" varStatus="iter">
                            <tr>
                                <td><h6>${nomina.idNom}</h6></td>
                                <td><h6>${nomina.empleado.persona.nombrePersona}&nbsp;${nomina.empleado.persona.apellidoPpersona}&nbsp;${nomina.empleado.persona.apellidoMpersona}</h6></td>
                                <td><h6>${nomina.semanaNom}</h6></td>
                                <td><h6>${nomina.proyectov}</h6></td>
                                <td><h6>${nomina.proyectol}</h6></td>
                                <td><h6>${nomina.proyectoMa}</h6></td>
                                <td><h6>${nomina.proyectoMi}</h6></td>
                                <td><h6>${nomina.proyectoJ}</h6></td>
                                <td><h6>${nomina.proyectoHe}</h6></td>
                                <td><h6>${nomina.hrsTotales}</h6></td>
                                <td><h6>$ ${nomina.sueldoT} 00/100 M.N.</h6></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form" role="form" method="post" action="calcularnom">
                <div class="modal fade" id="calcularnom">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Calcular Nomina</h3>
                            </div>
                            <div class="modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-5">
                                        Empleado:
                                        <select class="form-control" name="idEmp" id="idEmp">
                                            <option value="">--Selecciona un empleado--</option>
                                            <c:forEach var="empleado" items="${empleados}" varStatus="iter">
                                                <option value="${empleado.idEmpleado}">${empleado.persona.nombrePersona}&nbsp;${empleado.persona.apellidoPpersona}&nbsp;${paciente.persona.apellidoMpersona}</option>
                                            </c:forEach>
                                        </select></div>
                                    <div class="col-lg-3">Semana del: <input type="date" class="form-control" name="semana1" id="semana1" required></div>
                                    <div class="col-lg-3">Al: <input type="date" class="form-control" name="semana2" id="semana2" required></div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-2">Hrs V: <input type="number" class="form-control" name="viernes" id="viernes" required></div>
                                    <div class="col-lg-4">
                                        Trabajó Viernes en:<select class="form-control" name="idpv" id="idpv">
                                            <option>--Trabajos--</option>
                                            <option value="No Trabajó">No Trabajó</option>
                                            <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                                                <option value="${proyecto.nombreProyecto}">${proyecto.nombreProyecto}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-lg-2">Hrs L: <input type="number" class="form-control" name="lunes" id="lunes" required></div>
                                    <div class="col-lg-4">
                                        Trabajó Lunes en:<select class="form-control" name="idpl" id="idpl">
                                            <option>--Trabajos--</option>
                                            <option value="No Trabajó">No Trabajó</option>
                                            <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                                                <option value="${proyecto.nombreProyecto}">${proyecto.nombreProyecto}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row form-group" >
                                    <div class="col-lg-2">Hrs M: <input type="number" class="form-control" name="martes" id="martes" required></div>
                                    <div class="col-lg-4">
                                        Trabajó Martes en:<select class="form-control" name="idpma" id="idpma">
                                            <option>--Trabajos--</option>
                                            <option value="No Trabajó">No Trabajó</option>
                                            <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                                                <option value="${proyecto.nombreProyecto}">${proyecto.nombreProyecto}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-lg-2">Hrs Mie: <input type="number" class="form-control" name="miercoles" id="miercoles" required></div>
                                    <div class="col-lg-4">
                                        Trabajó Miércoles en:<select class="form-control" name="idpmi" id="idpmi">
                                            <option>--Trabajos--</option>
                                            <option value="No Trabajó">No Trabajó</option>
                                            <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                                                <option value="${proyecto.nombreProyecto}">${proyecto.nombreProyecto}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-lg-2">Hrs J: <input type="number" class="form-control" name="jueves" id="jueves" required></div>
                                    <div class="col-lg-4">
                                        Trabajó Jueves en:<select class="form-control" name="idpj" id="idpj">
                                            <option>--Trabajos--</option>
                                            <option value="No Trabajó">No Trabajó</option>
                                            <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                                                <option value="${proyecto.nombreProyecto}">${proyecto.nombreProyecto}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-lg-2">Hrs T.Ex:<input type="number" class="form-control" name="tiempo_extra" id="tiempo_extra" required></div>
                                    <div class="col-lg-4">
                                        Trabajó Horas Extra en:<select class="form-control" name="idphe" id="idphe">
                                            <option>--Trabajos--</option>
                                            <option value="No Trabajó">No Trabajó</option>
                                            <c:forEach var="proyecto" items="${proyectos}" varStatus="iter">
                                                <option value="${proyecto.nombreProyecto}">${proyecto.nombreProyecto}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <h5>&nbsp;&nbsp;&nbsp;&nbsp;Ingresos Extra:</h5>
                                    <div class="col-lg-3">Sobre Sueldo: <input type="number" class="form-control" name="sobre" id="sobre" required></div>
                                    <div class="col-lg-3">Viaticos: <input type="number" class="form-control" name="viaticos" id="viaticos" required></div>
                                    <div class="col-lg-3">Otros Ingresos: <input type="number" class="form-control" name="otrosI" id="otrosI" required></div>
                                    <div class="col-lg-3">Deducciones: <input type="number" class="form-control" name="deducciones" id="deducciones" required></div>
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
            <form class="form" role="form" method="post" action="descontarnom">
                <div class="modal fade" id="Quitar" name="Quitar">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Seleccione día y horas</h3>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    &nbsp; Dia:
                                    <select class="form-control" name="dia" id="dia">
                                        <option value="Lunes">Lunes</option>
                                        <option value="Martes">Martes</option>
                                        <option value="Miercoles">Miércoles</option>
                                        <option value="Jueves">Jueves</option>
                                        <option value="Viernes">Viernes</option>
                                        <option value="Tiempo">Tiempo Extra</option>
                                    </select>
                                    &nbsp; Horas:
                                    <select class="form-control" name="horas" id="horas">
                                        <option value="0.5">Media Hora</option>
                                        <option value="1">1 Hora</option>
                                        <option value="2">2 Horas</option>
                                        <option value="3">3 Horas</option>
                                        <option value="4">4 Horas</option>
                                        <option value="5">5 Horas</option>
                                        <option value="6">6 Horas</option>
                                        <option value="7">7 Horas</option>
                                        <option value="8">8 Horas</option>
                                        <option value="9">9 Horas</option>
                                        <option value="10">1 dia</option>
                                    </select>
                                </div>
                                <div class="row form-group">
                                    <input type="hidden" name="idNomD" id="idNomD" class="form-control">
                                    <input type="hidden" name="idEmD" id="idEmD" class="form-control">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="summit" class="btn btn-danger">Descontar</button>
                                <button type="RESET" class="btn btn-info">Limpiar</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>