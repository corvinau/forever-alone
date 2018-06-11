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
        <!--Pegar o jquery do projeto, botei esse só pra testar-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forever Alone</title>
        <script>
            function valorMudou()
            {
                if($('#check-segunda').is(":checked"))   
                    $("#horario-segunda").show();
                else
                    $("#horario-segunda").hide();
            }
        </script>
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <form action="ClienteServlet?action=updatePreferencia" method="POST">
            <div>
                <label for="sexo">Sexo:</label>
                <select id="sexo" name="sexo">
                    <option value="M">M</option>
                    <option value="F">F</option>
                </select>
            </div>
            <div>
                <label for="idadeMin">Idade Mínima:</label>
                <input id="idadeMin" type="number" name="idadeMin"/>
            </div>
            <div>
                <label for="idadeMax">Idade Máxima:</label>
                <input id="idadeMax" type="number" name="idadeMax"/>
            </div>
            <div class="CoresCabelo">
                <span>Cor de Cabelo:</span>
                <div>
                    <c:forEach items="${listaCorCabelo}" var="cabelo">
                        <c:choose>
                            <c:when test="${loginBean.preferencia.corCabelo.contains(cabelo)}">
                                <input type="checkbox" id="coding" name="cabelo" value="${cabelo.idCorCabelo}" checked>
                                <label for="coding">${cabelo.nome}</label>
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" id="coding" name="cabelo" value="${cabelo.idCorCabelo}">
                                <label for="coding">${cabelo.nome}</label>
                            </c:otherwise>
                         </c:choose>
                    </c:forEach>
                </div>
            </div>
            <div class="CoresPele">
                <span>Cor de Pele:</span>
                <div>
                    <c:forEach items="${listaCorPele}" var="pele">
                        <c:choose>
                            <c:when test="${loginBean.preferencia.corPele.contains(pele)}">
                                <input type="checkbox" id="coding" name="pele" value="${pele.idCorPele}" checked>
                                <label for="coding">${pele.nome}</label>
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" id="coding" name="pele" value="${pele.idCorPele}">
                                <label for="coding">${pele.nome}</label>
                            </c:otherwise>
                         </c:choose>
                    </c:forEach>
                </div>
            </div>
            <div>
                <div>
                    <input type="checkbox" id="check-segunda" name="diaSemana" value="Segunda" onchange="valorMudou()">
                    <label for="coding">Segunda</label>
                    <div id="horario-segunda" hidden="hidden">
                        <input id="horaMin" type="number" name="horaMin"/>
                        <input id="horaMin" type="number" name="minutoMin"/>
                        <input id="horaMax" type="number" name="horaMax"/>
                        <input id="horaMax" type="number" name="minutoMax"/>
                    </div>
                </div>
                <div>
                    <input type="checkbox" id="coding" name="diaSemana" value="Terca" >
                    <label for="coding">Terca</label>
                    <input id="horaMin" type="number" name="horaMin"/>
                    <input id="horaMin" type="number" name="minutoMin"/>
                    <input id="horaMax" type="number" name="horaMax"/>
                    <input id="horaMax" type="number" name="minutoMax"/>
                </div>
                <div>
                    <input type="checkbox" id="coding" name="diaSemana" value="Quarta">
                    <label for="coding">Quarta</label>
                    <input id="horaMin" type="number" name="horaMin"/>
                    <input id="horaMin" type="number" name="minutoMin"/>
                    <input id="horaMax" type="number" name="horaMax"/>
                    <input id="horaMax" type="number" name="minutoMax"/>
                </div>
                <div>
                    <input type="checkbox" id="coding" name="diaSemana" value="Quinta" >
                    <label for="coding">Quinta</label>
                    <input id="horaMin" type="number" name="horaMin"/>
                    <input id="horaMin" type="number" name="minutoMin"/>
                    <input id="horaMax" type="number" name="horaMax"/>
                    <input id="horaMax" type="number" name="minutoMax"/>
                </div>
                <div>
                    <input type="checkbox" id="coding" name="diaSemana" value="Sexta" >
                    <label for="coding">Sexta</label>
                    <input id="horaMin" type="number" name="horaMin"/>
                    <input id="horaMin" type="number" name="minutoMin"/>
                    <input id="horaMax" type="number" name="horaMax"/>
                    <input id="horaMax" type="number" name="minutoMax"/>
                </div>
                <div>
                    <input type="checkbox" id="coding" name="diaSemana" value="Sabado">
                    <label for="coding">Sabado</label>
                    <input id="horaMin" type="number" name="horaMin"/>
                    <input id="horaMin" type="number" name="minutoMin"/>
                    <input id="horaMax" type="number" name="horaMax"/>
                    <input id="horaMax" type="number" name="minutoMax"/>
                </div>
                <div>
                    <input type="checkbox" id="coding" name="diaSemana" value="Domingo" >
                    <label for="coding">Domingo</label>
                    <input id="horaMin" type="number" name="horaMin"/>
                    <input id="horaMin" type="number" name="minutoMin"/>
                    <input id="horaMax" type="number" name="horaMax"/>
                    <input id="horaMax" type="number" name="minutoMax"/>
                </div>
            </div>
            <input type="submit" class="btn btn-primary" value="Salvar"/>
        </form>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
