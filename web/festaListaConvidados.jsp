<%-- 
    Document   : festaListaConvidados
    Created on : 10/06/2018, 10:13:58
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
                    <h3>Lista de Convidados</h3>
                </div>
            </div>
        </section>
        
        <div class="container">
            <div class="sim-button button12" style="margin-top: 0px; float: right; background: rgb(65, 131, 154); margin-bottom: 15px;">
                <a href="FestaServlet?action=adcionarConvidado&id=${festa.idFesta}">Adicionar Convidado</a>
            </div>
            <div class="clearfix"> </div>
        </div>
        
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Idade</th>
                        <th>Sexo</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${festa.convites}" var="convite" >
                        <tr>
                            <td>${convite.convidado.idCliente}</td>
                            <td>${convite.convidado.nome}</td>
                            <td>${convite.convidado.email}</td>
                            <td>${convite.convidado.dataNasc}</td>
                            <td>${convite.convidado.sexo}</td>
                            <td>${convite.status}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
