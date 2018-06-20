<%-- 
    Document   : clienteForm
    Created on : 01/06/2018, 22:07:19
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
        <script src="js/valida.js"></script>
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
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

            //Mascara CPF
            $( "#cpf" ).mask('000.000.000-00');

        </script>
    </head>
    <body>
        
        <c:choose>
            <c:when test="${(not empty loginBean)}">
                <%@include file="headerLogged.jsp"%>
            </c:when>
            <c:otherwise>
                <%@include file="header.jsp"%>
            </c:otherwise>
        </c:choose>
        
        <c:if test="${!(empty loginBean) && loginBean.tipo != 'F' && loginBean.tipo != 'f'}">
            <jsp:forward page="login.jsp">
                <jsp:param name="msg" value="Apenas funcionarios podem cadastrar clientes enquanto estão logados" />
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
                    <h3>Cadastro</h3>
                </div>
                <div class="col-md-12 login-form-w3-agile">
                <c:choose>
                    <c:when test="${(not empty loginBean) && loginBean.tipo != 'F' && loginBean.tipo != 'f'}">
                        <form action="#" method="POST">
                    </c:when>
                    <c:when test="${alterar}">
                        <form action="FuncionarioServlet?action=updateCliente" method="POST">
                    </c:when>
                    <c:when test="${visualizar}">
                        <form action="FuncionarioServlet?action=listaClientes" method="POST">
                    </c:when>
                    <c:otherwise>
                        <form action="UsuarioServlet?action=cadastroCliente" method="POST">
                    </c:otherwise>
                </c:choose>
                
                            <div class="w3_form_body_grid">
                                <span>Email*</span>
                                <input type="text" name="email" placeholder="Email" onblur="existeEmail(this);" value="<c:out value="${cliente.email}"/>" 
                                <c:out value="${visualizar? 'disabled' : ''}"/> required>
                            </div>

							<c:if test="${!visualizar}">
	                            <div class="w3_form_body_grid">
	                                <span><c:out value="${alterar? 'Nova ' : ''}"/>Senha*</span>
	                                <input type="password" name="senha" placeholder="<c:out value="${alterar? 'Nova ' : ''}"/>Senha" value="" required>
	                            </div>
	                            <div class="w3_form_body_grid">
	                                <span>Confirmar senha*</span>
	                                <input type="password" name="senhaConfirm" placeholder="Confirmar senha" value="" required>
	                            </div>
							</c:if>

                            <div class="w3_form_body_grid">
                                <span>Nome*</span>
                                <input type="text" name="nome" placeholder="Nome" value="<c:out value="${cliente.nome}"/>" 
                                <c:out value="${visualizar? 'disabled' : ''}"/> required>
                            </div>

                            <div class="w3_form_body_grid">
                                <span>CPF*</span>
                                <input type="text" name="cpf" id="cpf" placeholder="CPF" onblur="existeCPF(this);" value="<c:out value="${cliente.cpf}"/>" 
                                <c:out value="${visualizar? 'disabled' : ''}"/> required>
                            </div>

                            <div class="w3_form_body_grid w3_form_body_grid1">
                                <span>Data de nascimento*</span>
                                <input class="date" id="datepicker" name="dataNascimento" type="text" placeholder="dd/mm/yyyy" onchange="validaIdade(this);"
                                       <c:if test="${(not empty cliente.dataNasc)}" >
                                        value="<fmt:formatDate value="${cliente.dataNasc}" pattern="dd/mm/yyyy" />"
                                       </c:if> 
                                        <c:out value="${visualizar? 'disabled' : ''}"/> required>
                            </div>

                            <div class="w3_form_body_grid">
                                <span>Sexo*</span>
                                <select id="sexo" name="sexo" class="frm-field" <c:out value="${visualizar? 'disabled' : ''}"/> required>
                                    <option value="<c:out value="${(empty cliente.sexo)? 'M': cliente.sexo}"/>"><c:out value="${(empty cliente.sexo)? 'Homem': (cliente.sexo=='F'? 'Mulher': 'Homem')}"/></option>
                                    <option value="<c:out value="${(empty cliente.sexo)? 'F': (cliente.sexo=='M'? 'F' : 'M')}"/>"><c:out value="${(empty cliente.sexo)? 'Mulher': (cliente.sexo=='M'? 'Mulher': 'Homem')}"/></option>
                                </select>
                            </div>

                            <div class="w3_form_body_grid">
                                <span>Estado*</span>
                                <select id="uf" name="uf" class="frm-field" <c:out value="${visualizar? 'disabled' : ''}"/> required>
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
                                <span>Cidade*</span>
                                <select id="cidade" name="cidade" class="frm-field" <c:out value="${visualizar? 'disabled' : ''}"/> required>
                                    <option value="<c:out value="${cliente.endereco.cidade.idCidade}" />" selected><c:out value="${cliente.endereco.cidade.nome}" /></option>						
                                </select>
                            </div>

                            <div class="w3_form_body_grid">
                                <span>Bairro*</span>
                                <input type="text" name="bairro" placeholder="Bairro" value="<c:out value="${cliente.endereco.bairro}" />" 
                                <c:out value="${visualizar? 'disabled' : ''}"/> required>
                            </div>

                            <div class="w3_form_body_grid">
                                <span>Rua*</span>
                                <input type="text" name="rua" placeholder="Rua" value="<c:out value="${cliente.endereco.rua}" />" 
                                <c:out value="${visualizar? 'disabled' : ''}"/> required>
                            </div>

                            <div class="w3_form_body_grid">
                                <span>Número*</span>
                                <input type="text" name="numero" placeholder="Número" value="<c:out value="${cliente.endereco.numero}" />" 
                                <c:out value="${visualizar? 'disabled' : ''}"/> required>
                            </div>

                            <div class="w3_form_body_grid">
                                <span>Complemento</span>
                                <input type="text" name="complemento" placeholder="Complemento" value="<c:out value="${cliente.endereco.complemento}" />"
                                <c:out value="${visualizar? 'disabled' : ''}"/> >
                            </div>

	                    <c:choose>
	                        <c:when test="${(not empty loginBean) && loginBean.tipo != 'F' && loginBean.tipo != 'f'}">
	                            <input type="submit" value="Atualizar">
	                        </c:when>
                                <c:when test="${alterar}">
	                            <input type="submit" value="Atualizar">
	                        </c:when>
                                <c:when test="${visualizar}">
	                            <input type="submit" value="Voltar">
	                        </c:when>
	                        <c:otherwise>
	                            <input type="submit" value="Cadastrar">
	                        </c:otherwise>
	                    </c:choose>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp"%>
    </body>
</html>
