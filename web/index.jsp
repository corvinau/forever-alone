<%-- 
    Document   : index
    Created on : 20/05/2018, 21:50:41
    Author     : ArtVin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forever Alone</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript">
            addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); }
        </script>
        <!-- //for-mobile-apps -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap -->
        <link href="css/font-awesome.css" rel="stylesheet"> <!-- Font awesome -->
        <link href="css/owl.carousel.css" rel="stylesheet"><!-- Clients -->
        <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" /><!-- Pop-up -->
        <link href="css/lsb.css" rel="stylesheet" type="text/css"><!-- gallery -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/main.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/owl.carousel.css" rel="stylesheet"><!-- Clients -->
        <!--fonts-->
        <link href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Allura" rel="stylesheet">
        <!--//fonts-->
    </head>
    <body>
        <%@include file="header.jsp"%>
        
        <div class="services" id="services">
            <div class="container">
		<div class="tittle-agileinfo">
                    <h3>Nossos serviços</h3>
                </div>
                <div class="w3_agileits_services_grids" style="display: flex;">
                    <div class="w3_agileits_services_grid">
                        <div class="w3_agileits_services_grid_agile">
                            <div class="w3_agileits_services_grid_1">
                                <i class="fa fa-search" aria-hidden="true" style="margin-left: auto;"></i>
                            </div>
                            <h3>Encontre pessoas com as caracteristicas desejadas</h3>
                        </div>
                    </div>
                    <div class="w3_agileits_services_grid">
                        <div class="w3_agileits_services_grid_agile">
                            <div class="w3_agileits_services_grid_1">
                                <i class="fa fa-list-alt" aria-hidden="true" style="margin-left: auto;"></i>
                            </div>
                            <h3>Visualize seus encontros</h3>
                        </div>
                    </div>
                    <div class="w3_agileits_services_grid">
                        <div class="w3_agileits_services_grid_agile">
                            <div class="w3_agileits_services_grid_1">
                                <i class="fa fa-users" aria-hidden="true" style="margin-left: auto;"></i>
                            </div>
                            <h3>Participe de festas</h3>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
	</div>
        
        <!-- sobre -->
        <div class="about-w3layouts" id="about">
            <div class="tittle-agileinfo">
                <h3>Sobre nós</h3>
            </div>
            <div class="about-right">
                <h3 class="subheading-agileits-w3layouts">
                    VENHA ENCONTRAR A PESSOA IDEAL PARA SUA VIDA 
                </h3>
                <p class="para-agileits-w3layouts">
                    VENHA ACHAR SEU CRUSH, ELE ESTÁ AQUI!!
                </p>
                <br><br>
                <h3 class="subheading-agileits-w3layouts">
                    NOSSO INTUITO
                </h3>
                <p class="para-agileits-w3layouts">
                    Vamos unir pessoas e concretizar relacionamentos para vida toda, e se não quiser casar 
                    VENHA FESTAR!!
                </p>
                <br><br>
                <h3 class="subheading-agileits-w3layouts">
                    PROTEGENDO SEUS DADOS PESSOAIS
                </h3>
                <p class="para-agileits-w3layouts">
                    Nós garantimos que suas informações pessoais e suas comunicações com seus candidatos 
                    não podem ser acessados ​​por qualquer parte externa.</p>
            </div>
            <div class="clearfix"> </div>
        </div>
        
        
        <div class="test" id="clients">
            <div class="container">
                <div class="tittle-agileinfo">
                    <h3 class="white-w3ls">Depoimentos</h3>
                </div>
		<div class="test-gri1">
                    <div id="owl-demo2" class="owl-carousel">
                        <div class="test-grid1">
                            <img src="images/t1.jpg" alt="" class="img-r">
                            <h4>Heloise Spew</h4>
                            <p>Nos encontramos em uma festa, marcamos alguns encontros e logo nos casamos. Tudo através do Forever Alone.</p>
                        </div>	
                        <div class="agile">
                            <div class="test-grid1">
                                <img src="images/t2.jpg" alt="" class="img-r">
                                <h4>David Antony</h4>
                                <p>Nosso primeiro encontro foi marcado por aqui, fizemos nosso orçamento com ótimos valores e hoje tenho a melhor esposa do mundo.</p>
                            </div>	
                        </div>
                        <div class="agile">
                            <div class="test-grid1">
                                <img src="images/t3.jpg" alt="" class="img-r">
                                <h4>Jack Braun</h4>
                                <p>Encontrei a mulher da minha vida através de um encontro marcado por aqui. Hoje temos a melhor familia do mundo</p>
                            </div>	
                        </div>					
                    </div>
		</div>	
            </div>
	</div>
        
        <script src="js/owl.carousel.js"></script>
        <!-- requried-jsfiles-for owl -->
        <script>
            $(document).ready(function() {
                $("#owl-demo2").owlCarousel({
                    items : 1,
                    lazyLoad : false,
                    autoPlay : true,
                    navigation : false,
                    navigationText :  false,
                    pagination : true,
                });
            });
        </script>
        
        <%@include file="footer.jsp"%>
    </body>
</html>
