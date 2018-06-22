<%-- 
    Document   : casamentoSolicitarForm
    Created on : 21/06/2018, 20:35:32
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
        <%@include file="headerLogged.jsp"%>
        
        
        
        <div class="login elite-app">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>
                        Casar-se com:
                        <c:choose>
                            <c:when test="${loginBean.idCliente == encontro.cliente.idCliente}">
                                ${encontro.convite.convidado.nome}
                                <c:set var="convidando" value="${encontro.convite.convidado.idCliente}" ></c:set>
                            </c:when>
                            <c:otherwise>
                                ${encontro.cliente.nome}
                                <c:set var="convidando" value="${encontro.cliente.idCliente}" ></c:set>
                            </c:otherwise>
                        </c:choose>
                    </h3>
                </div>
                <div class="col-md-12 login-form-w3-agile">
        
                    <form action="CasamentoServlet?action=solicitarCasamento&idConvidando=${convidando}" method="POST">
                        <div class="w3_form_body_grid">
                            <span>Nome do padre*</span>
                            <input type="text" name="padre" id="padre" placeholder="Padre">
                        </div>
                        
                        <div class="w3_form_body_grid">
                            <span>Nome do igreja*</span>
                            <input type="text" name="igreja" id="igreja" placeholder="Igreja">
                        </div>
                        
                        <div class="w3_form_body_grid">
                            <span>Local da lua de mel*</span>
                            <input type="text" name="localLuaMel" id="localLuaMel" placeholder="Local da lua de mel">
                        </div>
                        
                        <div class="w3_form_body_grid">
                            <span>Data do casamento*</span>
                            <input type="text" name="data" id="data" placeholder="data">
                        </div>
                        
                        <div class="w3_form_body_grid">
                            <span>Horário do casamento*</span>
                            <input type="text" name="hora" id="hora" placeholder="hora">
                        </div>
                        
                        <div class="w3_form_body_grid">
                            <span>Quantindade de convidados*</span>
                            <input type="text" name="qtdConvidados" id="qtdConvidados" placeholder="Quantindade de convidados">
                        </div>
                        
                        <div class="w3_form_body_grid">
                            <div id="padrinho">
                                <span>Primeiro casal de padrinhos*</span>
                                <input type="text" name="cojuges1" id="conjuges" placeholder="Nome do padrinho e da madrinha">
                                <span></span>
                                <input type="text" name="emailConjuge1" id="emailConjuge" placeholder="E-mail de contato do casal">
                            </div>
                        </div>
                        
                        <div class="w3_form_body_grid">
                            <div id="padrinho">
                                <span>Segundo casal de padrinhos*</span>
                                <input type="text" name="cojuges2" id="conjuges" placeholder="Nome do padrinho e da madrinha">
                                <span></span>
                                <input type="text" name="emailConjuge2" id="emailConjuge" placeholder="E-mail de contato do casal">
                            </div>
                        </div>
                        
                       
                        
                        <input type="submit" value="Pedido">
                    </form>
            
                </div>
            </div>
        </div>
            
        <%@include file="footer.jsp"%>
    </body>
</html>
