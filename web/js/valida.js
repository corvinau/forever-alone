/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function existeEmail(campoemail){
    email = campoemail.value;
    var url = "http://localhost:28313/ForeverAlone/webresources/Ajax/existeemail/"+email;
        var res = false;
    $.ajax({
        type : "GET",
        url : url,
        async: false,
        dataType : 'json',
        success : function(data) {
            res = data;
        },
        error : function() {
            res = false;
        }
    });
    if (res){
    alert('E-mail já existente');
    campoemail.value = "";
    campoemail.focus();
        return !res;
    }
}

function existeCPF(campocpf){
    if(validaCPF(campocpf)){
            cpf = campocpf.value.toString().replace(/[^0-9]/g, "");
        var url = "http://localhost:28313/ForeverAlone/webresources/Ajax/existecpf/"+cpf;
        var res = false;
        $.ajax({
            type : "GET",
            url : url,
            async: false,
            dataType : 'json',
            success : function(data) {
                res = data;
            },
            error : function() {
                res = false;
            }
        });
            if (res){
            alert('CPF já existente');
            campocpf.value = "";
            campocpf.focus();
            return !res;
            }				
    }
}

function validaCPF(campocpf) {    
    cpf = campocpf.value.toString().replace(/[^0-9]/g, "");
    var numeros, digitos, soma, i, resultado, digitos_iguais;
    digitos_iguais = 1;
    if (cpf.length < 11){
        document.forms[0].onsubmit = false;
        return false;
    }
    for (i = 0; i < cpf.length - 1; i++)
          if (cpf.charAt(i) != cpf.charAt(i + 1))
                {
                digitos_iguais = 0;
                break;
                }
    if (!digitos_iguais)
          {
          numeros = cpf.substring(0,9);
          digitos = cpf.substring(9);
          soma = 0;
          for (i = 10; i > 1; i--)
                soma += numeros.charAt(10 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(0)){
                alert("CPF inválido.");
                campocpf.focus();
                document.forms[0].onsubmit = false;
                return false;
          }
          numeros = cpf.substring(0,10);
          soma = 0;
          for (i = 11; i > 1; i--)
                soma += numeros.charAt(11 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(1)){
                alert("CPF inválido.");
                campocpf.focus();
                document.forms[0].onsubmit = false;
                return false;
          }
          return true;
          }
    else    	{
        alert("CPF inválido.");
        campocpf.value = "";
        campocpf.focus();
        document.forms[0].onsubmit = false;
        return false;
    }
  }
  
 function validaIdade(campoidade) {
     if(campoidade.value.length > 9){
        var dia_aniversario = campoidade.value.substring(0,2);
        var mes_aniversario = campoidade.value.substring(3,5);
        var ano_aniversario = campoidade.value.substring(6,10);

         var d = new Date,
            ano_atual = d.getFullYear(),
            mes_atual = d.getMonth() + 1,
            dia_atual = d.getDate(),

            ano_aniversario = +ano_aniversario,
            mes_aniversario = +mes_aniversario,
            dia_aniversario = +dia_aniversario,

            quantos_anos = ano_atual - ano_aniversario;

        if (mes_atual < mes_aniversario || mes_atual == mes_aniversario && dia_atual < dia_aniversario) {
            quantos_anos--;
        }

        var idade = quantos_anos < 0 ? 0 : quantos_anos;

        if(idade<18){
            alert('Apenas maiores de 18 anos podem se cadastrar.');
            campoidade.value = "";
            campoidade.focus();
            return false;
        }else
            return true;
    }
    return true;
}