<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <li><a href="#">Calcular Nómina</a></li>
                                <li><a href="#">Imprimir Recibos</a></li>
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
            <div><a data-toggle="modal" href="#calcularnom" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Calcular</a></div>
            <br>
            <br>
            <div class="table-responsive container">
                <table class="table" id="tabla_cot" name="nomina">
                    <thead>
                        <tr>
                            <th>Empleado</th>
                            <th>Semana</th>
                            <th>Vie</th>
                            <th>Sáb</th>
                            <th>Dom</th>
                            <th>Lun</th>
                            <th>Mar</th>
                            <th>Mier</th>
                            <th>Jue</th>
                            <th>Total Hrs</th>
                            <th>Total</th>
                            <th>---</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="hora" items="${horas}" varStatus="iter">
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <a href="#=" class="btn btn-sm btn-danger" role="button" title="Descontar"><i class="glyphicon glyphicon-minus"></i><i class="glyphicon glyphicon-usd"></i></a>
                                </td>
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
                                <h3 class="modal-title">Ingrese las horas por día</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-5">Empleado:<input type="text" class="form-control" name="empleado" id="empleado"></div>
                                    <div class="col-lg-1">Semana: <input type="text" class="form-control" name="semana" id="semana"></div>
                                    <div class="col-lg-1">V: <input type="text" class="form-control" name="viernes" id="viernes"></div>
                                    <div class="col-lg-1">S: <input type="text" class="form-control" name="sabado" id="sabado"></div>
                                    <div class="col-lg-1">D: <input type="text" class="form-control" name="domingo" id="domingo"></div>
                                    <div class="col-lg-1">L: <input type="text" class="form-control" name="lunes" id="lunes"></div>
                                    <div class="col-lg-1">M: <input type="text" class="form-control" name="martes" id="martes"></div>
                                    <div class="col-lg-1">Mie: <input type="text" class="form-control" name="miercoles" id="miercoles"></div>
                                    <div class="col-lg-1">J: <input type="text" class="form-control" name="jueves" id="jueves"></div>
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
            <form class="form" role="form" method="post" action="descontar">
                <div class="modal fade" id="descontarNom">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h3 class="modal-title">Seleccione día y horas</h3>
                            </div>
                            <div class="table container modal-body">
                                <div class="row form-group">
                                    <div class="col-lg-5">Dia:
                                        <select class="form-control" name="dia" id="dia">
                                            <option value="Lunes">Lunes</option>
                                            <option value="Martes">Martes</option>
                                            <option value="Miercoles">Miercoles</option>
                                            <option value="Jueves">Jueves</option>
                                            <option value="Viernes">Viernes</option>
                                            <option value="Sabado">Sábado</option>
                                            <option value="Domingo">Domingo</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-1">Horas:
                                        <select class="form-control" name="dia" id="dia">
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