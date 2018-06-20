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
        <title>Forever Alone</title>
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <section class="text-center">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Lista de Festas</h3>
                </div>
            </div>
        </section>
        
        
        <div class="container">
            <div class="sim-button button12" style="margin-top: 0px; float: right; background: rgb(65, 131, 154); margin-bottom: 15px;">
                <a href="FestaServlet?action=festaForm">Novo</a>
            </div>
            <div class="clearfix"> </div>
        </div>
        
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Data</th>
                        <th>Tema</th>
                        <th>Hora</th>
                        <th>Status</th>
                        <th>Pendentes - Aceitos</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" />
                    <c:forEach items="${listaFesta}" var="festa" >
                        <tr>
                            <td>${festa.idFesta}</td>
                            <td>${festa.data}</td>
                            <td>${festa.tema} </td>
                            <td>${festa.hora}</td>
                            <td>${festa.status.nome}</td>
                            <td>${pendentes.get(count)} - ${aceitos.get(count)}</td>
                            <td>
                                <a href="#">
                                    <i class="fa fa-pencil"></i>
                                </a>
                                <a href="#">
                                    <i class="fa fa-times"></i>
                                </a>
                                <a href="FestaServlet?action=listaConvidados&id=${festa.idFesta}">
                                    <i class="fa fa-group"></i>
                                </a>
                            </td>
                        </tr>
                        <c:set var="count" value="${count+1}" />
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
