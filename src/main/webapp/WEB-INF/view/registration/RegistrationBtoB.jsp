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
	<link href="/index/images/favicon.png" rel="icon">
    <!-- Title Page-->
    <title>Inscription B2B</title>
    <!-- Main CSS-->
    <link href="registration/css/main.css" rel="stylesheet" media="all">
    <link href="registration/css/bootstrap.min.css" rel="stylesheet" media="all">
    <link href="registration/css/font-awesome.min.css" rel="stylesheet" media="all">
</head>
<body>
<img src="/index/images/banner.png" class="banner" />
	<div class="container">
		<c:set var="error" value="${error}" />
		<c:set var="bTobSaveSuccess" value="${bTobSaveSuccess}" />
		<c:set var="errorDownloadLogo" value="${errorDownloadLogo}" />
		<c:if test = "${error=='error'}">
			<div class="alert alert-danger" role="alert">
  				Vous devez tout les champs obligatoire du formulaire.
			</div>
		</c:if>
		<c:if test = "${errorDownloadLogo=='errorDownloadLogo'}">
			<div class="alert alert-danger" role="alert">
  				Une érreure est apparue lors du téléchargement de votre Logo. Refaire a nouveau.
			</div>
		</c:if>
		<br />
        <c:if test = "${bTobSaveSuccess=='bTobSaveSuccess'}">
			<div class="alert alert-primary" role="alert">
  				L'enregistrement a été éffectuer avec succées.
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-10 offset=md-1">
				<div class="row">
					<div class="col-md-5 register-left">
						<h3>Inscription aux rencontres B2B</h3>
						<p><span style="font-weight: bold;color: #1f1039">Samedi 28 mars 2020 <br /></span>En vous inscrivant aux rencontres B2B, vous aurez votre table avec une
						pancarte portant le nom de votre société et votre logo, pour recevoir des 
						vis-à-vis professionels et faire du networking.<br />
						Une collation vous sera offerte lors de ces rencontres.<br />
						<span style="font-weight: bold;color: #1f1039">Tarif : 10000,00 DZD en T.T.C.</span></p>
						<p>
							Le paiement se fera par virement bancaire au montant total, à l’ordre de:<br /><span style="color: #1f1039;font-weight: bold;">Club des Opérateuers du Tourisme – Constantine<br />
							Banque CPA, agence Transat 371<br />Compte N°: 004003714100021024/80</span>
							<br />Faute de quoi, votre réservation de votre table pour le B2B 
							sera annulée au bout des 48 heures qui suivent.<br />
							<br />Cliquez sur le Bouton Envoyez pour confirmer votre inscription
						</p>
						<!-- <button class="btn btn-primary">Télécharger</button> -->
					</div>
					<div class="col-md-7 register-right">
						<h2>Inscription aux rencontres B2B</h2>
						<div class="register-form">
							<form:form method="POST" action="/confirmBtoBRegistration" modelAttribute="btob" enctype="multipart/form-data">
								<div class="form-group">
									<form:input path="companyName" class="form-control" type="text" placeholder="Nom de l'entreprise" name="companyName"/>
									<form:errors path="companyName" class="has-error"/>
								</div>
								<div class="form-group">
									<form:textarea path="companyActivity" class="form-control" cols="68" rows="5" placeholder="Activité de l'entreprise"></form:textarea>
									<form:errors path="companyActivity" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyResponsable" class="form-control" type="text" placeholder="Représentant de l'entreprise dans les B2B" name="companyResponsable"/>
									<form:errors path="companyResponsable" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyEmail" class="form-control" type="email" placeholder="Email de l'entreprise" name="companyEmail"/>
									<form:errors path="companyEmail" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyAddress" class="form-control" type="text" placeholder="Adrésse de l'entreprise" name="companyAddress"/>
									<form:errors path="companyAddress" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyCountry" class="form-control" type="text" placeholder="Pays" name="companyCountry"/>
									<form:errors path="companyCountry" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyNumber" class="form-control" type="text" placeholder="Numéro de Téléphone" name="companyNumber"/>
									<form:errors path="companyNumber" class="has-error"/>
								</div>
								<div class="form-group">
									<form:input path="companyFax" class="form-control" type="text" placeholder="Fax" name="companyFax"/>
								</div>
								<div class="form-group">
									<form:input path="companyWebsite" class="form-control" type="text" placeholder="Siteweb de l'entreprise" name="companyWebsite"/>
								</div>
								<div class="form-group">
									<span>Logo</span>
									<input class="form-control" type="file" name="logo" required="required"/>
								</div>
								<div class="form-group">
									<form:input path="companyFacebook" class="form-control" type="text" placeholder="Compte Facebook" name="companyFacebook"/>
								</div>
								<div class="form-group">
									<form:input path="companyInstagram" class="form-control" type="text" placeholder="Compte Instagram" name="companyInstagram"/>
								</div>
								<div class="form-group">
									<form:input path="companyLinkedin" class="form-control" type="text" placeholder="Compte Linkedin" name="companyLinkedin"/>
								</div>
								<div class="form-group">
									<form:input path="companyTwitter" class="form-control" type="text" placeholder="Compte Twitter" name="companyTwitter"/>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-primary" value="Envoyer" />
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    
</body>
</html>