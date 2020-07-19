<%@page import="com.webapp.sihaafrica.Services.iVisiteur"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- ========== Meta Tags ========== -->
    <meta charset="UTF-8">
    <meta name="description" content="SIHA AFRICA Salon De La Santé, Du Bien-Être Et Du Tourisme Médical">
    
    <!-- ========== Title ========== -->
    <title>Plan des Stands</title>
    <!-- Favicons -->
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
    <link href="/index/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/assets/css/animate.min.css">
    <!-- Custom styles for this template -->
    <link href="/assets/css/main.css" rel="stylesheet">
    <!-- Venobox -->
    <link href="/js/venobox/venobox.css" rel="stylesheet">
    <!-- Carousel -->
  	<link href="/js/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  	<style type="text/css">
  		.table {
  			width: 100%;
  		}
  	</style>
</head>
<body>


<div class="banner">
    <img src="/index/images/banner.png" class="banner" alt="Banner" />
</div>


<section class="pt100 pb100">
		<div class="container">
		<div class="notresize">
		<div class="section_title">
            <h3 style="text-transform: none;margin-bottom: 3px;" class="title">
                Pour réserver votre stand,<br />cliquez sur le ou les espace(s) numéroté(s) choisi(s)
            </h3>
            <p style="color: black;font-weight: bold;">
            	N.B: 
            	<br />- Chaque espace numéroté représente un stand de 9 M². <span style="color: red;">(Pas plus d'un (01) exposant par stand de 9M ²)</span>
            	<br />- Les espaces colorés en rouge sont déjà réservés.
            	<br />- Si vous utilisez un téléphone portable ou le plan du salon n'est pas visible, <a style="font-weight: bold;font-size: 14px;color:red;" href="https://drive.google.com/open?id=1_sVsT7VLhmixxbCBegG_7CQLfLkzrKJA" target="_blank">Cliquez ici</a> pour télécharger le plan et choisir votre stand
            	<br />- Pour consulter le plan du salon avec les noms des éxposants. Veuillez <a style="font-weight:bold;font-size:14px;color:red;" href="" target="_blank">Cliquez ici</a>
            </p>
        </div>
        <%
        	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
    		iVisiteur standsVisiteursComp = (iVisiteur) context.getBean("iVisiteurImpl");
    		List<String> standsVisiteurs = standsVisiteursComp.showAllReservedStands();
    		List<String> finalStands = new ArrayList<>();
    		for(int i=0;i<standsVisiteurs.size();i++){
    			if(standsVisiteurs.get(i).toString().contains(",")){
    				String [] allStands = standsVisiteurs.get(i).toString().split(",");
    				for(int j=0;j<allStands.length;j++){
    					finalStands.add(allStands[j]);
    				}
    			}else{
    				finalStands.add(standsVisiteurs.get(i).toString());
    			}
    		}
    		System.out.println(finalStands.toString());
        %>
        <br /><br />
        <div style="margin-left: 205px;">
        	<h5>Entrée de la salle des éxpositions</h5>
            <img style="margin-left: 130px;" src="/index/images/arrowdown.png" height="40" width="40" alt="Entrée de la salle d'éxposition" />
        </div>
        <div class="row">
            <div style="padding-left: 278px;" class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("01")){%><td style="background-color: #DD2C00;color: #fff;">01</td><%}else{%><td >01</td><%}%>
                    </tr>
                </table>
            </div>
            <div style="padding-left: 128px;" class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("02")){%><td style="background-color: #DD2C00;color: #fff;">02</td><%}else{%><td >02</td><%}%>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div style="margin-left: 15px;" class="col-md-2">
                <table border="1">
                        <tr>
                            <%if(finalStands.contains("07")){%><td style="background-color: #DD2C00;color: #fff;">07</td><%}else{%><td >07</td><%}%>
                            <%if(finalStands.contains("06")){%><td style="background-color: #DD2C00;color: #fff;">06</td><%}else{%><td >06</td><%}%>
                            <%if(finalStands.contains("05")){%><td style="background-color: #DD2C00;color: #fff;">05</td><%}else{%><td >05</td><%}%>
                            <%if(finalStands.contains("04")){%><td style="background-color: #DD2C00;color: #fff;">04</td><%}else{%><td>04</td><%}%>
                            <%if(finalStands.contains("03")){%><td style="background-color: #DD2C00;color: #fff;">03</td><%}else{%><td>03</td><%}%>
                            <%if(finalStands.contains("02")){%><td style="background-color: #DD2C00;color: #fff;">02</td><%}else{%><td>02</td><%}%>
                        </tr>
                </table>
            </div>
            <div style="margin-left: 200px;" class="col-md-2">
                <table border="1">
                        <tr>
                            <%if(finalStands.contains("73")){%><td style="background-color: #DD2C00;color: #fff;" >73</td><%}else{%><td>73</td><%}%>
                            <%if(finalStands.contains("72")){%><td style="background-color: #DD2C00;color: #fff;" >72</td><%}else{%><td>72</td><%}%>
                            <%if(finalStands.contains("71")){%><td style="background-color: #DD2C00;color: #fff;" >71</td><%}else{%><td>71</td><%}%>
                            <%if(finalStands.contains("70")){%><td style="background-color: #DD2C00;color: #fff;" >70</td><%}else{%><td>70</td><%}%>
                            <%if(finalStands.contains("69")){%><td style="background-color: #DD2C00;color: #fff;" >69</td><%}else{%><td>69</td><%}%>
                            <%if(finalStands.contains("68")){%><td style="background-color: #DD2C00;color: #fff;" >68</td><%}else{%><td>68</td><%}%>
                        </tr>
                </table>
            </div>
        </div><br />
        <div class="row">
            <div class="col-md-1">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("08")){%><td style="background-color: #DD2C00;color: #fff;" >08</td><%}else{%><td >08</td><%}%>
                    </tr>
                </table>
                <table style="margin-top: 20px;" border="">
                	<tr>
                        <%if(finalStands.contains("09")){%><td style="background-color: #DD2C00;color: #fff;" >09</td><%}else{%><td >09</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("10")){%><td style="background-color: #DD2C00;color: #fff;" >10</td><%}else{%><td >10</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("11")){%><td style="background-color: #DD2C00;color: #fff;" >11</td><%}else{%><td >11</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("12")){%><td style="background-color: #DD2C00;color: #fff;" >12</td><%}else{%><td >12</td><%}%>
                    </tr>
                </table>
            </div>
            <div class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("36")){%><td style="background-color: #DD2C00;color: #fff;" >36</td><%}else{%><td >36</td><%}%>
                        <%if(finalStands.contains("37")){%><td style="background-color: #DD2C00;color: #fff;" >37</td><%}else{%><td >37</td><%}%>
                        <%if(finalStands.contains("38")){%><td style="background-color: #DD2C00;color: #fff;" >38</td><%}else{%><td >38</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("33")){%><td style="background-color: #DD2C00;color: #fff;" >33</td><%}else{%><td >33</td><%}%>
                        <%if(finalStands.contains("34")){%><td style="background-color: #DD2C00;color: #fff;" >34</td><%}else{%><td >34</td><%}%>
                        <%if(finalStands.contains("35")){%><td style="background-color: #DD2C00;color: #fff;" >35</td><%}else{%><td >35</td><%}%>
                    </tr>
                </table>
                <table style="margin-top: 20px;" border="1">
                    <tr style="padding-top: 30px;">
                        <%if(finalStands.contains("30")){%><td style="background-color: #DD2C00;color: #fff;" >30</td><%}else{%><td >30</td><%}%>
                        <%if(finalStands.contains("31")){%><td style="background-color: #DD2C00;color: #fff;" >31</td><%}else{%><td >31</td><%}%>
                        <%if(finalStands.contains("32")){%><td style="background-color: #DD2C00;color: #fff;" >32</td><%}else{%><td >32</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("27")){%><td style="background-color: #DD2C00;color: #fff;" >27</td><%}else{%><td >27</td><%}%>
                        <%if(finalStands.contains("28")){%><td style="background-color: #DD2C00;color: #fff;" >28</td><%}else{%><td >28</td><%}%>
                        <%if(finalStands.contains("29")){%><td style="background-color: #DD2C00;color: #fff;" >29</td><%}else{%><td >29</td><%}%>
                    </tr>
                </table>
            </div>
            <div class="col-md-2">
                <table border="1">
                    <tr>
                       	<%if(finalStands.contains("39")){%><td style="background-color: #DD2C00;color: #fff;" >39</td><%}else{%><td >39</td><%}%>
                        <%if(finalStands.contains("40")){%><td style="background-color: #DD2C00;color: #fff;" >40</td><%}else{%><td >40</td><%}%>
                        <%if(finalStands.contains("41")){%><td style="background-color: #DD2C00;color: #fff;" >41</td><%}else{%><td >41</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("42")){%><td style="background-color: #DD2C00;color: #fff;" >42</td><%}else{%><td >42</td><%}%>
                        <%if(finalStands.contains("43")){%><td style="background-color: #DD2C00;color: #fff;" >43</td><%}else{%><td >43</td><%}%>
                        <%if(finalStands.contains("44")){%><td style="background-color: #DD2C00;color: #fff;" >44</td><%}else{%><td >44</td><%}%>
                    </tr>
                </table>
                <table style="margin-top: 20px;" border="1">
                    <tr style="padding-top: 30px;">
                        <%if(finalStands.contains("45")){%><td style="background-color: #DD2C00;color: #fff;" >45</td><%}else{%><td >45</td><%}%>
                        <%if(finalStands.contains("46")){%><td style="background-color: #DD2C00;color: #fff;" >46</td><%}else{%><td >46</td><%}%>
                        <%if(finalStands.contains("47")){%><td style="background-color: #DD2C00;color: #fff;" >47</td><%}else{%><td >47</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("48")){%><td style="background-color: #DD2C00;color: #fff;" >48</td><%}else{%><td >48</td><%}%>
                        <%if(finalStands.contains("49")){%><td style="background-color: #DD2C00;color: #fff;" >49</td><%}else{%><td >49</td><%}%>
                        <%if(finalStands.contains("50")){%><td style="background-color: #DD2C00;color: #fff;" >50</td><%}else{%><td >50</td><%}%>
                    </tr>
                </table>
            </div>
            <div class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("60")){%><td style="background-color: #DD2C00;color: #fff;" >60</td><%}else{%><td >60</td><%}%>
                        <%if(finalStands.contains("61")){%><td style="background-color: #DD2C00;color: #fff;" >61</td><%}else{%><td >61</td><%}%>
                        <%if(finalStands.contains("62")){%><td style="background-color: #DD2C00;color: #fff;" >62</td><%}else{%><td >62</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("57")){%><td style="background-color: #DD2C00;color: #fff;" >57</td><%}else{%><td >57</td><%}%>
                        <%if(finalStands.contains("58")){%><td style="background-color: #DD2C00;color: #fff;" >58</td><%}else{%><td >58</td><%}%>
                        <%if(finalStands.contains("59")){%><td style="background-color: #DD2C00;color: #fff;" >59</td><%}else{%><td >59</td><%}%>
                    </tr>
                </table>
                <table style="margin-top: 20px;" border="1">
                    <tr style="padding-top: 30px;">
                        <%if(finalStands.contains("54")){%><td style="background-color: #DD2C00;color: #fff;" >54</td><%}else{%><td>54</td><%}%>
                        <%if(finalStands.contains("55")){%><td style="background-color: #DD2C00;color: #fff;" >55</td><%}else{%><td >55</td><%}%>
                        <%if(finalStands.contains("56")){%><td style="background-color: #DD2C00;color: #fff;" >56</td><%}else{%><td >56</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("51")){%><td style="background-color: #DD2C00;color: #fff;" >51</td><%}else{%><td >51</td><%}%>
                        <%if(finalStands.contains("52")){%><td style="background-color: #DD2C00;color: #fff;" >52</td><%}else{%><td >52</td><%}%>
                        <%if(finalStands.contains("53")){%><td style="background-color: #DD2C00;color: #fff;" >53</td><%}else{%><td>53</td><%}%>
                    </tr>
                </table>
            </div>
            <div class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("67")){%><td style="background-color: #DD2C00;color: #fff;" >67</td><%}else{%><td >67</td><%}%>
                    </tr>
                </table>
                <table style="margin-top: 20px;" border="1">
                	<tr>
                        <%if(finalStands.contains("66")){%><td style="background-color: #DD2C00;color: #fff;" >66</td><%}else{%><td >66</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("65")){%><td style="background-color: #DD2C00;color: #fff;" >65</td><%}else{%><td >65</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("64")){%><td style="background-color: #DD2C00;color: #fff;" >64</td><%}else{%><td >64</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("63")){%><td style="background-color: #DD2C00;color: #fff;" >63</td><%}else{%><td >63</td><%}%>
                    </tr>
                </table>
            </div>
        </div>
        
        <div class="row">
            <div style="margin-left: 53px;" class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("13")){%><td style="background-color: #DD2C00;color: #fff;" >13</td><%}else{%><td>13</td><%}%>
                        <%if(finalStands.contains("14")){%><td style="background-color: #DD2C00;color: #fff;" >14</td><%}else{%><td>14</td><%}%>
                        <%if(finalStands.contains("15")){%><td style="background-color: #DD2C00;color: #fff;" >15</td><%}else{%><td>15</td><%}%>
                        <%if(finalStands.contains("16")){%><td style="background-color: #DD2C00;color: #fff;" >16</td><%}else{%><td id="st16">16</td><%}%>
                    </tr>
                    <tr>
                    
                    </tr>
                </table>
            </div>
            <div style="margin-left: 42px;" class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("20")){%><td style="background-color: #DD2C00;color: #fff;" >20</td><%}else{%><td id="samec">20</td><%}%>
                        <%if(finalStands.contains("21")){%><td style="background-color: #DD2C00;color: #fff;" >21</td><%}else{%><td id="samea">21</td><%}%>
                        <%if(finalStands.contains("22")){%><td style="background-color: #DD2C00;color: #fff;" >22</td><%}else{%><td id="samee">22</td><%}%>
                    </tr>
                    <tr>
                        <%if(finalStands.contains("17")){%><td style="background-color: #DD2C00;color: #fff;" >17</td><%}else{%><td id="samed">17</td><%}%>
                        <%if(finalStands.contains("18")){%><td style="background-color: #DD2C00;color: #fff;" >18</td><%}else{%><td id="sameb">18</td><%}%>
                        <%if(finalStands.contains("19")){%><td style="background-color: #DD2C00;color: #fff;" >19</td><%}else{%><td id="samef">19</td><%}%>
                    </tr>
                </table>
            </div>
            <div style="margin-left: -5px;" class="col-md-2">
                <table border="1">
                    <tr>
                        <%if(finalStands.contains("23")){%><td style="background-color: #DD2C00;color: #fff;" >23</td><%}else{%><td >23</td><%}%>
                        <%if(finalStands.contains("24")){%><td style="background-color: #DD2C00;color: #fff;" >24</td><%}else{%><td >24</td><%}%>
                        <%if(finalStands.contains("25")){%><td style="background-color: #DD2C00;color: #fff;" >25</td><%}else{%><td >25</td><%}%>
                        <%if(finalStands.contains("26")){%><td style="background-color: #DD2C00;color: #fff;" >26</td><%}else{%><td >26</td><%}%>
                    </tr>
                    <tr>
                    	
                    </tr>
                </table>
                
            </div>
            </div>
	<div style="margin-top: 15px;margin-left: 95px;">
		<h6>- Pour changer votre choix, double cliquez sur le ou les espace(s) sélectionné(s)</h6>
		<h6>- Pour confirmer votre réservation, vous devez cliquer sur <button id="confirmStand" class="btn btn-danger">Confirmer</button></h6>
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
<!-- Script Plans -->
<script src="/assets/js/plans.js"></script>
<!-- Venobox -->
<script src="/assets/js/venobox/venobox.min.js"></script>

 <!-- Superfish -->
 <script src="/assets/js/owlcarousel/superfish.min.js"></script>
</body>
</html>