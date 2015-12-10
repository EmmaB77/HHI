<%-- 
    Document   : acceso
    Created on : 28/10/2015, 07:39:27 AM
    Author     : Usuario
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso HHI</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="img/logo.jpg">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="css/formulario.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
    </head>
    <body>
        <div class="container">
            <form action="ControladorLogin" class="form-signin" method="post" align="center">
                <img src="img/logo_R.jpg" alt="">
                <h2 class="form-signin-heading">Iniciar sesi&oacute;n </h2>
                <label for="inputEmail" class="sr-only">Usuario</label>
                <input type="text" name="usuario" id="inputEmail" class="form-control" placeholder="Usuario" required autofocus>
                <label for="inputPassword" class="sr-only">Contrase&ntilde;a</label>
                <input type="password" id="inputPassword"  name="password" class="form-control" placeholder="Contrase&ntilde;a" required>
                <c:if test="${error==1}">
                    <p class="alert-danger">Error en el usuario o contraseña</p>
                </c:if>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
            </form>
        </div> <!-- /container -->
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
