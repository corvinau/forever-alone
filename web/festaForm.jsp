<%-- 
    Document   : festaForm
    Created on : 10/06/2018, 01:51:16
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form festa</h1>
        <c:if test="${!(empty loginBean) && loginBean.tipo != 'F' && loginBean.tipo != 'f'}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Apenas funcionarios podem cadastrar clientes enquanto estão logados" />
            </jsp:forward>
        </c:if>
        <form action="FestaServlet?action=cadastroFesta" method="POST">
            <div><input type="text" name="tema" value="" placeholder="tema"/></div>
            <div><input type="text" name="data" value="" placeholder="data"/></div>
            <div><input type="number" name="hora" value="" placeholder="Hora"/></div>
            <div><input type="number" name="minuto" value="" placeholder="Minuto"/></div>
            <div>
                <select id="local" name="local">
                    <c:forEach items="${locais}" var="local">
                        <c:choose>
                            <c:when test="${festa.local.idLocal == local.idLocal}">
                                <option value="${local.idLocal}" selected>${local.nomeEstabelecimento}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${local.idLocal}">${local.nomeEstabelecimento}</option>
                            </c:otherwise>
                         </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div><input type="submit" class="btn btn-primary" value="Entrar"/></div>
        </form>
    </body>
</html>
