<%-- 
    Document   : festaAdicionaConvidados
    Created on : 10/06/2018, 12:01:26
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
                    <h3>Lista de Convidados</h3>
                </div>
            </div>
        </section>
        
        <h1>Adicionar convidados a ${idFesta}</h1>
        <form action="FestaServlet?action=convidarClientes" method="POST">
            <input type="text" name="idFesta" hidden="true" value="${idFesta}">
            <table>
                <thead>
                    <tr>
                        <th scope="col">Convidar</th>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Email</th>
                        <th scope="col">cpf</th>
                        <th scope="col">sexo</th>
                        <th scope="col">resumo</th>
                        <th scope="col">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaCliente}" var="cliente" >
                        <tr>
                            <td><input type="checkbox" id="coding" name="idCliente" value="${cliente.idCliente}"></td>
                            <td>${cliente.idCliente}</td>
                            <td>${cliente.nome}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.cpf}</td>
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
            <input type="submit" value="Atualizar">
        </form>
        <%@include file="footer.jsp"%>
    </body>
</html>
