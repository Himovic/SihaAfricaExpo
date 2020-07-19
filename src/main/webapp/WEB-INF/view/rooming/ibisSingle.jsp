<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- ========== Meta Tags ========== -->
    <meta charset="UTF-8">
    <meta name="description" content="SIHA AFRICA Salon De La Santé, Du Bien-Être Et Du Tourisme Médical">
    <meta name="keywords" content="SIHA AFRICA Salon De La Santé, Du Bien-Être Et Du Tourisme Médical">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- ========== Title ========== -->
    <title>Réservation chambre Single à l'Ibis</title>
    <!-- ========== Favicon Ico ========== -->
    <link rel="icon" href="/assets/img/logo.ico">
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

<!--header start here -->
<div class="banner">
    <img src="/index/images/banner.png" class="banner" alt="Banner" />
</div>
<!--header end here-->


<section class="pt100 pb100">
	<div class="container">
		<div class="section_title">
            <h3 style="text-transform: none;color: #1f1039;" class="title">
                Réservation d'une chambre Single à l'Ibis
            </h3>
        </div>
        <c:set var="success" value="${success}" />
        <c:if test = "${success=='success'}">
			<div class="alert alert-success" role="alert">
  				Votre réservation a été prise en considération, nous vous la confirmerons par email dans les
  				meilleurs délais. Si vous souhaitez réserver encore une chambre single a l'Ibis 
  				veuillez remplir ce formulaire.
			</div>
		</c:if>
        <div class="row">
			<div class="col-md-6">
				<form action="/regIbisSingle" method="POST">
				<div class="form-group">
					<label for="clientsName">Nom et Prénom</label>
					<input type="text" class="form-control" name="clientsName" id="clientsName" required="required" /> 
				</div>
				<div class="form-group">
					<label for="companyPhone">Téléphone</label>
					<input type="text" class="form-control" name="companyPhone" id="companyPhone" required="required" /> 
				</div>
				<div class="form-group">
					<label for="clientEmail">Email</label>
					<input type="email" class="form-control" name="clientEmail" id="clientEmail" required="required" /> 
				</div>
				<div class="form-group">
					<label for="roomingType">Type de chambre</label>
					<input type="text" value="Chambre Single Avec petit déjeuner, pour une personne" class="form-control" name="roomingType" id="roomingType" readonly="true"/> 
				</div>
				<div class="form-group">
					<label for="arrivingDate">Date d'arrivée</label>
					<input type="date" class="form-control" name="arrivingDate" id="arrivingDate" />
				</div>
				<div class="form-group">
					<label for="leavingDate">Date de départ</label>
					<input type="date" class="form-control" name="leavingDate" id="leavingDate" />
				</div>
				<input type="submit" class="btn btn-primary" value="Confirmer" />
			</form>
			</div>
			<div class="col-md-6">
				
			</div>
        </div>
	</div>
</section>

<!--footer start -->
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