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
        <!--favicon-->
        <link rel="shortcut icon" href="images/favicon.ico">
        <!-- //for-mobile-apps -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap -->
        <link href="css/font-awesome.css" rel="stylesheet"> <!-- Font awesome -->
        <link href="css/owl.carousel.css" rel="stylesheet"><!-- Clients -->
        <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" /><!-- Pop-up -->
        <link href="css/lsb.css" rel="stylesheet" type="text/css"><!-- gallery -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/main.css" rel="stylesheet" type="text/css" media="all" />
        <!--fonts-->
        <link href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Allura" rel="stylesheet">
        <!--//fonts-->
        
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        
        <script type="text/javascript">
            $(document).ready(function() {
            /*
                var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear' 
                };
            */								
            $().UItoTop({ easingType: 'easeOutQuart' });
            });
	</script>
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
    </head>
    <body>
        <!-- header -->
        <div class="banner-w3ls" id="home">
            <div class="container">
                <div class="header-inner">
                    <h1 class="logo">
			<a href="index.jsp">Forever<span>Alone</span></a>
                    </h1>
                    <div class="header-right-w3ls">
                        <a href="UsuarioServlet?action=formLogin">Logar</a>
                        <a href="UsuarioServlet?action=formCliente">Cadastrar</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </body>
</html>
