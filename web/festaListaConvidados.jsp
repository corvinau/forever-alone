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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Convidados </h1>
        <table>
            <thead>
                <tr>
                    
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col">Idade</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Status</th>
                    <th scope="col">Ação</th>
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
                        <td>
                            <a href="FuncionarioServlet?action=show&id=${convite.convidado.idCliente}">
                                Não faz nd
                                <i class="material-icons">visibility</i> 
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="FestaServlet?action=adcionarConvidado&id=${festa.idFesta}">Adicionar Convidados</a>
    </body>
</html>
