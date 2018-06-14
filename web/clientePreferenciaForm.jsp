<%-- 
    Document   : clientePreferenciaForm
    Created on : 07/06/2018, 21:52:55
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/clientePreferenciaForm.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forever Alone</title>
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <div class="login elite-app">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Preferências</h3>
                </div>
                <div class="col-md-12 login-form-w3-agile">
                <c:choose>
                    <c:when test="${(not empty loginBean)}">
                        <form action="ClienteServlet?action=updatePreferencia" method="POST">
                    </c:when>
                    <c:otherwise>
                        <form action="#" method="POST">
                    </c:otherwise>
                </c:choose>
                
                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Sexo</span>
                                <select id="sexo" name="sexo" class="frm-field">
                                    <option value="M">Homem</option>
                                    <option value="F">Mulher</option>   						
                                </select>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Sexo</span>
                                <select id="sexo" name="sexo" class="frm-field">
                                    <option value="M">Homem</option>
                                    <option value="F">Mulher</option>   						
                                </select>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Idade Mínima</span>
                                <input id="idadeMin" type="number" name="idadeMin" placeholder="Idade Mínima"/>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Idade Mínima</span>
                                <input id="idadeMin" type="number" name="idadeMin" placeholder="Idade Mínima"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    
                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Idade Máxima</span>
                                <input id="idadeMax" type="number" name="idadeMax" placeholder="Idade Máxima"/>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Idade Máxima</span>
                                <input id="idadeMax" type="number" name="idadeMax" placeholder="Idade Máxima"/>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Cor de Cabelo</span>
                                <select multiple id="corCabelo" name="corCabelo" class="frm-field">
                                    <c:forEach items="${listaCorCabelo}" var="cabelo">
                                        <c:choose>
                                            <c:when test="${loginBean.preferencia.corCabelo.contains(cabelo)}">
                                                <option value="${cabelo.idCorCabelo}" selected> ${cabelo.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${cabelo.idCorCabelo}"> ${cabelo.nome}</option>
                                            </c:otherwise>
                                         </c:choose>
                                    </c:forEach>
                                </select>
                                <p style="font-size: 13px;margin-left: 215px;margin-top: -20px;">Mantenha pressionado o botão Ctrl/Command para selecionar várias opções.</p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Cor de Cabelo</span>
                                <select multiple id="corCabelo" name="corCabelo" class="frm-field">
                                    <c:forEach items="${listaCorCabelo}" var="cabelo">
                                        <c:choose>
                                            <c:when test="${loginBean.preferencia.corCabelo.contains(cabelo)}">
                                                <option value="${cabelo.idCorCabelo}" selected> ${cabelo.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${cabelo.idCorCabelo}"> ${cabelo.nome}</option>
                                            </c:otherwise>
                                         </c:choose>
                                    </c:forEach>
                                </select>
                                <p style="font-size: 13px;margin-left: 215px;margin-top: -20px;">Mantenha pressionado o botão Ctrl/Command para selecionar várias opções.</p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    
                    <br>
                    
                    <c:choose>
                        <c:when test="${(not empty loginBean)}">
                            <div class="w3_form_body_grid">
                                <span>Cor da Pele</span>
                                <select multiple id="corPele" name="corPele" class="frm-field">
                                    <c:forEach items="${listaCorPele}" var="pele">
                                        <c:choose>
                                            <c:when test="${loginBean.preferencia.corPele.contains(pele)}">
                                                <option value="${pele.idCorPele}" selected> ${pele.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${pele.idCorPele}"> ${pele.nome}</option>
                                            </c:otherwise>
                                         </c:choose>
                                    </c:forEach>
                                </select>
                                <p style="font-size: 13px;margin-left: 215px;margin-top: -20px;">Mantenha pressionado o botão Ctrl/Command para selecionar várias opções.</p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="w3_form_body_grid">
                                <span>Cor da Pele</span>
                                <select multiple id="corPele" name="corPele" class="frm-field">
                                    <c:forEach items="${listaCorPele}" var="pele">
                                        <c:choose>
                                            <c:when test="${loginBean.preferencia.corPele.contains(pele)}">
                                                <option value="${pele.idCorPele}" selected> ${pele.nome}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${pele.idCorPele}"> ${pele.nome}</option>
                                            </c:otherwise>
                                         </c:choose>
                                    </c:forEach>
                                </select>
                                <p style="font-size: 13px;margin-left: 215px;margin-top: -20px;">Mantenha pressionado o botão Ctrl/Command para selecionar várias opções.</p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    
                    <br>
                    
                            <div class="w3_form_body_grid">
                                <span>Dias disponíveis</span>
                                <div class="diaSemana">
                                    <input type="checkbox" id="coding" name="diaSemana" value="Segunda" onchange="segunda()">
                                    <label for="coding">Segunda</label>
                                    <div id="horario-segunda" hidden>
                                        <div class="horaMin">
                                            <label>Início</label>
                                            <input id="horaMin" type="number" name="horaMin"/>h
                                            <input id="horaMin" type="number" name="minutoMin"/>min
                                        </div>
                                        <div class="horaMax">
                                            <label>Fim</label>
                                            <input id="horaMax" type="number" name="horaMax"/>h
                                            <input id="horaMax" type="number" name="minutoMax"/>min
                                        </div>
                                    </div>
                                </div>
                                <div class="diaSemana">
                                    <input type="checkbox" id="coding" name="diaSemana" value="Terca" onchange="terca()">
                                    <label for="coding">Terca</label>
                                    <div id="horario-terca" hidden>
                                        <div class="horaMin">
                                            <label>Início</label>
                                            <input id="horaMin" type="number" name="horaMin"/>h
                                            <input id="horaMin" type="number" name="minutoMin"/>min
                                        </div>
                                        <div class="horaMax">
                                            <label>Fim</label>
                                            <input id="horaMax" type="number" name="horaMax"/>h
                                            <input id="horaMax" type="number" name="minutoMax"/>min
                                        </div>
                                    </div>
                                </div>
                                <div class="diaSemana">
                                    <input type="checkbox" id="coding" name="diaSemana" value="Quarta" onchange="quarta()">
                                    <label for="coding">Quarta</label>
                                    <div id="horario-quarta" hidden>
                                        <div class="horaMin">
                                            <label>Início</label>
                                            <input id="horaMin" type="number" name="horaMin"/>h
                                            <input id="horaMin" type="number" name="minutoMin"/>min
                                        </div>
                                        <div class="horaMax">
                                            <label>Fim</label>
                                            <input id="horaMax" type="number" name="horaMax"/>h
                                            <input id="horaMax" type="number" name="minutoMax"/>min
                                        </div>
                                    </div>
                                </div>
                                <div class="diaSemana">
                                    <input type="checkbox" id="coding" name="diaSemana" value="Quinta" onchange="quinta()">
                                    <label for="coding">Quinta</label>
                                    <div id="horario-quinta" hidden>
                                        <div class="horaMin">
                                            <label>Início</label>
                                            <input id="horaMin" type="number" name="horaMin"/>h
                                            <input id="horaMin" type="number" name="minutoMin"/>min
                                        </div>
                                        <div class="horaMax">
                                            <label>Fim</label>
                                            <input id="horaMax" type="number" name="horaMax"/>h
                                            <input id="horaMax" type="number" name="minutoMax"/>min
                                        </div>
                                    </div>
                                </div>
                                <div class="diaSemana">
                                    <input type="checkbox" id="coding" name="diaSemana" value="Sexta" onchange="sexta()">
                                    <label for="coding">Sexta</label>
                                    <div id="horario-sexta" hidden>
                                        <div class="horaMin">
                                            <label>Início</label>
                                            <input id="horaMin" type="number" name="horaMin"/>h
                                            <input id="horaMin" type="number" name="minutoMin"/>min
                                        </div>
                                        <div class="horaMax">
                                            <label>Fim</label>
                                            <input id="horaMax" type="number" name="horaMax"/>h
                                            <input id="horaMax" type="number" name="minutoMax"/>min
                                        </div>
                                    </div>
                                </div>
                                <div class="diaSemana">
                                    <input type="checkbox" id="coding" name="diaSemana" value="Sabado" onchange="sabado()">
                                    <label for="coding">Sabado</label>
                                    <div id="horario-sabado" hidden>
                                        <div class="horaMin">
                                            <label>Início</label>
                                            <input id="horaMin" type="number" name="horaMin"/>h
                                            <input id="horaMin" type="number" name="minutoMin"/>min
                                        </div>
                                        <div class="horaMax">
                                            <label>Fim</label>
                                            <input id="horaMax" type="number" name="horaMax"/>h
                                            <input id="horaMax" type="number" name="minutoMax"/>min
                                        </div>
                                    </div>
                                </div>
                                <div class="diaSemana">
                                    <input type="checkbox" id="coding" name="diaSemana" value="Domingo" onchange="domingo()">
                                    <label for="coding">Domingo</label>
                                    <div id="horario-domingo" hidden>
                                        <div class="horaMin">
                                            <label>Início</label>
                                            <input id="horaMin" type="number" name="horaMin"/>h
                                            <input id="horaMin" type="number" name="minutoMin"/>min
                                        </div>
                                        <div class="horaMax">
                                            <label>Fim</label>
                                            <input id="horaMax" type="number" name="horaMax"/>h
                                            <input id="horaMax" type="number" name="minutoMax"/>min
                                        </div>
                                    </div>
                                </div>
                            </div>

                    <%--<c:choose>--%>
                        <%--<c:when test="${(not empty loginBean)}">--%>
                            <input type="submit" value="Salvar">
                        <%--</c:when>--%>
                        <%--<c:otherwise>--%>
                            <!--<input type="submit" value="?">-->
                        <%--</c:otherwise>--%>
                    <%--</c:choose>--%>
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
