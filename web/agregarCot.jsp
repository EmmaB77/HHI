<%-- 
    Document   : agregarCot
    Created on : 20/10/2015, 12:24:05 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Nueva Cotizacion</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/logo.jpg">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body background="img/1.jpg">
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
        <form class="form-horizontal container" style="background-color: #4fb8df">
            <h2>Datos de Cotizacion:</h2>
            <div class="table">
                <div class="row form-group">
                    <div class="col-lg-6"><h3>Titulo:<input type="text" class="form-control"></h3></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-2">Id Cotizacion: <input type="text" class="form-control"></div>
                    <div class="col-lg-3">Fecha de Solicitud: <input type="date" class="form-control"></div>
                    <div class="col-lg-2">Solicitud de Cotizacion: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Numero de Cotizacion: <input type="text" class="form-control"></div>
                    <div class="col-lg-3">Fecha de Cotizacion: <input type="date" class="form-control"></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-2">Orden de Compra: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Recibida: <input type="date" class="form-control"></div>
                    <div class="col-lg-2">Usuario: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Fecha de Entrega: <input type="date" class="form-control"></div>
                    <div class="col-lg-2">Monto: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Factura: <input type="text" class="form-control"></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-4">Descripcion:<textarea class="form-control" style="resize:none"></textarea></div>
                    <div class="col-lg-2">Ejecutor: <input type="text" class="form-control"></div>
                    <div class="col-lg-2">Porcentaje de Avance: <input type="texr" class="form-control"></div>
                    <div class="col-lg-2">Estatus: <select class="form-control">
                            <option value="...">...</option>
                            <option value="Facturado">Facturado</option>
                            <option value="Cotizado">Cotizado</option>
                            <option value="En Proceso">En Proceso</option>
                            <option value="Perdida">Perdida</option>
                            <option value="Cancelada">Cancelada</option>
                            <option value="Por Cotizar">Por Cotizar</option>
                        </select></div>
                    <div class="col-lg-2">Dias de Credito: <select class="form-control">
                            <option value="...">...</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select></div>
                </div>
                <div><h3>Detalle Cotizacion</h3></div>
                <div class="row form-group">
                    <div class="col-lg-4">Descripcion Pieza/Detalle/Servicio:<textarea class="form-control" style="resize:none"></textarea></div>
                    <div class="col-lg-2">Cantidad: <input type="number" class="form-control"></div>
                    <div class="col-lg-2">Unidad: <select class="form-control">
                            <option value="...">...</option>
                            <option value="Pieza">PZA</option>
                            <option value="Servicio">Servicio</option>
                            <option value="Lote">LTE</option>
                        </select>
                    </div>
                    <div class="col-lg-2">Importe: <input type="money" class="form-control"></div>
                    <div class="row form-group">
                        <div class="table-responsive">
                            
                        </div>
                    </div>
                    <div><h3>TOTAL</h3></div>
                    <div class="row form-group">
                        <div class="col-lg-3">Total: <input type="text" class="form-control"></div>
                        <div class="col-lg-4">Total Letra: <input type="text" class="form-control"></div>
                    </div>
                    <div class="row form-group">
                        <div class="col-lg-6">
                            <button type="summit" class="btn btn-success">Continuar</button>
                            <input type="button" class="btn btn-danger" onclick="location.href = 'index.html'" value="Cancelar">
                            <button type="RESET" class="btn btn-default">Limpiar</button>
                        </div>
                    </div>
                </div>
        </form>
    </body>
</html>