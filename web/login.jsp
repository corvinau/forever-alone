<%-- 
    Document   : login
    Created on : 01/06/2018, 21:40:02
    Author     : ArtVin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forever Alone</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
    
        <c:if test="${not empty msg}">
            <div class="container alert alert-info" role="alert">
                <span><c:out value="${msg}" /></span>
            </div>
        </c:if>
    
        <div class="login elite-app">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Login</h3>
                </div>
                <div class="col-md-12 login-form-w3-agile">
                    <form action="UsuarioServlet?action=login" method="POST">
                        <div class="w3_form_body_grid">
                            <span>Login</span>
                            <input type="text" name="login" placeholder="Login" value="" required>
                        </div>
                        <div class="w3_form_body_grid">
                            <span>Senha</span>
                            <input type="password" name="senha" placeholder="Senha" value="" required>
                        </div>
                        <div class="agile_remember">
                            <div class="agile_remember_right">
                                <a href="#">Esqueci minha senha</a>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <input type="submit" value="Entrar">
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
