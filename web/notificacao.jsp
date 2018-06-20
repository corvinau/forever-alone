<%-- 
    Document   : notificacao
    Created on : 12/06/2018, 20:05:11
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
window.onload = function getConvites(){
                var url = "http://localhost:28313/ForeverAlone/webresources/Ajax/convites/"+${loginBean.idCliente};
                $.ajax({
                    type : "GET",
                    url : url, // URL da sua Servlet
                    // Parâmetro passado para a Servlet
                    dataType : 'json',
                    success : function(data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        $.each(data, function(i, obj) {
                            switch (obj.tipo) {
                            case 'E':
                                $("#encontro").append('<td><i class="fa fa-glass"></i></td><td>ENCONTRO '+obj.idConvite+'</td><td style="width: 125px;"><a href="EncontroServlet?action=aceitarEncontro&id='+obj.idConvite+'"><i class="fa fa-check"></i></a><a href="EncontroServlet?action=cancelarEncontro&id='+obj.idConvite+'"><i class="fa fa-times"></i></a></td>');
                                break;
                            case 'F':
                                $("#festa").append('<td><i class="fa fa-music"></i></td><td>FESTA '+obj.idConvite+'</td><td style="width: 125px;"><a href="FestaServlet?action=aceitarFesta&id='+obj.idConvite+'"><i class="fa fa-check"></i></a><a href="FestaServlet?action=cancelarFesta&id='+obj.idConvite+'"><i class="fa fa-times"></i></a></td>');
                                break;
                            case 'C':
                                $("#casamento").append('<td><i class="fa fa-heart"></i></td><td>CASAMENTO '+obj.idConvite+'</td><td style="width: 125px;"><a href="CasamentoServlet?action=aceitarCasamento&id='+obj.idConvite+'"><i class="fa fa-check"></i></a><a href="CasamentoServlet?action=cancelarCasamento&id='+obj.idConvite+'"><i class="fa fa-times"></i></a></td>');
                                break;
                            case 'O':
                                $("#orcamento").append('<td><i class="fa fa-dollar"></i></td><td>ORÇAMENTO '+obj.idConvite+'</td><td style="width: 125px;"><a href="OrcamentoServlet?action=aceitarOrcamento&id='+obj.idConvite+'"><i class="fa fa-check"></i></a><a href="OrcamentoServlet?action=cancelarOrcamento&id='+obj.idConvite+'"><i class="fa fa-times"></i></a></td>');
                                break;
                            default:
                                break;
                        }
                        });
                    },
                    error : function(request, textStatus, errorThrown) {
                        alert(request.status + ', Error: ' + request.statusText);
                        // Erro
                    }
                });
            }
</script>
<html>
    <body>
       <table class="table">
            <tbody>
                <tr id="encontro" style="border-bottom: 1px solid #ddd;"></tr>
                <tr id="festa" style="border-bottom: 1px solid #ddd;"></tr>
                <tr id="orcamento" style="border-bottom: 1px solid #ddd;"></tr>
                <tr id="casamento" style="border-bottom: 1px solid #ddd;"></tr>
            </tbody>
        </table>
        <!--<button id="convites" name="convites" value="${loginBean.idCliente}">Atualizar</button>-->
    </body>
</html>
