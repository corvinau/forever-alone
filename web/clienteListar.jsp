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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>lista Clientes</h1>
        <table>
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col">cpf</th>
                    <th scope="col">sexo</th>
                    <th scope="col">disponibilidade</th>
                    <th scope="col">resumo</th>
                    <th scope="col">Ação</th>
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
                        <td>
                            <a href="ClientesServlet?action=show&id=${cliente.idCliente}">
                                Não faz nd
                                <i class="material-icons">visibility</i> 
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="FuncionarioServlet?action=clienteForm">Novo</a>
    </body>
</html>
