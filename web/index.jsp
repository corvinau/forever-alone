<%-- 
    Document   : index
    Created on : 20/05/2018, 21:50:41
    Author     : ArtVin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Elite Match a Matrimonial Category Bootstrap Responsive Website Template  | Home :: W3layouts</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Elite Match Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
        Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
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
        <!--fonts-->
        <link href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Dancing+Script:400,700" rel="stylesheet">
        <!--//fonts-->
    </head>
    <body>
        <!-- header -->
        <div class="banner-w3ls" id="home">
            <div class="container">
                <div class="header-inner">
                    <h1 class="logo">
			<a href="index.html">Forever<span>Alone</span></a>
                    </h1>
                    <div class="header-right-w3ls">
                            <a href="UsuarioServlet?action=formLogin">Logar</a>
                            <a href="UsuarioServlet?action=formCliente">Cadastrar</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        
        <!-- arthur -->
        <div class="about-w3layouts" id="about" style="margin-bottom: 5%;">
            <div class="tittle-agileinfo">
                <h3 style="font-family: 'Source Sans Pro', sans-serif;">Sobre Nós</h3>
            </div>
            <div class="about-right">
                <h3 class="subheading-agileits-w3layouts">BLABLABLA</h3>
                <p class="para-agileits-w3layouts">Duis sit amet nisi quis leo fermentum vestibulum vitae eget augue. Nulla quam nunc, vulputate id urna at, tempor tincidunt metus. Sed feugiat quam nec mauris mattis malesuada.</p>
            </div>
            <div class="clearfix"> </div>
        </div>
        
        <!-- footer -->
        <div>
            <div class="botttom-nav-agileits">
                <ul>
                    <li><a href="index.html">Home</a></li>
                </ul>
            </div>
            <div class="footer-w3layouts">
                <div class="container">
                    <div class="agile-copy">
                        <p>All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        
        <a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function($) {
                $(".scroll").click(function(event){		
                    event.preventDefault();
                    $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
                });
            });
        </script>
        <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    </body>
</html>
