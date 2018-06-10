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
    </head>
    <body>
        <%@include file="header.jsp"%>
        
        <!-- sobre -->
        <div class="about-w3layouts" id="about">
            <div class="tittle-agileinfo">
                <h3>Sobre Nós</h3>
            </div>
            <div class="about-right">
                <h3 class="subheading-agileits-w3layouts">BLABLABLA</h3>
                <p class="para-agileits-w3layouts">
                    Duis sit amet nisi quis leo fermentum vestibulum vitae eget augue. Nulla quam nunc,
                    vulputate id urna at, tempor tincidunt metus. Sed feugiat quam nec mauris mattis malesuada.
                </p>
            </div>
            <div class="clearfix"> </div>
        </div>
        
        <%@include file="footer.jsp"%>
        
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
