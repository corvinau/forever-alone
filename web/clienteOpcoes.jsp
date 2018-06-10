<%-- 
    Document   : clienteOpcoes
    Created on : 04/06/2018, 20:59:13
    Author     : ArtVin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forever Alone</title>
    </head>
    <body>
        <%@include file="headerLogged.jsp"%>
        
        <div class="container">
            <div class="col-md-3 login-center-info">
                <h1>Opcões</h1>
                <div class="sim-button button12">
                    <a href="ClienteServlet?action=formDescricao">Descricao</a>
                </div>
                <div class="sim-button button12">
                    <a href="ClienteServlet?action=formPreferencia">Preferencia</a>
                </div>
                <div class="sim-button button12">
                    <a href="ClienteServlet?action=formHorario">Horario</a>
                </div>
                <div class="sim-button button12">
                    <a href="ClienteServlet?action=switchDisp">On/Off</a>
                </div>
            </div>
	</div>
        
<div class="row">
  <div class="col-sm-4 login-center-info">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 login-center-info">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>

  <div class="col-sm-4 login-center-info">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 login-center-info">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Special title treatment</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
</div>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
