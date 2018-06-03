<%-- 
    Document   : login
    Created on : 01/06/2018, 21:40:02
    Author     : ArtVin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="UsuarioServlet?action=login" method="POST">
            <input type="text" name="login" value="" placeholder="Login"/>
            <input type="password" name="senha" value="" placeholder="Senha"/>
            <input type="submit" class="btn btn-primary" value="Entrar"/>
        </form>
    </body>
</html>
