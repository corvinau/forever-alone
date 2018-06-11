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
        <title>Forever Alone</title>
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <c:if test="${(empty loginBean)}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema." />
            </jsp:forward>
        </c:if>
        
        <c:if test="${not empty msg}">
            <div class="container alert alert-warning" role="alert">
                <span>${msg}</span>
            </div>
        </c:if>
        
        <%--<c:choose>--%>
            <%--<c:when test="${loginBean.tipo == 'C' || loginBean.tipo == 'c'}">--%>
<!--                <div class="w3l_agileits_breadcrumbs">
                    <div class="container">
                        <div class="w3l_agileits_breadcrumbs_inner">
                            <ul>
                                <li>
                                    <a href="ClienteServlet">Opções</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>-->
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
<!--                <div class="w3l_agileits_breadcrumbs">
                    <div class="container">
                        <div class="w3l_agileits_breadcrumbs_inner">
                            <ul>
                                <li>
                                    <a href="FuncionarioServlet?action=listaClientes">Clientes</a>
                                </li>
                                <li>
                                    <a href="FuncionarioServlet?action=listaLocal">Local</a>
                                </li>
                                <li>
                                    <a href="FestaServlet?action=listaFesta">Festa</a>
                                </li>
                                <li>-->
                                    <%--<c:if test="${loginBean.nome == \"admin\" }">--%>
                                        <!--<a href="FuncionarioServlet?action=listaFuncionarios">Funcionario</a>-->
                                    <%--</c:if>--%>
<!--                                </li>
                            </ul>
                        </div>
                    </div>
                </div>-->
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        
        <section class="w3ls-team text-center">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Bem vindo ${loginBean.nome}</h3>
                </div>
            </div>
        </section>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
