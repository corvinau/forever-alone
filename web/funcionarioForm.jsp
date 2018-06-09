<%-- 
    Document   : funcionarioForm
    Created on : 09/06/2018, 20:03:29
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
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/ui/jquery-ui.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>
        <script type="text/javascript" >
            
            $(document).ready(function(){
                var date_input=$('input[name="data"]'); //our date input has the name "date"
                var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                var options={
                  format: 'dd/mm/yyyy',
                  container: container,
                  todayHighlight: true,
                  autoclose: true
                };
                date_input.datepicker(options);
                
                
                
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
        <c:if test="${!(empty loginBean) && loginBean.tipo != 'F' && loginBean.tipo != 'f' && loginBean.nome != \"admin\"}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Apenas funcionarios podem cadastrar clientes enquanto estão logados" />
            </jsp:forward>
        </c:if>
        <form action="FuncionarioServlet?action=cadastroFuncionario" method="POST">
            <div><input type="text" name="email" value="" placeholder="Email"/></div>
            <div><input type="text" name="nome" value="" placeholder="nome"/></div>
            <div><input type="text" name="cpf" value="" placeholder="cpf"/></div>
            <div><input type="text" name="dataNascimento" value="" placeholder="dataNascimento"/></div>
            <div>
                <select id="uf" name="uf">
                    <c:forEach items="${estados}" var="estado">
                        <c:choose>
                            <c:when test="${funcionario.endereco.cidade.uf.idUF == estado.idUF}">
                                <option value="${estado.idUF}" selected>${estado.nome} - ${estado.sigla}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${estado.idUF}">${estado.nome} - ${estado.sigla}</option>
                            </c:otherwise>
                         </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div>
                <select id="cidade" name="cidade">
                    <option value="${cliente.cidadeCliente.idCidade}" selected>${cliente.cidadeCliente.nomeCidade}</option>
                </select>
            </div>
            <div><input type="text" name="bairro" value="" placeholder="bairro"/></div>
            <div><input type="text" name="rua" value="" placeholder="rua"/></div>
            <div><input type="text" name="numero" value="" placeholder="numero"/></div>
            <div><input type="text" name="complemento" value="" placeholder="complemento"/></div>
            <div><input type="submit" class="btn btn-primary" value="Entrar"/></div>
        </form>
    </body>
</html>

