<%-- 
    Document   : localListar
    Created on : 09/06/2018, 22:58:19
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
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <section class="text-center">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Lista de Locais</h3>
                </div>
            </div>
        </section>
        
        <div class="container">
            <div class="sim-button button12" style="margin-top: 0px; float: right; background: rgb(65, 131, 154); margin-bottom: 15px;">
                <a href="FuncionarioServlet?action=localForm">Novo</a>
            </div>
            <div class="clearfix"> </div>
        </div>
        
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Estado</th>
                        <th>Cidade</th>
                        <th>Bairo</th>
                        <th>Rua</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaLocal}" var="local" >
                        <tr>
                            <td>${local.idLocal}</td>
                            <td>${local.nomeEstabelecimento}</td>
                            <td>${local.endereco.cidade.uf.sigla} </td>
                            <td>${local.endereco.cidade.nome}</td>
                            <td>${local.endereco.bairro}</td>
                            <td>${local.endereco.rua}</td>
                            <td>
                                <a href="ClientesServlet?action=show&id=${local.idLocal}">
                                    <i class="fa fa-eye"></i>
                                </a>
                                <a href="#">
                                    <i class="fa fa-pencil"></i>
                                </a>
                                <a href="#">
                                    <i class="fa fa-times"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
