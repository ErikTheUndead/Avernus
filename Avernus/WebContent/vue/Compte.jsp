<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="vue compte">
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

<script src="<%=request.getContextPath()%>/js/compte.js"></script>

<title>Pages des comptes</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<!-- EN TETE -->
	<header class="intro">

	<div class="intro-body">
		<h1 class="brand-heading">COMPTES</h1>
		<p class="intro-text">Bienvenue sur la page de gestion des
			comptes.</p>

	</div>
	</br>
	</br>
	</header>

	<!--  SECTION LISTE COMPTE-->
	<section id="listecompte" class="container content-section text-center">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2">
			<h3>Liste de tout les comptes</h3>
			<form action="getCompte">
				<button type="submit" class="btn btn-primary">Chercher la
					liste des comptes</button>
			</form>
			<br>
			<table class="table">
				<tr>
					<th>Id</th>
					<th>num</th>
					<th>solde</th>
					<th>type</th>
					<th>Date de création</th>
					<th>idClient</th>
					<th>idEmploye</th>
					<th>idBanque</th>
				</tr>
				<c:forEach items="${AttrCompte}" var="cp">
					<tr>
						<td>${cp.idCompte}</td>
						<td>${cp.numCompte}</td>
						<td>${cp.soldeCompte}</td>
						<td>${cp.type}</td>
						<td>${cp.dateDeCreationCompte}</td>
						<td>${cp.client.idClient}</td>
						<td>${cp.employe.idEmploye}</td>
						<td>${cp.banque.idBanque}</td>
					</tr>
				</c:forEach>
			</table>


		</div>
	</div>
	</section>

	<!--  SECTION CREATION COMPTE-->
	<section id="creationCompte"
		class="container content-section text-center">
	<div class="row">
		<h3>Création de compte</h3>
		<div class="col-lg-8 col-lg-offset-2">

			<form action="creationCompte" method="post"
				onsubmit="return validationCreation();">
				<table class="table">
					<tr>
						<th>Numero de compte</th>
						<th>Solde</th>
						<th>idClient</th>
						<th>idEmploye</th>
						<th>idBanque</th>
					</tr>
					<tr>
						<td><input type="number" name="num" min="1" id="crea1"><span
							id="errcrea1"></span></td>
						<td><input type="text" name="solde" id="crea2"><span
							id="errcrea2"></span></td>
						<td><input type="number" name="idClient" min="1" value="1"
							id="crea3"><span id="errcrea3"></span></td>
						<td><input type="number" name="idEmploye" min="1" value="1"
							id="crea4"><span id="errcrea4"></span></td>
						<td><input type="number" name="idBanque" min="1" value="1"
							id="crea5"><span id="errcrea5"></span></td>
						<c:forEach items="${AttrCompteCreate.listeComptes}" var="ccp">
							<tr>
								<td>${ccp.idCompte}</td>
								<td>${ccp.numCompte}</td>
								<td>${ccp.soldeCompte}</td>
								<td>${ccp.type}</td>
								<td>${ccp.dateDeCreationCompte}</td>
								<td>${ccp.client.idClient}</td>
							</tr>
						</c:forEach>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary">Création</button>
			</form>
		</div>
	</div>
	</section>

	<!-- SECTION UPDATE COMPTE -->
	<section id="updateCompte"
		class="container content-section text-center">
	<div class="row">
		<h3>Update de compte</h3>
		<div class="col-lg-8 col-lg-offset-2">
			<form action="getCompteId" onsubmit="return validationUpdate();">
				<select name="idCompte" id="upd1">
					<option value="0">Choisir un Id</option>
					<c:forEach items="${AttrCompte}" var="ucp">
						<option value="${ucp.idCompte}">${ucp.idCompte}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-primary">OK</button>
				<span id="errupd1"></span>
			</form>
			<table class="table">
				<tr>
					<th>Compte</th>
					<th>Numero de compte</th>
					<th>Solde</th>
					<th>Date de Création</th>
					<th>idClient</th>
				</tr>
				<tr>
					<td>${AttrCompteId.compte.idCompte}</td>
					<td>${AttrCompteId.compte.numCompte}</td>
					<td>${AttrCompteId.compte.soldeCompte}</td>
					<td>${AttrCompteId.compte.dateDeCreationCompte}</td>
					<td>${AttrCompteId.compte.client.idClient}</td>
				</tr>
			</table>
			<form action="updateCompte" method="post">
				<table class="table">
					<tr>
						<th>id</th>
						<th>Numero de compte</th>
						<th>Solde</th>
						<th>idClient</th>
					</tr>
					<tr>
						<td><input type="number" name="idCompte"></td>
						<td><input type="text" name="num"></td>
						<td><input type="text" name="solde"></td>
						<td><input type="number" name="idClient"></td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary">Mis a jour</button>
			</form>
		</div>
	</div>
	</section>

	<!-- SECTION SUPRESSION DE COMPTE -->
	<section id="supprCompte" class="container content-section text-center">
	<div class="row">
		<h3>Supression de compte</h3>
		<div class="col-lg-8 col-lg-offset-2"></div>
	</div>
	</section>
	<div>
		<form action="supprimerCompte" onsubmit="return validationSuppr();">
			<select name="idCompte" id="suppr1">
				<option value="0">Choisir un Id</option>
				<c:forEach items="${AttrCompte}" var="ucp">
					<option value="${ucp.idCompte}">${ucp.idCompte}</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-primary">Supprimer</button>
			<span id="errsuppr1"></span>
		</form>
	</div>

	<!-- SECTION SELECTION DES COMPTES PAR EMPLOYE -->
	<section id="supprCompte" class="container content-section text-center">
	<div class="row">
		<h3>Selection des comptes par employés</h3>
		<div class="col-lg-8 col-lg-offset-2">
			<form action="getEmployeCompte"
				onsubmit="return validationEmployeCompte();">
				<select name="idEmploye" id="ce1">
					<option value="0">Selectionner un employé</option>
					<c:forEach items="${AttrEmploye}" var="ecp">
						<option value="${ecp.idEmploye}">${ecp.nomEmploye}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-primary">Chercher</button>
				<span id="errce1"></span>
			</form>
			<table class="table">
				<tr>
					<th>Compte</th>
					<th>Numero de compte</th>
					<th>Solde</th>
					<th>Date de Création</th>
					<th>idClient</th>
					<th>nom employé</th>
				</tr>
				<c:forEach items="${AttrCompteEmploye.listeComptes}" var="lcp">
					<tr>
						<td>${lcp.idCompte}</td>
						<td>${lcp.numCompte}</td>
						<td>${lcp.soldeCompte}</td>
						<td>${lcp.dateDeCreationCompte}</td>
						<td>${lcp.client.idClient}</td>
						<td>${lcp.employe.nomEmploye}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</section>
	<br>
	<br>

</body>
</html>