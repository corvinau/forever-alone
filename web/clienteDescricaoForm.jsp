<%-- 
    Document   : clienteDescricaoForm
    Created on : 07/06/2018, 19:47:43
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
        
        <div class="login elite-app">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Descrição</h3>
                </div>
                <div class="col-md-12 login-form-w3-agile">
                <c:choose>
                    <c:when test="${(not empty loginBean)}">
                        <form action="ClienteServlet?action=updateDescricao" method="POST">
                    </c:when>
                    <c:otherwise>
                        <form action="#" method="POST">
                    </c:otherwise>
                </c:choose>
                
                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Foto de Perfil</span>
                                <input id="imagem" type="text" name="imagem" placeholder="Link para imagem"/>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Foto de Perfil</span>
                                <input id="imagem" type="text" name="imagem" placeholder="Link para imagem"/>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Descrição Pessoal</span>
                                <input type="text" name="resumo" value="" placeholder="Descrição"/>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Descrição Pessoal</span>
                                <input type="text" name="resumo" value="" placeholder="Descrição"/>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Cor do Cabelo</span>
                                <select id="corCabelo" name="corCabelo" class="frm-field">
                                    <c:forEach items="${listaCorCabelo}" var="cabelo">
                                        <c:choose>
                                            <c:when test="${loginBean.descricao.corCabelo.idCorCabelo == cabelo.idCorCabelo}">
                                                <option value="${cabelo.idCorCabelo}" selected> ${cabelo.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${cabelo.idCorCabelo}"> ${cabelo.nome}</option>
                                            </c:otherwise>
                                         </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Cor do Cabelo</span>
                                <select id="corCabelo" name="corCabelo" class="frm-field">
                                    <c:forEach items="${listaCorCabelo}" var="cabelo">
                                        <c:choose>
                                            <c:when test="${loginBean.descricao.corCabelo.idCorCabelo == cabelo.idCorCabelo}">
                                                <option value="${cabelo.idCorCabelo}" selected> ${cabelo.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${cabelo.idCorCabelo}"> ${cabelo.nome}</option>
                                            </c:otherwise>
                                         </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    
                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Cor da Pele</span>
                                <select id="corPele" name="corPele" class="frm-field">
                                    <c:forEach items="${listaCorPele}" var="pele">
                                        <c:choose>
                                            <c:when test="${loginBean.descricao.corPele.idCorPele == pele.idCorPele}">
                                                <option value="${pele.idCorPele}" selected> ${pele.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${pele.idCorPele}"> ${pele.nome}</option>
                                            </c:otherwise>
                                         </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Cor da Pele</span>
                                <select id="corPele" name="corPele" class="frm-field">
                                    <c:forEach items="${listaCorPele}" var="pele">
                                        <c:choose>
                                            <c:when test="${loginBean.descricao.corPele.idCorPele == pele.idCorPele}">
                                                <option value="${pele.idCorPele}" selected> ${pele.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${pele.idCorPele}"> ${pele.nome}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <input type="submit" value="Atualizar">
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="?">
                        </c:otherwise>
                    </c:choose>
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
