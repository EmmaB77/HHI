<%-- 
    Document   : verDetalleCot
    Created on : 22/10/2015, 10:45:03 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <div class="table container" align="center">
            <div class="row" style="background-color: #000">
                <div class="col-lg-12">
                    <img src="img/encabezado.jpg" class="img-responsive img-rounded" align="center">
                </div>
            </div><br>
            <div class="table" align="right">
                <div class="row">
                    <div class="col-lg-7"></div>
                    <div class="col-lg-5"><b>Santiago de Querétaro, Qro. a 22 de Octubre de 2015</b></div>
                </div>
                <div class="row">
                    <div class="col-lg-9"></div>
                    <div class="col-lg-3"><b>Cot. No: I0666-15</b></div>
                </div><br>
                <div class="row">
                    <div class="col-lg-7"></div>
                    <div class="col-lg-5"><b>AT'N: ING. JORGE ARTURO GARCÍA</b></div>
                </div>
            </div>
            <div class="table" align="left">
                <div class="row">
                    <div class="col-lg-3"><b>CLIENTE: INDORAMA VENTURES</b></div>
                </div>
                <div class="row">
                    <div class="col-lg-3"><b>REF:</b> SIN REFERENCIA</div>
                </div>
                <div class="row">
                    <div class="col-lg-3"><b>SOL COT:</b> SIN SOL COT</div>
                </div>
                <div class="row">
                    <div class="col-lg-3"><b>USUARIO:</b> ING. J. CARMEN AGUILAR</div>
                </div>
            </div>
            <div class="table" align="center">
                <div class="row">
                    <div class="col-lg-12"><b>COTIZACIÓN REFERENTE AL SIGUIENTE SERVICIO</b></div>
                </div>
                <div class="row">
                    <div class="col-lg-12" style="font-size: 150%"><b>INSTALACION DE SOPORTE PARA MOTOR</b></div>
                </div>
            </div><br>
            <div class="table">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th style="color: #1C77D8"><b>ID</b></th>
                            <th class="col-lg-6" style="color: #1C77D8"><b>DESCRIPCIÓN</b></th>
                            <th style="color: #1C77D8"><b>CANTIDAD</b></th>
                            <th style="color: #1C77D8"><b>UNIDAD</b></th>
                            <th style="color: #1C77D8"><b>IMPORTE</b></th>
                            <th style="color: #1C77D8"><b>TOTAL</b></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td><b>Instalacion de base para motor en el area z666</b></td>
                            <td>2</td>
                            <td>PIEZAS</td>
                            <td>$78,000</td>
                            <td>$156,000</td>
                        </tr>
                        <tr>
                            <td>1.-</td>
                            <td>Armazon de Acero Inoxidable</td>
                            <td>2</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>2.-</td>
                            <td>Soldadura de bases</td>
                            <td>2</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div><br>
            <div class="table table-bordered" style="background-color: #a9b6d0">
                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-3" style="font-size: 150%"><b>COSTO DE LA OFERTA</b></div>
                    <div class="col-lg-3" style="font-size: 150%"><b>$156,000</b></div>
                    <div class="col-lg-3"></div>
                </div>
                <div class="row">
                    <div class="col-lg-3"></div>
                    <div class="col-lg-6"><b>(CIENTO CINCUENTA Y SEIS MIL PESOS 00/100 M.N.)</b></div>
                </div>
            </div><br>
            <div class="table" align="left">
                <div class="row">
                    <div class="col-lg-3"><b>PRECIO MAS EL 16% DE IVA</b></div>
                </div>
            </div>
            <div class="table" align="left" style="background-color: #1C77D8">
                <div class="row">
                    <div class="col-lg-3"><b>TIEMPO DE ENTREGA: 2 SEMANAS</b></div>
                </div>
            </div>
            <div class="table" align="left">
                <table class="table-bordered">
                    <thead>
                        <tr>
                            <td>NOTAS</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1.-</td>
                            <td>ESTE PRESUPUESTO ESTA BASADO EN PRECIOS UNITARIOS EN TIEMPO NORMAL DE LUNES A VIERNES DE LAS 7:00 a.m. A LAS 6:00 p.m., EL TIEMPO EXTRA SE COBRARA POR SEPARADO.</td>
                        </tr>
                        <tr>
                            <td>2.-</td>
                            <td>EL INCREMENTO EN EL COSTO DE LOS MATERIALES MAYOR AL 3%, INVALIDARA ESTA COTIZACIÓN.</td>
                        </tr>
                        <tr>
                            <td>3.-</td>
                            <td>CUALQUIER TRABAJO ADICIONAL FUERA DE EL ALCANCE DE ESTE PRESUPUESTO SE NEGOCIARA CON EL CLIENTE Y SE COSTEARÁ POR SEPARADO.</td>
                        </tr>
                        <tr>
                            <td>4.-</td>
                            <td>CONDICIONES DE PAGO:  25 DÍAS CONTRA AVANCES</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
