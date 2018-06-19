<%-- 
    Document   : notificacao
    Created on : 12/06/2018, 20:05:11
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
       <table class="table">
            <tbody>
                <tr style="border-bottom: 1px solid #ddd;">
                    <td>
                        <i class="fa fa-dollar"></i>
                    </td>
                    <td>
                        Orçamento. Lorem ipsum dolor sit amet, Ut enim ad minim veniam, quisenim ad minim.
                    </td>
                    <td style="width: 125px;">
                        <a href="#">
                            <i class="fa fa-eye"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-check"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-times"></i>
                        </a>
                    </td>
                </tr>
                <tr style="border-bottom: 1px solid #ddd;">
                    <td>
                        <i class="fa fa-music"></i>
                    </td>
                    <td>
                        Festa. Lorem ipsum dolor sit amet, Ut enim ad minim veniam, quisenim ad minim.
                    </td>
                    <td style="width: 125px;">
                        <a href="#">
                            <i class="fa fa-eye"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-check"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-times"></i>
                        </a>
                    </td>
                </tr>
                <tr style="border-bottom: 1px solid #ddd;">
                    <td>
                        <i class="fa fa-glass"></i>
                    </td>
                    <td>
                        Encontro. Lorem ipsum dolor sit amet, Ut enim ad minim veniam, quisenim ad minim.
                    </td>
                    <td style="width: 125px;">
                        <a href="#">
                            <i class="fa fa-eye"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-check"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-times"></i>
                        </a>
                    </td>
                </tr>
                <tr style="border-bottom: 1px solid #ddd;">
                    <td>
                        <i class="fa fa-heart"></i>
                    </td>
                    <td>
                        Casamento. Lorem ipsum dolor sit amet, Ut enim ad minim veniam, quisenim ad minim.
                    </td>
                    <td style="width: 125px;">
                        <a href="#">
                            <i class="fa fa-eye"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-check"></i>
                        </a>
                        <a href="#">
                            <i class="fa fa-times"></i>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
        <!--<button id="convites" name="convites" value="${loginBean.idCliente}">Atualizar</button>-->
                                
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
    </body>
</html>
