<%-- 
    Document   : encontroSolicitar
    Created on : 19/06/2018, 22:03:42
    Author     : ArtVin
--%>
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
                    <h3>Solicitar encontros</h3>
                </div>
            </div>
        </section>
        
        
        <div class="list-festa-convida">
            <form action="EncontroServlet?action=convidarClientes" method="POST">
                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Convidar</th>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Sexo</th>
                                <th>Resumo</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaCliente}" var="cliente" >
                                <tr>
                                    <td><input type="checkbox" id="coding" name="idCliente" value="${cliente.idCliente}"></td>
                                    <td>${cliente.idCliente}</td>
                                    <td>${cliente.nome}</td>
                                    <td>${cliente.sexo}</td>
                                    <td>${cliente.descricao.resumo}</td>
                                    <td>
                                        <a href="ClientesServlet?action=show&id=${cliente.idCliente}">
                                            <i class="fa fa-eye"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="container">
                    <input type="submit" value="Convidar Pessoas">
                    <div class="clearfix"> </div>
                </div>

            </form>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
