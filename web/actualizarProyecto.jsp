<%-- 
    Document   : proyectoDisponible
    Created on : 21/10/2015, 01:41:54 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Proyecto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
        <script src="js/bootstrap.min.js"></script>
        <link href="css/jquery.dataTables.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.dataTables.js"></script>

        <script type="text/javascript">
            $(function () {
                $('#tabla_citas').dataTable();
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
        <form class="form-horizontal container">
            <h3>Material Directo</h3>
            <div class="table-bordered">
                <div class="row form-group">
                    <div class="col-lg-2">Fecha:<input type="date" class="form-control"></div>
                    <div class="col-lg-3">Proveedor:<input type="text" class="form-control"></div>
                    <div class="col-lg-2">Numero de Factura:<input type="text" class="form-control"></div>
                    <div class="col-lg-4">Descripcion de Material:<textarea class="form-control" style="resize: none"></textarea></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-2">Sub-total:<input type="number" class="form-control"></div>
                    <div class="col-lg-2">I.V.A:<input type="number" class="form-control"></div>
                    <div class="col-lg-2">Total:<input type="number" class="form-control"></div>
                </div>
            </div>
            <h3>Material de Consumo</h3>
            <div class="table-bordered" style="background-color: threedlightshadow">
                <div class="row form-group">
                    <div class="col-lg-2">Fecha:<input type="date" class="form-control"></div>
                    <div class="col-lg-3">Proveedor:<input type="text" class="form-control"></div>
                    <div class="col-lg-2">Numero de Factura:<input type="text" class="form-control"></div>
                    <div class="col-lg-4">Descripcion de Material:<textarea class="form-control" style="resize: none"></textarea></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-2">Sub-total:<input type="number" class="form-control"></div>
                    <div class="col-lg-2">I.V.A:<input type="number" class="form-control"></div>
                    <div class="col-lg-2">Total:<input type="number" class="form-control"></div>
                </div>
            </div>
            <h3>Mano de Obra:</h3>
            <div class="table-bordered" style="background-color: #66afe9">
                <div class="row form-group">
                    <div class="col-lg-2">Fecha:<input type="date" class="form-control"></div>
                    <div class="col-lg-5">Descripcion:<input type="text" class="form-control"></div>
                    <div class="col-lg-2">Total:<input type="number" class="form-control"></div>
                </div>
            </div>
            <h3>Indirectos:</h3>
            <div class="table-bordered" style="background-color: #ff0">
                <div class="row form-group">
                    <div class="col-lg-2">Fecha:<input type="date" class="form-control"></div>
                    <div class="col-lg-3">Proveedor:<input type="text" class="form-control"></div>
                    <div class="col-lg-2">Numero de Factura:<input type="text" class="form-control"></div>
                    <div class="col-lg-4">Descripcion de Material:<textarea class="form-control" style="resize: none"></textarea></div>
                </div>
                <div class="row form-group">
                    <div class="col-lg-2">Sub-total:<input type="number" class="form-control"></div>
                    <div class="col-lg-2">I.V.A:<input type="number" class="form-control"></div>
                    <div class="col-lg-2">Total:<input type="number" class="form-control"></div>
                </div>
            </div><br>
            <div class="table">
                <div class="row form-group">
                    <div class="col-lg-6">
                        <button type="summit" class="btn btn-success">Terminar</button>
                        <button type="RESET" class="btn btn-default">Limpiar</button>
                        <input type="button" class="btn btn-danger" onclick="location.href = 'index.html'" value="Cancelar">
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
