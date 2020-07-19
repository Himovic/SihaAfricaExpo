<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title Page-->
    <title>Inscription Visiteur</title>
    <!-- Main CSS-->
    <link href="registration/css/main.css" rel="stylesheet" media="all">
    <link href="registration/css/bootstrap.min.css" rel="stylesheet" media="all">
    <link href="registration/css/font-awesome.min.css" rel="stylesheet" media="all">
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset=md-1">
				<div class="row">
					<div class="col-md-5 register-left">
						<h3>Informations Participation</h3>
						<p>Vous trouverez en dessous le bulletin de participation téléchargeable
						et merci de remplir les informations dans le formulaire si vous comptiez y 
						participer.</p>
						<button class="btn btn-primary">Télécharger</button>
					</div>
					<div class="col-md-7 register-right">
						<h2>Inscription Visiteur</h2>
						<div class="register-form">
							<form:form method="POST" action="/confirmVisitorRegistration" modelAttribute="visitor">
								<div class="form-group">
									<form:input path="visitorName" class="form-control" type="text" placeholder="Votre Nom" name="visitorName" required="required"/>
									<form:errors path="visitorName" class="has-error" />
								</div>
								<div class="form-group">
									<form:input path="visitorEmail" class="form-control" type="email" placeholder="Votre Email" name="visitorEmail" required="required"/>
									<form:errors path="visitorEmail" class="has-error" />
								</div>
								<div class="form-group">
									<form:input path="visitorPhone" class="form-control" type="text" placeholder="Votre Numéro de Téléphone" name="visitorPhone" required="required"/>
									<form:errors path="visitorPhone" class="has-error" />
								</div>
								<div class="form-group">
									<form:input path="visitorProfession" class="form-control" type="text" placeholder="Votre Profession" name="visitorProfession" required="required"/>
									<form:errors path="visitorProfession" class="has-error" />
								</div>
								<div class="form-group">
									<form:input path="visitorCompany" class="form-control" type="text" placeholder="La Société ou vous travaillez" name="visitorCompany" required="required"/>
									<form:errors path="visitorCompany" class="has-error" />
								</div>
								<div class="form-group">
									<form:input path="visitorCity" class="form-control" type="text" placeholder="Ville" name="visitorCity" required="required" />
									<form:errors path="visitorCity" class="has-error" />
								</div>
								<div class="form-group">
									<span>Vous étes intéréssé par</span>
									<form:select class="form-control" path="visitorInterest">
										<option value="Exposer">Exposer</option>
										<option value="Visiter">Visiter</option>
										<option value="Assister aux conférences">Assister aux conférences</option>
										<option value="Assister aux rencontres B2B">Assister aux rencontres B2B</option>
									</form:select>
								</div>
								<div class="form-group">
									<form:input path="visitorFacebook" class="form-control" type="text" placeholder="Votre Compte Facebook" name="visitorFacebook"/>
								</div>
								<div class="form-group">
									<form:input path="visitorTwitter" class="form-control" type="text" placeholder="Votre Compte Twitter" name="visitorTwitter"/>
								</div>
								<div class="form-group">
									<form:input path="visitorLinkedin" class="form-control" type="text" placeholder="Votre Compte Linkedin" name="visitorLinkedin"/>
								</div>
								<div class="form-group">
									<form:textarea path="visitorMessage" class="form-control" cols="68" rows="5" placeholder="Votre Méssage"></form:textarea>
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