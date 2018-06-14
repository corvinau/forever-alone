<%-- 
    Document   : notificacao
    Created on : 12/06/2018, 20:05:11
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script type="text/javascript" >
            $(function(){
                $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
            });

            $(document).ready(function(){
                $( "#convites" ).change(function() {
                  getCidades(false);
                });
            });
            
            function getCidades(preencherPrimeiroForm){
                preencherPrimeiroForm = false;
                var clienteId = $("#convites").val();
                var url = "http://localhost:28313/ForeverAlone/webresources/Ajax/convite/"+clienteId;
                $.ajax({
                    type : "GET",
                    url : url, // URL da sua Servlet
                    // Parâmetro passado para a Servlet
                    dataType : 'json',
                    success : function(data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        if(!preencherPrimeiroForm){
                            $("#tbody").empty();
                        }
                        $.each(data, function(i, obj) {
                            if(obj.tipo = 'E' || obj.tipo = 'e'){
                                $("#tbody").append('<tr>\n\
                                                        <td> Encontro com ' + obj.convidado.nome + '</td>\n\
                                                    </tr>');
                            }
                            else if(obj.tipo)
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
       <table class="table">
           <button id="convites" name="convites" value="${loginBean.idCliente}">Atualizar</button>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>CPF</th>
                        <th>Cargo</th>
                        <th>Data de Nascimento</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody id="tbody">
                    <tr>
                        <td>${funcionario.idFuncionario}</td>
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.email}</td>
                        <td>${funcionario.cpf}</td>
                        <td>${funcionario.cargo}</td>
                        <td>${funcionario.dataNasc}</td>
                        <td>
                            <a href="FuncionarioServlet?action=show&id=${funcionario.idFuncionario}">
                                <!--Não faz nd-->
                                <i class="material-icons">visibility</i> 
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
    </body>
</html>
