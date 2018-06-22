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
        <title>JSP Page</title>
    </head>
    <body>
        Casar se com :
        <c:choose>
            <c:when test="${loginBean.idCliente == encontro.cliente.idCliente}">
                ${encontro.convite.convidado.nome}
                <c:set var="convidando" value="${encontro.convite.convidado.idCliente}" ></c:set>
            </c:when>
            <c:otherwise>
                ${encontro.cliente.nome}
                <c:set var="convidando" value="${encontro.cliente.nome}" ></c:set>
            </c:otherwise>
        </c:choose>
        <form action="CasamentoServlet?action=solicitarCasamento&idConvidando=${convidando}" method="POST">
            <input type="text" name="padre" id="padre" placeholder="Padre">
            <input type="text" name="igreja" id="igreja" placeholder="Igreja">
            <input type="text" name="localLuaMel" id="localLuaMel" placeholder="LocalLuaMel">
            <input type="text" name="data" id="data" placeholder="data">
            <input type="text" name="hora" id="hora" placeholder="hora">
            <input type="text" name="data" id="data" placeholder="data">
            <input type="text" name="qtdConvidados" id="qtdConvidados" placeholder="qtdConvidados">
            <div id="padrinho">
                <input type="text" name="cojuges1" id="conjuges" placeholder="conjuges">
                <input type="text" name="emailConjuge1" id="emailConjuge" placeholder="emailConjuge">
            </div>
            <div id="padrinho">
                <input type="text" name="cojuges2" id="conjuges" placeholder="conjuges">
                <input type="text" name="emailConjuge2" id="emailConjuge" placeholder="emailConjuge">
            </div>
            <input type="submit" value="Pedido">
        </form>
    </body>
</html>
