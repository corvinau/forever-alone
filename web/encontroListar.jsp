<%-- 
    Document   : encontroListar
    Created on : 19/06/2018, 17:25:25
    Author     : ArtVin
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forever Alone</title>
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <section class="text-center">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Lista de encontros</h3>
                </div>
            </div>
        </section>
        
        <div class="container">
            <div class="sim-button button12" style="margin-top: 0px; float: right; background: rgb(65, 131, 154); margin-bottom: 15px;">
                <a href="EncontroServlet?action=SolicitarEncontro">Solicitar Encontro</a>
            </div>
            <div class="clearfix"> </div>
        </div>
        
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Dia</th>
                        <th>Hora</th>
                        <th>Local</th>
                        <th>Status</th>
                        <th>Ação</th>
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
                            <td><fmt:formatDate value="${encontro.hora}" pattern="HH:mm"></fmt:formatDate></td>
                            <td>${encontro.local.nomeEstabelecimento}</td>
                            <td>${encontro.status.nome}</td>
                            <td>
                                <a href="EncontroServlet?action=showDetalhes&id=${encontro.idEncontro}">
                                    <i class="fa fa-eye"></i>
                                </a>
                                <c:choose >
                                    <c:when test="${ encontro.status.nome.equals(\"Realizado\")}">
                                        <a href="EncontroServlet?action=solicitarCasamento&id=${encontro.idEncontro}">
                                            <i class="fa fa-heart"></i>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="EncontroServlet?action=remarcarEncontro&id=${encontro.idEncontro}">
                                            <i class="fa fa-pencil"></i>
                                        </a>
                                        <a href="EncontroServlet?action=cancelarEncontro&id=${encontro.idEncontro}">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
