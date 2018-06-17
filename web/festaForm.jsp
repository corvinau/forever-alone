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
        <title>Forever Alone</title>
        <link href="css/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript" >
            $(function(){
                $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
            });
        </script>
    </head>
    <body>
        
        <%@include file="headerLogged.jsp"%>
        
         <c:if test="${!(empty loginBean) && loginBean.tipo != 'F' && loginBean.tipo != 'f'}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Apenas funcionarios podem cadastrar festas enquanto estão logados" />
            </jsp:forward>
        </c:if>
        
        <c:if test="${not empty msg}">
            <div class="container alert alert-warning" role="alert">
                <span>${msg}</span>
            </div>
        </c:if>
        
        <div class="login elite-app">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Cadastro festa</h3>
                </div>
                <div class="col-md-12 login-form-w3-agile">
                    <form action="FestaServlet?action=cadastroFesta" method="POST">
                
                    <div class="w3_form_body_grid">
                        <span>Tema da Festa</span>
                        <input type="text" name="tema" value="" placeholder="Tema da festa"/>
                    </div>
                        
                    <div class="w3_form_body_grid w3_form_body_grid1">
                        <span>Data</span>
                        <input id="datepicker" name="data" type="text" placeholder="dd/mm/yyyy" value="">
                    </div>
                        
                    <div class="w3_form_body_grid w3_form_body_grid1">
                        <span>Hora</span>
                        <input type="number" name="hora" value="" placeholder="Hora"/>
                    </div>
                        
                    <div class="w3_form_body_grid w3_form_body_grid1">
                        <span>Minuto</span>
                        <input type="number" name="minuto" value="" placeholder="Minuto"/>
                    </div>

                    <div class="w3_form_body_grid">
                        <span>Local da Festa</span>
                        <select id="local" name="local" class="frm-field">
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

                    <input type="submit" value="Salvar">
                    </form>
                </div>
            </div>
        </div>
                
        <%@include file="footer.jsp"%>
    </body>
</html>
