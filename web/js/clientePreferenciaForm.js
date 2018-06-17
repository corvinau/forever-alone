function segunda() {
    if($(":checkbox").is(":checked")) {
        var horaMin = document.createElement("div");
        $(horaMin).attr('class', 'horaMin');
        
        var labelMin = document.createElement("label");
        horaMin.appendChild(labelMin);
        
        var textMin = document.createTextNode("Início");
        labelMin.appendChild(textMin);
        
        var inputHoraMin = document.createElement("input");
        $(inputHoraMin).attr('id', 'horaMin');
        $(inputHoraMin).attr('type', 'number');
        $(inputHoraMin).attr('name', 'horaMin');
        horaMin.appendChild(inputHoraMin);
        
        var textHrMin = document.createTextNode("h");
        horaMin.appendChild(textHrMin);
        
        var inputMinutoMin = document.createElement("input");
        $(inputMinutoMin).attr('id', 'horaMin');
        $(inputMinutoMin).attr('type', 'number');
        $(inputMinutoMin).attr('name', 'minutoMin');
        horaMin.appendChild(inputMinutoMin);
        
        var textMnMin = document.createTextNode("min");
        horaMin.appendChild(textMnMin);
        
        
        var horaMax = document.createElement("div");
        $(horaMax).attr('class', 'horaMax');
        
        var labelMax = document.createElement("label");
        horaMax.appendChild(labelMax);
        
        var textMax = document.createTextNode("Fim");
        labelMax.appendChild(textMax);
        
        var inputHoraMax = document.createElement("input");
        $(inputHoraMax).attr('id', 'horaMax');
        $(inputHoraMax).attr('type', 'number');
        $(inputHoraMax).attr('name', 'horaMax');
        horaMax.appendChild(inputHoraMax);
        
        var textHrMax = document.createTextNode("h");
        horaMax.appendChild(textHrMax);
        
        var inputMinutoMax = document.createElement("input");
        $(inputMinutoMax).attr('id', 'horaMax');
        $(inputMinutoMax).attr('type', 'number');
        $(inputMinutoMax).attr('name', 'minutoMax');
        horaMax.appendChild(inputMinutoMax);
        
        var textMnMax = document.createTextNode("min");
        horaMax.appendChild(textMnMax);


        $("div#horario-segunda").append(horaMin);
        $("div#horario-segunda").append(horaMax);
    } else {
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function terca() {
    if($(":checkbox").is(":checked")) {
        var horaMin = document.createElement("div");
        $(horaMin).attr('class', 'horaMin');
        
        var labelMin = document.createElement("label");
        horaMin.appendChild(labelMin);
        
        var textMin = document.createTextNode("Início");
        labelMin.appendChild(textMin);
        
        var inputHoraMin = document.createElement("input");
        $(inputHoraMin).attr('id', 'horaMin');
        $(inputHoraMin).attr('type', 'number');
        $(inputHoraMin).attr('name', 'horaMin');
        horaMin.appendChild(inputHoraMin);
        
        var textHrMin = document.createTextNode("h");
        horaMin.appendChild(textHrMin);
        
        var inputMinutoMin = document.createElement("input");
        $(inputMinutoMin).attr('id', 'horaMin');
        $(inputMinutoMin).attr('type', 'number');
        $(inputMinutoMin).attr('name', 'minutoMin');
        horaMin.appendChild(inputMinutoMin);
        
        var textMnMin = document.createTextNode("min");
        horaMin.appendChild(textMnMin);
        
        
        var horaMax = document.createElement("div");
        $(horaMax).attr('class', 'horaMax');
        
        var labelMax = document.createElement("label");
        horaMax.appendChild(labelMax);
        
        var textMax = document.createTextNode("Fim");
        labelMax.appendChild(textMax);
        
        var inputHoraMax = document.createElement("input");
        $(inputHoraMax).attr('id', 'horaMax');
        $(inputHoraMax).attr('type', 'number');
        $(inputHoraMax).attr('name', 'horaMax');
        horaMax.appendChild(inputHoraMax);
        
        var textHrMax = document.createTextNode("h");
        horaMax.appendChild(textHrMax);
        
        var inputMinutoMax = document.createElement("input");
        $(inputMinutoMax).attr('id', 'horaMax');
        $(inputMinutoMax).attr('type', 'number');
        $(inputMinutoMax).attr('name', 'minutoMax');
        horaMax.appendChild(inputMinutoMax);
        
        var textMnMax = document.createTextNode("min");
        horaMax.appendChild(textMnMax);


        $("div#horario-terca").append(horaMin);
        $("div#horario-terca").append(horaMax);
    } else {
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function quarta() {
    if($(":checkbox").is(":checked")) {
        var horaMin = document.createElement("div");
        $(horaMin).attr('class', 'horaMin');
        
        var labelMin = document.createElement("label");
        horaMin.appendChild(labelMin);
        
        var textMin = document.createTextNode("Início");
        labelMin.appendChild(textMin);
        
        var inputHoraMin = document.createElement("input");
        $(inputHoraMin).attr('id', 'horaMin');
        $(inputHoraMin).attr('type', 'number');
        $(inputHoraMin).attr('name', 'horaMin');
        horaMin.appendChild(inputHoraMin);
        
        var textHrMin = document.createTextNode("h");
        horaMin.appendChild(textHrMin);
        
        var inputMinutoMin = document.createElement("input");
        $(inputMinutoMin).attr('id', 'horaMin');
        $(inputMinutoMin).attr('type', 'number');
        $(inputMinutoMin).attr('name', 'minutoMin');
        horaMin.appendChild(inputMinutoMin);
        
        var textMnMin = document.createTextNode("min");
        horaMin.appendChild(textMnMin);
        
        
        var horaMax = document.createElement("div");
        $(horaMax).attr('class', 'horaMax');
        
        var labelMax = document.createElement("label");
        horaMax.appendChild(labelMax);
        
        var textMax = document.createTextNode("Fim");
        labelMax.appendChild(textMax);
        
        var inputHoraMax = document.createElement("input");
        $(inputHoraMax).attr('id', 'horaMax');
        $(inputHoraMax).attr('type', 'number');
        $(inputHoraMax).attr('name', 'horaMax');
        horaMax.appendChild(inputHoraMax);
        
        var textHrMax = document.createTextNode("h");
        horaMax.appendChild(textHrMax);
        
        var inputMinutoMax = document.createElement("input");
        $(inputMinutoMax).attr('id', 'horaMax');
        $(inputMinutoMax).attr('type', 'number');
        $(inputMinutoMax).attr('name', 'minutoMax');
        horaMax.appendChild(inputMinutoMax);
        
        var textMnMax = document.createTextNode("min");
        horaMax.appendChild(textMnMax);


        $("div#horario-quarta").append(horaMin);
        $("div#horario-quarta").append(horaMax);
    } else {
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}
function quinta() {
    if($(":checkbox").is(":checked")) {
        var horaMin = document.createElement("div");
        $(horaMin).attr('class', 'horaMin');
        
        var labelMin = document.createElement("label");
        horaMin.appendChild(labelMin);
        
        var textMin = document.createTextNode("Início");
        labelMin.appendChild(textMin);
        
        var inputHoraMin = document.createElement("input");
        $(inputHoraMin).attr('id', 'horaMin');
        $(inputHoraMin).attr('type', 'number');
        $(inputHoraMin).attr('name', 'horaMin');
        horaMin.appendChild(inputHoraMin);
        
        var textHrMin = document.createTextNode("h");
        horaMin.appendChild(textHrMin);
        
        var inputMinutoMin = document.createElement("input");
        $(inputMinutoMin).attr('id', 'horaMin');
        $(inputMinutoMin).attr('type', 'number');
        $(inputMinutoMin).attr('name', 'minutoMin');
        horaMin.appendChild(inputMinutoMin);
        
        var textMnMin = document.createTextNode("min");
        horaMin.appendChild(textMnMin);
        
        
        var horaMax = document.createElement("div");
        $(horaMax).attr('class', 'horaMax');
        
        var labelMax = document.createElement("label");
        horaMax.appendChild(labelMax);
        
        var textMax = document.createTextNode("Fim");
        labelMax.appendChild(textMax);
        
        var inputHoraMax = document.createElement("input");
        $(inputHoraMax).attr('id', 'horaMax');
        $(inputHoraMax).attr('type', 'number');
        $(inputHoraMax).attr('name', 'horaMax');
        horaMax.appendChild(inputHoraMax);
        
        var textHrMax = document.createTextNode("h");
        horaMax.appendChild(textHrMax);
        
        var inputMinutoMax = document.createElement("input");
        $(inputMinutoMax).attr('id', 'horaMax');
        $(inputMinutoMax).attr('type', 'number');
        $(inputMinutoMax).attr('name', 'minutoMax');
        horaMax.appendChild(inputMinutoMax);
        
        var textMnMax = document.createTextNode("min");
        horaMax.appendChild(textMnMax);


        $("div#horario-quinta").append(horaMin);
        $("div#horario-quinta").append(horaMax);
    } else {
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function sexta() {
    if($(":checkbox").is(":checked")) {
        var horaMin = document.createElement("div");
        $(horaMin).attr('class', 'horaMin');
        
        var labelMin = document.createElement("label");
        horaMin.appendChild(labelMin);
        
        var textMin = document.createTextNode("Início");
        labelMin.appendChild(textMin);
        
        var inputHoraMin = document.createElement("input");
        $(inputHoraMin).attr('id', 'horaMin');
        $(inputHoraMin).attr('type', 'number');
        $(inputHoraMin).attr('name', 'horaMin');
        horaMin.appendChild(inputHoraMin);
        
        var textHrMin = document.createTextNode("h");
        horaMin.appendChild(textHrMin);
        
        var inputMinutoMin = document.createElement("input");
        $(inputMinutoMin).attr('id', 'horaMin');
        $(inputMinutoMin).attr('type', 'number');
        $(inputMinutoMin).attr('name', 'minutoMin');
        horaMin.appendChild(inputMinutoMin);
        
        var textMnMin = document.createTextNode("min");
        horaMin.appendChild(textMnMin);
        
        
        var horaMax = document.createElement("div");
        $(horaMax).attr('class', 'horaMax');
        
        var labelMax = document.createElement("label");
        horaMax.appendChild(labelMax);
        
        var textMax = document.createTextNode("Fim");
        labelMax.appendChild(textMax);
        
        var inputHoraMax = document.createElement("input");
        $(inputHoraMax).attr('id', 'horaMax');
        $(inputHoraMax).attr('type', 'number');
        $(inputHoraMax).attr('name', 'horaMax');
        horaMax.appendChild(inputHoraMax);
        
        var textHrMax = document.createTextNode("h");
        horaMax.appendChild(textHrMax);
        
        var inputMinutoMax = document.createElement("input");
        $(inputMinutoMax).attr('id', 'horaMax');
        $(inputMinutoMax).attr('type', 'number');
        $(inputMinutoMax).attr('name', 'minutoMax');
        horaMax.appendChild(inputMinutoMax);
        
        var textMnMax = document.createTextNode("min");
        horaMax.appendChild(textMnMax);


        $("div#horario-sexta").append(horaMin);
        $("div#horario-sexta").append(horaMax);
    } else {
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function sabado() {
    if($(":checkbox").is(":checked")) {
        var horaMin = document.createElement("div");
        $(horaMin).attr('class', 'horaMin');
        
        var labelMin = document.createElement("label");
        horaMin.appendChild(labelMin);
        
        var textMin = document.createTextNode("Início");
        labelMin.appendChild(textMin);
        
        var inputHoraMin = document.createElement("input");
        $(inputHoraMin).attr('id', 'horaMin');
        $(inputHoraMin).attr('type', 'number');
        $(inputHoraMin).attr('name', 'horaMin');
        horaMin.appendChild(inputHoraMin);
        
        var textHrMin = document.createTextNode("h");
        horaMin.appendChild(textHrMin);
        
        var inputMinutoMin = document.createElement("input");
        $(inputMinutoMin).attr('id', 'horaMin');
        $(inputMinutoMin).attr('type', 'number');
        $(inputMinutoMin).attr('name', 'minutoMin');
        horaMin.appendChild(inputMinutoMin);
        
        var textMnMin = document.createTextNode("min");
        horaMin.appendChild(textMnMin);
        
        
        var horaMax = document.createElement("div");
        $(horaMax).attr('class', 'horaMax');
        
        var labelMax = document.createElement("label");
        horaMax.appendChild(labelMax);
        
        var textMax = document.createTextNode("Fim");
        labelMax.appendChild(textMax);
        
        var inputHoraMax = document.createElement("input");
        $(inputHoraMax).attr('id', 'horaMax');
        $(inputHoraMax).attr('type', 'number');
        $(inputHoraMax).attr('name', 'horaMax');
        horaMax.appendChild(inputHoraMax);
        
        var textHrMax = document.createTextNode("h");
        horaMax.appendChild(textHrMax);
        
        var inputMinutoMax = document.createElement("input");
        $(inputMinutoMax).attr('id', 'horaMax');
        $(inputMinutoMax).attr('type', 'number');
        $(inputMinutoMax).attr('name', 'minutoMax');
        horaMax.appendChild(inputMinutoMax);
        
        var textMnMax = document.createTextNode("min");
        horaMax.appendChild(textMnMax);


        $("div#horario-sabado").append(horaMin);
        $("div#horario-sabado").append(horaMax);
    } else {
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function domingo() {
    if($(":checkbox").is(":checked")) {
        var horaMin = document.createElement("div");
        $(horaMin).attr('class', 'horaMin');
        
        var labelMin = document.createElement("label");
        horaMin.appendChild(labelMin);
        
        var textMin = document.createTextNode("Início");
        labelMin.appendChild(textMin);
        
        var inputHoraMin = document.createElement("input");
        $(inputHoraMin).attr('id', 'horaMin');
        $(inputHoraMin).attr('type', 'number');
        $(inputHoraMin).attr('name', 'horaMin');
        horaMin.appendChild(inputHoraMin);
        
        var textHrMin = document.createTextNode("h");
        horaMin.appendChild(textHrMin);
        
        var inputMinutoMin = document.createElement("input");
        $(inputMinutoMin).attr('id', 'horaMin');
        $(inputMinutoMin).attr('type', 'number');
        $(inputMinutoMin).attr('name', 'minutoMin');
        horaMin.appendChild(inputMinutoMin);
        
        var textMnMin = document.createTextNode("min");
        horaMin.appendChild(textMnMin);
        
        
        var horaMax = document.createElement("div");
        $(horaMax).attr('class', 'horaMax');
        
        var labelMax = document.createElement("label");
        horaMax.appendChild(labelMax);
        
        var textMax = document.createTextNode("Fim");
        labelMax.appendChild(textMax);
        
        var inputHoraMax = document.createElement("input");
        $(inputHoraMax).attr('id', 'horaMax');
        $(inputHoraMax).attr('type', 'number');
        $(inputHoraMax).attr('name', 'horaMax');
        horaMax.appendChild(inputHoraMax);
        
        var textHrMax = document.createTextNode("h");
        horaMax.appendChild(textHrMax);
        
        var inputMinutoMax = document.createElement("input");
        $(inputMinutoMax).attr('id', 'horaMax');
        $(inputMinutoMax).attr('type', 'number');
        $(inputMinutoMax).attr('name', 'minutoMax');
        horaMax.appendChild(inputMinutoMax);
        
        var textMnMax = document.createTextNode("min");
        horaMax.appendChild(textMnMax);


        $("div#horario-domingo").append(horaMin);
        $("div#horario-domingo").append(horaMax);
    } else {
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}