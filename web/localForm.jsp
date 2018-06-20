<%-- 
    Document   : localForm
    Created on : 09/06/2018, 22:58:30
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
            
            $(document).ready(function(){
                $( "#uf" ).change(function() {
                  getCidades(false);
                });
            });
            
            function getCidades(preencherPrimeiroForm){
                preencherPrimeiroForm = false;
                var estadoId = $("#uf").val();
                var url = "http://localhost:28313/ForeverAlone/webresources/Ajax/cidade/"+estadoId;
                $.ajax({
                    type : "GET",
                    url : url, // URL da sua Servlet
                    // Parâmetro passado para a Servlet
                    dataType : 'json',
                    success : function(data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        if(!preencherPrimeiroForm){
                            $("#cidade").empty();
                        }
                        $.each(data, function(i, obj) {
                            $("#cidade").append('<option value=' + obj.idCidade + '>' + obj.nome + '</option>');
                        });
                    },
                    error : function(request, textStatus, errorThrown) {
                        alert(request.status + ', Error: ' + request.statusText);
                        // Erro
                    }
                });
            }
        </script>
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <c:if test="${!(empty loginBean) && loginBean.tipo != 'F' && loginBean.tipo != 'f'}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Apenas funcionarios podem cadastrar locais enquanto estão logados" />
            </jsp:forward>
        </c:if>
        
        <c:if test="${not empty msg}">
            <div class="container alert alert-info" role="alert">
                <span>${msg}</span>
            </div>
        </c:if>
        
        <div class="login elite-app">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3>Cadastro local</h3>
                </div>
                <div class="col-md-12 login-form-w3-agile">
                    <form action="FuncionarioServlet?action=cadastroLocal" method="POST">
                
                    <div class="w3_form_body_grid">
                        <span>Estabelecimento</span>
                        <input type="text" name="nomeEstabelecimento" value="" value="" placeholder="Nome estabelecimento"/>
                    </div>

                    <div class="w3_form_body_grid">
                        <span>Estado</span>
                        <select id="uf" name="uf" class="frm-field">
                            <c:forEach items="${estados}" var="estado">
                                <c:choose>
                                    <c:when test="${cliente.endereco.cidade.uf.idUF == estado.idUF}">
                                        <option value="${estado.idUF}" selected>${estado.nome} - ${estado.sigla}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${estado.idUF}">${estado.nome} - ${estado.sigla}</option>
                                    </c:otherwise>
                                 </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="w3_form_body_grid">
                        <span>Cidade</span>
                        <select id="cidade" name="cidade" class="frm-field">
                            <option value="${cliente.cidadeCliente.idCidade}" selected>${cliente.cidadeCliente.nomeCidade}</option>
                        </select>
                    </div>

                    <div class="w3_form_body_grid">
                        <span>Bairro</span>
                        <input type="text" name="bairro" value="" placeholder="Bairro"/>
                    </div>

                    <div class="w3_form_body_grid">
                        <span>Rua</span>
                        <input type="text" name="rua" value="" placeholder="Rua"/>
                    </div>

                    <div class="w3_form_body_grid">
                        <span>Número</span>
                        <input type="text" name="numero" value="" placeholder="Número"/>
                    </div>

                    <div class="w3_form_body_grid">
                        <span>Complemento</span>
                        <input type="text" name="complemento" value="" placeholder="Complemento"/>
                    </div>

                    <input type="submit" value="Cadastrar">
                    </form>
                </div>
            </div>
        </div>
                
        <%@include file="footer.jsp"%>
    </body>
</html>
