<%-- 
    Document   : encontroListar
    Created on : 19/06/2018, 17:25:25
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
        <div class="sim-button button12" style="margin-top: 0px; float: right; background: rgb(65, 131, 154); margin-bottom: 15px;">
                <a href="EncontroServlet?action=SolicitarEncontro">SolicitarEncontro</a>
        </div>
        <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Dia</th>
                        <th>Hora</th>
                        <th>Local</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaEncontro}" var="encontro" >
                        <tr>
                            <td>${encontro.idEncontro}</td>
                            <c:choose>
                                <c:when test="${encontro.cliente.idCliente == loginBean.idCliente}">
                                    <td>${encontro.convite.convidado.nome}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${encontro.cliente.nome}</td>
                                </c:otherwise>
                            </c:choose>
                            <td>${encontro.data}</td>
                            <td>${encontro.hora}</td>
                            <td>${encontro.local.nomeEstabelecimento}</td>
                            <td>${encontro.status}</td>
                            <td>
                                <a href="EncontroServlet?action=showDetalhes&id=${encontro.idEncontro}">
                                    <i class="fa fa-eye"></i>
                                </a>
                                <a href="EncontroServlet?action=remarcarEncontro&id=${encontro.idEncontro}">
                                    <i class="fa fa-pencil"></i>
                                </a>
                                <a href="EncontroServlet?action=cancelarEncontro&id=${encontro.idEncontro}">
                                    <i class="fa fa-times"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </body>
</html>
