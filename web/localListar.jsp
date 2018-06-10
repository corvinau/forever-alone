<%-- 
    Document   : localListar
    Created on : 09/06/2018, 22:58:19
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
        <h1>Lista local</h1>
        <table>
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Cidade</th>
                    <th scope="col">Bairo</th>
                    <th scope="col">Rua</th>
                    <th scope="col">Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaLocal}" var="local" >
                    <tr>
                        <td>${local.idLocal}</td>
                        <td>${local.nomeEstabelecimento}</td>
                        <td>${local.endereco.cidade.uf.sigla} </td>
                        <td>${local.endereco.cidade.nome}</td>
                        <td>${local.endereco.bairro}</td>
                        <td>${local.endereco.rua}</td>
                        <td>
                            <a href="ClientesServlet?action=show&id=${local.idLocal}">
                                Não faz nd
                                <i class="material-icons">visibility</i> 
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="FuncionarioServlet?action=localForm">Novo</a>                        
    </body>
</html>
