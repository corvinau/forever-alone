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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DescricaoForm</h1>
        <form action="ClienteServlet?action=updateDescricao" method="POST">
            <div>
                <input id="imagem" type="text" name="imagem"/>
            </div>
            <div><input type="text" name="resumo" value="" placeholder="Resumo"/></div>
            <div>
                <select id="corCabelo" name="corCabelo">
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
            <div>
                <select id="corPele" name="corPele">
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
            <div><input type="submit" class="btn btn-primary" value="Update"/></div>
        </form>
    </body>
</html>
