<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="description" content="SIHA AFRICA Salon De La Santé, Du Bien-Être Et Du Tourisme Médical">
    <meta name="keywords" content="SIHA AFRICA Salon De La Santé, Du Bien-Être Et Du Tourisme Médical">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicons -->
  	<link href="/index/images/favicon.png" rel="icon">
  	<link href="/index/images/apple-touch-icon.png" rel="apple-touch-icon">
    <!-- Title Page-->
    <title>Inscription Exposant</title>
    <!-- Main CSS-->
    <link href="/registration/css/main.css" rel="stylesheet" media="all">
    <link href="/registration/css/bootstrap.min.css" rel="stylesheet" media="all">
    <link href="/registration/css/font-awesome.min.css" rel="stylesheet" media="all">
</head>
<body>
<img src="/index/images/banner.png" class="banner" />
	<div class="container">
		<c:set var="error" value="${error}" />
		<c:set var="errorDownloadLogo" value="${errorDownloadLogo}" />
		<c:set var="errorDownloadFile" value="${errorDownloadFile}" />
		<c:if test = "${error=='error'}">
			<div class="alert alert-danger" role="alert">
  				Vous devez remplir tout les champs obligatoire du formulaire.
			</div>
		</c:if>
		<c:if test = "${errorDownloadLogo=='errorDownloadLogo'}">
			<div class="alert alert-danger" role="alert">
  				Une érreure est apparue lors du téléchargement de votre Logo. Refaire a nouveau.
			</div>
		</c:if>
		<c:if test = "${errorDownloadFile=='errorDownloadFile'}">
			<div class="alert alert-danger" role="alert">
  				Une érreure est apparue lors du téléchargement du bon de commande. Refaire a nouveau.
			</div>
		</c:if>
		<br />
		<div class="row">
			<div class="col-md-10 offset=md-1">
				<div class="row">
					<div class="col-md-5 register-left">
						<h3>Informations et Tarifs</h3>
				
						<hr>
						<h3>Frais d'inscription (Obligatoires)</h3>
						<p style="margin-bottom: 5px;">
							<span style="color: #FAFAFA;font-weight: bold;">10000,00 DA en T.T.C. par 9M², comprennent :</span>
							<ul style="margin-bottom:5px;">
							<li>Invitations;</li>
							<li>Badges;</li>
							<li>Coordonnées de l’exposant sur le catalogue officiel de
							Saidalya 2020;</li>
							<li>02 Lunch Boxes par jour <br /><span style="font-size: 14px;">(servis par le Marriott pendant les 03 jours du Salon);</span></li>
							<li>Attestation de participation.</li>
						</ul>
						<span style="color: #FAFAFA;font-weight: bold;">N.B. Supplément Lunch box: <br />2000,00 DA en T.T.C. par boite.</span>
						</p>
						
						<h3>1- Location de stand</h3>
						<p style="margin-bottom: 5px;">
						<span style="color: #FAFAFA; font-weight: bold;">A- Stand équipé, avec une seule façade <br /> 9900,00 DA T.T.C. par M², comprend:</p></span> 
						<ul>
							<li>01 Espace avec une façade;</li>
							<li>Cloisons de séparation;</li>
							<li>01 Moquette;</li>
							<li>01 Table et 03 Chaises;</li>
							<li>01 Signalétique;</li>
							<li>02 Spots lumineux;</li>
							<li>01 Prise éléctrique;</li>
							<li>01 Corbeille.</li>
						</ul>
						</p>
						<p style="margin-bottom: 5px;">
						<span style="color: #FAFAFA;font-weight: bold;">B- Stand équipé, avec deux façades <br /> 11900,00 DA T.T.C. par M², comprend:</p></span> 
						<ul>
							<li>01 Espace avec deux façades;</li>
							<li>Cloisons de séparation;</li>
							<li>01 Moquette;</li>
							<li>01 Table et 03 Chaises;</li>
							<li>01 Signalétique;</li>
							<li>02 Spots lumineux;</li>
							<li>01 Prise éléctrique;</li>
							<li>01 Corbeille.</li>
						</ul>
						</p>
						<h3>2- Insertion publicitaire<br />sur le Catalogue (Format A5)</h3>
						<p style="margin-bottom: 5px;">
							<span>Je prends commande d’une publicité dans le catalogue officiel du salon au prix de </span>
							<ul>
								<li style="color: #FAFAFA;font-weight: bold;">Insertion sur une 1/2 Page en couleur: 10000,00 DA en T.T.C.</li>
								<li style="color: #FAFAFA;font-weight: bold;">Insertion sur une Page en couleur: 20000,00 DA en T.T.C.</li>
								<li style="color: #FAFAFA;font-weight: bold;">Insertion sur une Double Page en couleur: 40000,00 DA en T.T.C.</li>
							</ul>
						</p>
						<h3>3- Supplément<br />location de mobilier</h3>
						<p style="margin-bottom: 5px;">
							<ul style="color: #FAFAFA;font-weight: bold;">
								<li>01 chaise supplémenaire: <br />1000,00 DA en T.T.C.</li>
								<li>01 table supplémenaire: <br />1500,00 DA en T.T.C.</li>
								<li>01 desk supplémenaire: <br />2000,00 DA en T.T.C.</li>
							</ul>
						</p>
						<hr>
						<h3 id="scrollToPrice">Montant à payer</h3>
						<p style="font-weight: bold;" id="totalPrice"></p>
						<p id="optionPayment">
							Le paiement se fera par virement bancaire au montant total, à l’ordre de:<br /><span style="color: #fff;font-weight: bold;">Maacom<br />
							Banque CPA, agence Transat 371<br />Compte N°: 004003714100021024/80</span>
							<br />Faute de quoi, votre réservation sera annulée au bout des 48 heures qui suivent.<br />
							<br />Cliquez sur le Bouton Envoyez pour confirmer votre inscription
							
						</p>
						
					</div>
					<div class="col-md-7 register-right">
						<h2>Inscription Exposant</h2>
						<div class="register-form">
							<form:form method="POST" action="/confirmExhibitorRegistration" modelAttribute="exhibitor" enctype="multipart/form-data">
								<div class="form-group">
									<span>Pour séléctionner un espace ou des espaces <a href="/plan">Cliquez ici</a></span>
									<form:input id="stands" path="stands" type="text" class="form-control" placeholder="Numéro du stand" readonly="true" /> 
									<form:errors path="stands" class="has-error" />
								</div>
								<div class="form-group">
									<span>Surface</span>
									<form:input path="surface" type="text" class="form-control" placeholder="Surface du stand" readonly="true" /> 
									<form:errors path="surface" class="has-error" />
								</div>
								<div class="form-group">
									<span>Façade</span>
									<form:input path="facade" type="text" class="form-control" id="typeStand" placeholder="Type de stand" readonly="true"/>
								</div>
								<div class="form-group">
									<form:input path="companyName" class="form-control" type="text" placeholder="Nom de l'entreprise" name="companyName"/>
									<form:errors path="companyName" class="has-error"/>
								</div>
								<div class="form-group">
									<form:textarea path="companyActivity" class="form-control" cols="68" rows="5" placeholder="Activité de l'entreprise"></form:textarea>
									<form:errors path="companyActivity" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyResponsable" class="form-control" type="text" placeholder="Résponsable de l'entreprise" name="companyResponsable"/>
									<form:errors path="companyResponsable" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyAddress" class="form-control" type="text" placeholder="Adrésse de l'entreprise" name="companyAddress"/>
									<form:errors path="companyAddress" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyCity" class="form-control" type="text" placeholder="Wilaya" name="companyCity"/>
									<form:errors path="companyCity" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyCountry" class="form-control" type="text" placeholder="Pays" name="companyCountry"/>
									<form:errors path="companyCountry" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyNumber" class="form-control" type="text" placeholder="Téléphone" name="companyNumber"/>
									<form:errors path="companyNumber" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyFax" class="form-control" type="text" placeholder="Fax" name="companyFax"/>
								</div>
								<div class="form-group">
									<form:input path="companyEmail" class="form-control" type="email" placeholder="Email" name="companyEmail"/>
									<form:errors path="companyEmail" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyWebsite" class="form-control" type="text" placeholder="Site internet" name="companyWebsite"/>
								</div>
								<div class="form-group">
									<span>Logo de votre entreprise</span>
									<input class="form-control" type="file" name="logo" required="required"/>
								</div>
								<div class="form-group">
									<span>Supplément Lunch box</span>
									<form:input path="nbrLunchbox" type="number" class="form-control" id="nbrLunchbox" placeholder="Nombre de boite supplémentaire pour le lunchbox" value="0"/>
								</div>
								<div class="form-group">
									<span>Insertion publicitaire sur 1/2 Page en couleur</span>
									<form:input path="nbrMinPage" type="number" class="form-control" id="nbrPubMiniPage" placeholder="Insertion publicitaire sur une 1/2 en couleur" value="0"/>
								</div>
								<div class="form-group">
									<span>Insertion publicitaire sur une Page en couleur</span>
									<form:input path="nbrPubOnePage" type="number" class="form-control" id="nbrPubOnePage" placeholder="Insertion publicitaire sur une Page en couleur" value="0"/>
								</div>
								<div class="form-group">
									<span>Insertion publicitaire sur une Double Page en couleur</span>
									<form:input path="nbrPubDoublePage" type="number" class="form-control" id="nbrPubDoublePage" placeholder="Insertion publicitaire sur une Double Page en couleur" value="0"/>
								</div>
								<div class="form-group">
									<span>Supplément chaises</span>
									<form:input path="nbrChair" type="number" class="form-control" id="nbrChair" placeholder="Nombre de chaises supplémentaires" value="0"/>
								</div>
								<div class="form-group">
									<span>Supplément tables</span>
									<form:input path="nbrTable" type="number" class="form-control" id="nbrTable" placeholder="Nombre de tables supplémentaires" value="0"/>
								</div>
								<div class="form-group">
									<span>Supplément desk</span>
									<form:input path="nbrDesk" type="number" class="form-control" id="nbrDesk" placeholder="Nombre de desk supplémentairs" value="0"/>
								</div>
								<form:input path="montant" type="hidden" id="montant"/>
								<div class="row">
									<span>Calculez le montant total avant d'Envoyer votre réservation</span>
									<div class="col-md-6">
										<div class="form-group">
											<button class="btn btn-primary" id="calcul">Calculer</button>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<input type="submit" id="submit" class="btn btn-danger" value="Envoyer" />
										</div>
									</div>
								</div>
								
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    
</body>

<!-- jquery -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/calcul.js"></script>
</html>