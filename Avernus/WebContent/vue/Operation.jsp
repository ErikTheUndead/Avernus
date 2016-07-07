<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="vue de la page opération">
<meta name="author" content="Erik DUHEM">

<!-- Bootstrap Core CSS -->
<link
	href="<%=request.getContextPath()%>/ressources/theme1/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/ressources/theme1/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />

<!-- Theme CSS -->
<link
	href="<%=request.getContextPath()%>/ressources/theme1/css/grayscale.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/ressources/theme1/css/grayscale.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/operation.js"></script>

<title>Liste des opérations</title>
</head>
<body>
	<!-- BARRE DE NAVIGATION -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-main-collapse">
				Menu <i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="/Avernus/vue/index.jsp">
				<i class="fa fa-play-circle"></i> <span class="light">GESTION</span>
				BANQUE
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div
			class="collapse navbar-collapse navbar-right navbar-main-collapse">
			<ul class="nav navbar-nav">
				<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
				<li class="hidden"><a href="/Avernus/vue/index.jsp"></a></li>
				<li><a class="page-scroll" href="/Avernus/indexClient">Clients</a></li>
				<li><a class="page-scroll" href="/Avernus/compte">Comptes</a></li>
				<li><a class="page-scroll" href="/Avernus/operation">Opérations</a></li>
				<li><a class="page-scroll" href="/Avernus/indexEmploye">Employés</a></li>
				<li><a class="page-scroll" href="/Avernus/indexGroupe">Groupes</a></li>
				<li><a class="page-scroll" href="/Avernus/indexBanque">Banques</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- EN TETE -->
	<header class="intro">

	<div class="intro-body">
		<h1 class="brand-heading">OPERATIONS</h1>
		<p class="intro-text">Bienvenue sur la page de gestion des
			opérations.</p>

	</div>
	</header>

	<!-- SECTION  LISTE DES OPERATIONS-->
	<section id="listeOperations"
		class="container content-section text-center">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2">
			<h3>Liste de toutes les opérations</h3>
			<form action="getOperation">
				<button type="submit" class="btn btn-primary">CHERCHER LA
					LISTE DES OPERATIONS</button>
			</form>
			<p style="color:green;">${OperationModel.messageOperation}</p>
			</br>
			<table class="table">
				<tr>
					<th>Date Opération</th>
					<th>Id Opération</th>
					<th>Type Opération</th>
					<th>montant</th>
					<th>Compte</th>
					<th>Employe</th>
					<th>Id Banque</th>
				</tr>
				<c:forEach items="${AttrOperation}" var="op">
					<tr>
						<td>${op.dateOperation}</td>
						<td>${op.idOperation}</td>
						<td>${op.type}</td>
						<td>${op.montantOperation}</td>
						<td>${op.compte.numCompte}</td>
						<td>${op.employe.nomEmploye}</td>
						<td>${op.compte.banque.idBanque}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</section>

	<!-- SECTION OPERATIONS RETRAIT-->
	<section id="operationRetrait"
		class="container content-section text-center">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2">
			<h3>EFFECTUER UN RETRAIT</h3>
			<form action="operationRetrait" method="post"
				onsubmit="return validationRetrait();">
				<table class="table">
					<tr>
						<th>idCompte</th>
						<th>idEmploye</th>
						<th>montant</th>
					</tr>
					<tr>
						<td><input type="number" name="idCompte1" min="1"
							id="retrait1"></br> <span id="errRetrait1"></span></td>
						<td><input type="number" name="idEmploye" min="1" value="1"></td>
						<td><input type="text" name="montant" id="retrait2"></br>
							<span id="errRetrait2"></span></td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary">Retrait</button>
			</form>
			<p class="Exception">${OperationModelRetrait.exceptionRetrait}</p>
			</br>
			<table class="table">
				<tr>
					<th>Type</th>
					<th>Id Operation</th>
					<th>Id Compte</th>
					<th>Montant Opération</th>
					<th>Date Opération</th>
				</tr>
				<tr>
					<td>${AttrOperationRetrait.operation.type}</td>
					<td>${AttrOperationRetrait.operation.idOperation}</td>
					<td>${AttrOperationRetrait.operation.compte.idCompte}</td>
					<td>${AttrOperationRetrait.operation.montantOperation}</td>
					<td>${AttrOperationRetrait.operation.dateOperation}</td>
				</tr>
			</table>
		</div>
	</div>
	</section>

	<!-- SECTION OPERATIONS VERSEMENT-->
	<section id="operationVersement"
		class="container content-section text-center">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2">
			<h3>EFFECTUER UN VERSEMENT</h3>
			<form action="operationVersement" method="post"
				onsubmit="return validationVersement();">
				<table class="table">
					<tr>
						<th>idCompte</th>
						<th>idEmploye</th>
						<th>montant</th>
					</tr>
					<tr>
						<td><input type="number" name="idCompte1" min="1" id="ver1"></br>
							<span id="errver1"></span></td>
						<td><input type="number" name="idEmploye" min="1" value="1"></td>
						<td><input type="text" name="montant" id="ver2"></br> <span
							id="errver2"></span></td>
					</tr>
				</table>
				<td><button type="submit" class="btn btn-primary">Versement</button></td>
			</form>
			<p class="Exception">${OperationModelVersement.exceptionVersement}</p>
			</br>
			<table class="table">
				<tr>
					<th>Type</th>
					<th>Id Operation</th>
					<th>Id Compte</th>
					<th>Montant Opération</th>
					<th>Date Opération</th>
				</tr>
				<tr>
					<td>${AttrOperationVersement.operation.type}</td>
					<td>${AttrOperationVersement.operation.idOperation}</td>
					<td>${AttrOperationVersement.operation.compte.idCompte}</td>
					<td>${AttrOperationVersement.operation.montantOperation}</td>
					<td>${AttrOperationVersement.operation.dateOperation}</td>
				</tr>
			</table>
		</div>
	</div>
	</section>

	<!-- SECTION OPERATIONS VIREMENT-->
	<section id="operationVirement"
		class="container content-section text-center">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2">
			<h3>EFFECTUER UN VIREMENT</h3>
			<form action="operationVirement" method="post"
				onsubmit="return validationVirement();">
				<table class="table">
					<tr>
						<th>idCompte 1</th>
						<th>idCompte 2</th>
						<th>idEmploye</th>
						<th>montant</th>
					</tr>
					<tr>
						<td><input type="number" name="idCompte1" min="1" id="vir1"></br>
							<span id="errvir1"></span></td>
						<td><input type="number" name="idCompte2" min="1" id="vir2"></br>
							<span id="errvir2"></span></td>
						<td><input type="number" name="idEmploye" min="1" value="1"></td>
						<td><input type="text" name="montant" id="vir3"></br> <span
							id="errvir3"></span></td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary">Virement</button>
			</form>
			<p class="Exception">${OperationModelRetrait.exceptionVirement}</p>
			</br>
			<table class="table">
				<tr>
					<th>Type</th>
					<th>Id Operation</th>
					<th>Id Compte</th>
					<th>Montant Opération</th>
					<th>Date Opération</th>
				</tr>
				<c:forEach items="${AttrOperationVirement.listeOperations}"
					var="vir">
					<tr>
						<td>${vir.type}</td>
						<td>${vir.idOperation}</td>
						<td>${vir.compte.idCompte}</td>
						<td>${vir.montantOperation}</td>
						<td>${vir.dateOperation}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</section>
	</br>
	</br>

	<!-- FIN DE PAGE -->
	<section class="download-section">
	<h5>Nous vous remercions de votre visite</h5>
	</section>
	

</body>
</html>