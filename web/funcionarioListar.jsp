<%-- 
    Document   : funcionarioListar
    Created on : 09/06/2018, 20:03:37
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
        <h1>lista Funcionarios</h1>
        <table>
            <thead>
                <tr>
                    
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col">cpf</th>
                    <th scope="col">cargo</th>
                    <th scope="col">dataNascimento</th>
                    <th scope="col">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaFuncionarios}" var="funcionario" >
                    <tr>
                        <td>${funcionario.idFuncionario}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.email}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.cargo}</td>
                        <td>${funcionario.dataNasc}</td>
                        <td>
                            <a href="FuncionarioServlet?action=show&id=${funcionario.idFuncionario}">
                                Não faz nd
                                <i class="material-icons">visibility</i> 
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="FuncionarioServlet?action=funcionarioForm">Novo</a>                        
    </body>
</html>
