<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="Conexion.Conexion" %><!DOCTYPE html>
<%@page import="Modelo.nomina"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recibos Nómina</title>
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
            function imprSelec(imprime)
            {
                var ficha = document.getElementById(imprime);
                var ventimp = window.open(' ', '_blank');
                ventimp.document.write(ficha.innerHTML);
                var css = ventimp.document.createElement("link");
                css.setAttribute("href", "css/bootstrap.min.css");
                css.setAttribute("rel", "stylesheet");
                css.setAttribute("type", "text/css");
                var src1 = ventimp.document.createElement("script");
                src1.setAttribute("src", "js/jquery.js");
                var src2 = ventimp.document.createElement("script");
                src2.setAttribute("src", "js/bootstrap.min.js");
                ventimp.document.head.appendChild(css);
                ventimp.document.head.appendChild(src1);
                ventimp.document.head.appendChild(src2);
                ventimp.print( );
                ventimp.close();
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
            <h3>Imprimir Recibos</h3>
            <form class="form-group" role="form" method="post" action="generar">
                <div class="row">
                    <div class="col-lg-4"> Generar por Semana: <select class="form-control" name="semana" id="semana">
                            <option>--Seleccione Semana--</option>
                            <c:forEach var="semana" items="${semanas}" varStatus="iter">
                                <option value="${semana.semanaNom}">${semana.semanaNom}</option>
                            </c:forEach>
                        </select><br><br>
                    </div>
                    <div class="col-lg-6">
                        <br>
                        <button type="summit" class="btn btn-default">Buscar</button>
                        <a href="javascript:imprSelec('imprime')" role="button" class="btn btn-info">Imprimir Recibo</a>
                    </div>
                </div>
            </form><br>
            <div id="imprime" style="height:375px; overflow: scroll">
                <c:forEach var="datos" items="${nominas}" varStatus="iter">
                    <div class="table-bordered">
                        <div class="row">
                            <div class="col-xs-8" style="background-color: #000"><img src="img/banner.jpg" alt="" width="50%"></div>
                        </div>
                        <div class="row">
                            <div class="col-xs-5"><font size="1">HHI INSTALACIONES INDUSTRIALES</div>
                            <div class="col-xs-3" align="right">Fecha: ${datos.date}</div></font>
                        </div>
                        <div class="row">
                            <div class="col-xs-8" align="center"><h5><b>RECIBO DE NÓMINA</b></h5></div>
                        </div>
                        <div class="row"><font size="1">
                            <div class="col-xs-3">ID: ${datos.id_empleado}</div>
                            <div class="col-xs-5" align="right">Período:</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4">Nombre: ${datos.empleado.persona.nombrePersona}&nbsp;${datos.empleado.persona.apellidoPpersona}&nbsp;${datos.empleado.persona.apellidoMpersona}</div>
                            <div class="col-xs-4" align="right">${datos.semanaNom}</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4">Horas Trabajadas: ${datos.hrsTotales}</div>
                        </div><br>
                        <div class="row">
                            <div class="col-xs-4" align="left"><b>Ingresos</b></div>
                            <div class="col-xs-4" align="left"><b>Deducciones:</b></div>
                        </div></font><font size="1">
                        <div class="row">
                            <div class="col-xs-8" align="center">-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2">Normal:</div>
                            <div class="col-xs-2">$ ${datos.sueldo_N} M.N.</div>
                            <div class="col-xs-2">Infonavit:</div>
                            <div class="col-xs-2">$ ${datos.infonavit}</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2">Tiempo Extra:</div>
                            <div class="col-xs-2">$ ${datos.sueldoEx} M.N.</div>
                            <div class="col-xs-2">Otros:</div>
                            <div class="col-xs-2">$ ${datos.otros_deducciones} M.N.</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2">SobreSueldo:</div>
                            <div class="col-xs-2">$ ${datos.sobresueldo} M.N.</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2">Viaticos</div>
                            <div class="col-xs-2">$ ${datos.viaticos} M.N.</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2">Otros:</div>
                            <div class="col-xs-2">$ ${datos.otros_ingresos} M.N.</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2"><b>Total Ingresos:</b></div>
                            <div class="col-xs-2">$ ${datos.total_ingresos} M.N.</div>
                            <div class="col-xs-2"><b>Total Deducciones:</b></div>
                            <div class="col-xs-2">$ ${datos.total_deducciones} M.N.</div>
                        </div>
                        <div class="row">
                            <div class="col-xs-2"></div>
                            <div class="col-xs-2"></div>
                            <div class="col-xs-2"><b>Salario Total:</b></div>
                            <div class="col-xs-2">$ ${datos.sueldoT} M.N.</div><br>
                        </div></font>
                        <div class="row"><font size="1">
                            <div class="col-xs-5">Recibi de conformidad las prestaciones correspondientes al periodo que se indica arriba y que liquida totalmente hasta esta fecha, mi salario ordinario, extraordinario, 7o. Día, salario de compensación y demas prestaciones.</div></font>
                            <div class="col-xs-1"></div>
                            <div class="col-xs-2" align="center"><br>_________________<br>FIRMA</div>
                        </div>
                    </div>
                </c:forEach></div><br><br>
            <div>
                <div>
                    <div>
                        <table class="table table-responsive">
                            <thead>
                                <tr>
                                    <th>Nomina</th>
                                    <th>Empleado</th>
                                    <th>Semana</th>
                                    <th>Cuenta Banamex</th>
                                    <th>Deposito Ventanilla</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="nomina" items="${nominas}" varStatus="iter">
                                    <tr>
                                        <td>${nomina.idNom}</td>
                                        <td>${nomina.empleado.persona.nombrePersona}&nbsp;${nomina.empleado.persona.apellidoPpersona}&nbsp;${nomina.empleado.persona.apellidoMpersona}</td>
                                        <td>${nomina.semanaNom}</td>
                                        <td>${nomina.cta_banco}</td>
                                        <td>$ ${nomina.ventanilla} M.N</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
