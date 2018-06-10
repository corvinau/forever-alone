<%-- 
    Document   : festaListar
    Created on : 09/06/2018, 21:46:16
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Festas</h1>
        <table>
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Data</th>
                    <th scope="col">Tema</th>
                    <th scope="col">Hora</th>
                    <th scope="col">Situacao</th>
                    <th scope="col">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaFesta}" var="festa" >
                    <tr>
                        <td>${festa.idFesta}</td>
                        <td>${festa.data}</td>
                        <td>${festa.tema} </td>
                        <td>${festa.hora}</td>
                        <td>Tem q ver</td>
                        <td>
                            <a href="ClientesServlet?action=show&id=${festa.idFesta}">
                                Não faz nd
                                <i class="material-icons">visibility</i> 
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="FestaServlet?action=festaForm">Novo</a>
    </body>
</html>
