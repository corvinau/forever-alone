<%-- 
    Document   : clienteOpcoes
    Created on : 04/06/2018, 20:59:13
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
                    <h3>Opcões do perfil</h3>
                </div>
            </div>
        </section>
        
        <div class="container" style="margin-bottom: 15%;">
            <div class="row">
                <div class="login-center-info text-center">
                    <div class="sim-button button12">
                        <a href="#">Edição de dados</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="login-center-info text-center">
                    <div class="sim-button button12">
                        <a href="ClienteServlet?action=formDescricao">Descrição</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="login-center-info text-center">
                    <div class="sim-button button12">
                        <a href="ClienteServlet?action=formPreferencia">Preferências de encontros</a>
                    </div>
                </div>
            </div>
            <!--<div class="row">
                <div class="login-center-info text-center">
                    <div class="sim-button button12">
                        <a href="ClienteServlet?action=formHorario">Horários</a>
                    </div>
                </div>
            </div>-->
            <div class="row">
                <div class="login-center-info text-center">
                    <div class="sim-button button12">
                        <a href="ClienteServlet?action=switchDisp">On/Off</a>
                    </div>
                </div>
            </div>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
