<%-- 
    Document   : portal
    Created on : 01/06/2018, 21:40:08
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
        <c:if test="${(empty loginBean)}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema." />
            </jsp:forward>
        </c:if>
        Bem vindo ${loginBean.nome}
        <c:choose>
            <c:when test="${loginBean.tipo == 'C' || loginBean.tipo == 'c'}">
                Cliente
                <a href="ClienteServlet">Opcoes</a>
            </c:when>
            <c:otherwise>
                Funcionario
                <a href="FuncionarioServlet?action=listaClientes">Clientes</a>
                <c:if test="${loginBean.nome == \"admin\" }">
                    <a href="FuncionarioServlet?action=listaFuncionarios">Funcionario</a>
                </c:if>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
