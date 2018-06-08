<%-- 
    Document   : clienteOpcoes
    Created on : 04/06/2018, 20:59:13
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Opcoes</h1>
        <a href="ClienteServlet?action=formDescricao">Descricao<a>
        <a href="ClienteServlet?action=formPreferencia">Preferencia</a>
        <a href="ClienteServlet?action=formHorario">Horario</a>
        <a href="ClienteServlet?action=switchDisp">On/Off</a>
    </body>
</html>
