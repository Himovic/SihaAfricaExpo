<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <!-- ========== Meta Tags ========== -->
    <meta charset="UTF-8">
    <meta name="description" content="SIHA AFRICA Salon De La Santé, Du Bien-Être Et Du Tourisme Médical">
    <meta name="keywords" content="SIHA AFRICA Salon De La Santé, Du Bien-Être Et Du Tourisme Médical">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- ========== Title ========== -->
    <title>Envoi du Paiement B2B</title>
    <link href="/index/img/favicon.png" rel="icon">
  	<link href="/index/img/apple-touch-icon.png" rel="apple-touch-icon">
    <!-- ========== STYLESHEETS ========== -->
    <!-- Bootstrap CSS -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fonts Icon CSS -->
    <link href="/assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="/assets/css/et-line.css" rel="stylesheet">
    <link href="/assets/css/ionicons.min.css" rel="stylesheet">
    <!-- Carousel CSS -->
    <link href="/assets/css/owl.carousel.min.css" rel="stylesheet">
    <link href="/assets/css/owl.theme.default.min.css" rel="stylesheet">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="/assets/css/animate.min.css">
    <!-- Custom styles for this template -->
    <link href="/assets/css/main.css" rel="stylesheet">
    <!-- Venobox -->
    <link href="/assets/js/venobox/venobox.css" rel="stylesheet">
    <!-- Carousel -->
  	<link href="/assets/js/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
</head>
<body>

<!--  <div class="loader">
    <div class="loader-outter"></div>
    <div class="loader-inner"></div>
</div>-->

<img src="/index/images/banner.png" class="banner" />

<section class="pt100 pb100">
	<div class="container">
		<div style="margin-bottom: 0;" class="section_title">
            <h3 style="text-transform: none;color: #1f1039;" class="title">
                Téléchargez la copie de votre ordre de virement ici 
            </h3>
        </div>
        <%
        	WebApplicationContext x = WebApplicationContextUtils.getWebApplicationContext(application);
    		HttpSession currentSession = (HttpSession) x.getBean("currentSession");
    		String companyName = (String) currentSession.getAttribute("companyb");
        %>
        <div style="color: #000;" class="row">
            <div class="col-md-6">
                <form method="POST" action="/sendPaiementb" enctype="multipart/form-data">
                	<div class="form-group">
                		<label for="company">Entreprise</label>
                		<input type="text" class="form-control" name="company" id="company" value="<%=companyName %>" readonly="true"/>
                	</div>
                	<div class="form-group">
                		<label for="file">Ordre de virement</label>
                		<input type="file" name="paiement" id="file" class="form-control" required="required"/>
                	</div>
                	<input type="submit" class="btn btn-danger" value="Envoyer"/>
                </form>
            </div>
            <div class="col-md-6">
            	<img src="/assets/img/paiement.jpg" alt="Visiter" />
            </div>
        </div>
	</div>
</section>


<footer id="footer">
    <div class="footer-top">
      <div class="container">
        <div class="row">

          <div class="col-lg-3 col-md-6 footer-info">
            <img src="/index/img/logomaacom.png" alt="Maacom">
            <p class="text-justify">L’agence Maacom est spécialisée dans les secteurs de la communication par l’événement et du tourisme à l’échelle nationale et internationale, elle bénéficie d'une expertise en événementiel BtoB unique sur le marché, à laquelle elle associe des expertises pointues (Tourisme de Détente et de Loisirs, Tourisme Sportif, Tourisme d'Affaires, Santé et Digital).</p>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>Êvenements en cours</h4>
            <ul>
              <li><i class="fa fa-angle-right"></i> <a href="http://www.saidalya.net">Salon Saidalya</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="http://sihaafrica.com">Salon Siha Africa</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="http://cirtatourism.com">Salon du Tourisme et de l'équipements hôteliers</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-links">
            <h4>Êvenements a suivre</h4>
            <ul>
              <li><i class="fa fa-angle-right"></i> <a href="#">Salon de la Mariée</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Festivale du Music du Monde</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Festivale du Shooping</a></li>
              <li><i class="fa fa-angle-right"></i> <a href="#">Festivale des DJs</a></li>
            </ul>
          </div>

          <div class="col-lg-3 col-md-6 footer-contact">
            <h4>Contactez Nous</h4>
            <p>
              UV5, N° 21B, Ain El Bey <br>
              Nouvelle Ville - Ali Mendjeli<br>
              25016 - Constantine <br>
              <strong>Téléphone:</strong> +213 551 991 331<br>
              <strong>Email:</strong> info@maacom.pro<br>
            </p>

            <div class="social-links">
              <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
              <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
              <a href="#" class="instagram"><i class="fa fa-instagram"></i></a>
              <a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a>
              <a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a>
            </div>

          </div>

        </div>
      </div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong>Maacom</strong>. Tous les droits sont réservés
      </div>
      <div class="credits">
        <!--
          All the links in the footer should remain intact.
          You can delete the links only if you purchased the pro version.
          Licensing information: https://bootstrapmade.com/license/
          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=TheEvent
        -->
        Developed by <a style="color: white;" href="mailto:info@maacom.pro">Maacom</a>
      </div>
    </div>
  </footer>
<!--footer end -->
<!-- jquery -->
<script src="/assets/js/jquery.min.js"></script>
<!-- bootstrap -->
<script src="/assets/js/popper.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/waypoints.min.js"></script>
<!--slick carousel -->
<script src="/assets/js/owl.carousel.min.js"></script>
<!--parallax -->
<script src="/assets/js/parallax.min.js"></script>
<!--Counter up -->
<script src="/assets/js/jquery.counterup.min.js"></script>
<!--Counter down -->
<script src="/assets/js/jquery.countdown.min.js"></script>
<!-- WOW JS -->
<script src="/assets/js/wow.min.js"></script>
<!-- Custom js -->
<script src="/assets/js/main.js"></script>
<!-- Venobox -->
<script src="/assets/js/venobox/venobox.min.js"></script>
<!-- Owlcarousel -->
 <script src="/assets/js/owlcarousel/owl.carousel.min.js"></script>
 <!-- Superfish -->
 <script src="/assets/js/owlcarousel/superfish.min.js"></script>
</body>
</html>