function segunda() {
    console.log($(":checkbox").is(":checked"));
    if($(":checkbox").is(":checked")) {
        console.log("if segunda");
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
        console.log("else segunda");
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function terca() {
    console.log($(":checkbox").is(":checked"));
    if($(":checkbox").is(":checked")) {
        console.log("if terca");
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
        console.log("else terca");
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function quarta() {
    console.log($(":checkbox").is(":checked"));
    if($(":checkbox").is(":checked")) {
    console.log("if quarta");
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
        console.log("else quarta");
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}
function quinta() {
    console.log($(":checkbox").is(":checked"));
    if($(":checkbox").is(":checked")) {
        console.log("if quinta");
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
        console.log("else quinta");
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function sexta() {
    console.log($(":checkbox").is(":checked"));
    if($(":checkbox").is(":checked")) {
        console.log("if sexta");
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
        console.log("else sexta");
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function sabado() {
    console.log($(":checkbox").is(":checked"));
    if($(":checkbox").is(":checked")) {
        console.log("if sabado");
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
        console.log("else sabado");
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}

function domingo() {
    console.log($(":checkbox").is(":checked"));
    if($(":checkbox").is(":checked")) {
        console.log("if domingo");
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
        console.log("else domingo");
        $(".horaMin").remove();
        $(".horaMax").remove();
    }
}