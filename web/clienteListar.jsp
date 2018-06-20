<%-- 
    Document   : clienteListar
    Created on : 09/06/2018, 18:30:16
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
                    <h3>Lista de Clientes</h3>
                </div>
            </div>
        </section>
        
        <div class="container">
            <div class="" style="margin-top: 0px; margin-bottom: 15px;">
                <input id="search" type="text" name="search"/>
                <i class="fa fa-search"></i>
            </div>
            <div class="sim-button button12" style="margin-top: 0px; float: right; background: rgb(65, 131, 154); margin-bottom: 15px;">
                <a href="FuncionarioServlet?action=clienteForm">Novo</a>
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
                        <th>CPF</th>
                        <th>Sexo</th>
                        <th>Disponibilidade</th>
                        <th>Resumo</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaClientes}" var="cliente" >
                        <tr>
                            <td>${cliente.idCliente}</td>
                            <td>${cliente.nome}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.cpf}</td>
                            <td>${cliente.sexo}</td>
                            <td>${cliente.disp}</td>
                            <td>${cliente.descricao.resumo}</td>
                            <td style="width: 125px;">
                                <a href="FuncionarioServlet?action=showCliente&id=${cliente.idCliente}">
                                    <i class="fa fa-eye"></i>
                                </a>
                                <a href="FuncionarioServlet?action=formUpdateCliente&id=${cliente.idCliente}">
                                    <i class="fa fa-pencil"></i>
                                </a>
                                <a href="FuncionarioServlet?action=deleteCliente&id=${cliente.idCliente}">
                                    <i class="fa fa-times"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
