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
        
        <section class="w3ls-team text-center">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Bem vindo ${loginBean.nome}</h3>
                </div>    
            </div>
        </section>

        <div class="container">
            <div class="grid_3 grid_5 wow fadeInUp animated" data-wow-delay=".5s" style="width: 100%; display: inline-flex;">
                <div class="well">
                    <h4 id="h4.-bootstrap-heading">
                        Encontros efetivados
                    </h4>
                    45
                </div>
                <div class="well">
                    <h4 id="h4.-bootstrap-heading">
                        Encontros pendentes
                    </h4>
                    23
                </div>
                <div class="well">
                    <h4 id="h4.-bootstrap-heading">
                        Encontros solicitados
                    </h4>
                    69
                </div>
            </div>
        </div>
                
        <%@include file="footer.jsp"%>
    </body>
</html>
