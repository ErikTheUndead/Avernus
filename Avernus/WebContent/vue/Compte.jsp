<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="vue de la page compte">
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
</head>
<body>
	<div>
		<form action="getCompte">
			<table>
				<tr>
					<td><h3>Liste des comptes</h3></td>
					<!-- <td><input type="text" name="motCle"></td> -->
					<td><input type="submit" value="ok"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
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

	<h3>Création de compte</h3>

	<div>
		<form action="creationCompte" method="post" onclick="myFunction()">
			<table class="table">
				<tr>
					<th>Numero de compte</th>
					<th>Solde</th>
					<th>idClient</th>
					<th>idEmploye</th>
					<th>idBanque</th>
				</tr>
				<tr>
					<td><input type="number" name="num" min="1" id="nom1"><span id="error1"></td>
					<td><input type="text" name="solde" id="nom2"><span id="error2"></td>
					<td><input type="number" name="idClient" min="1" value="1"></td>
					<td><input type="number" name="idEmploye" min="1" value="1"></td>
					<td><input type="number" name="idBanque" min="1" value="1"></td>
					<td><input type="submit" value="Création"></td>
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
		</form>
	</div>

	<h3>Update compte</h3>

	<div>
		<form action="getCompteId">
			<select name="idCompte">
				<c:forEach items="${AttrCompte}" var="ucp">
					<option value="${ucp.idCompte}">${ucp.idCompte}</option>
				</c:forEach>
			</select> <input type="submit" value="ok">
		</form>
	</div>

	<div>
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
	</div>

	<div>
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
					<td><input type="submit" value="mis a jour"></td>
				</tr>
			</table>
		</form>
	</div>

	<h3>Supression Compte</h3>

	<div>
		<form action="supprimerCompte">
			<select name="idCompte">
				<c:forEach items="${AttrCompte}" var="ucp">
					<option value="${ucp.idCompte}">${ucp.idCompte}</option>
				</c:forEach>
			</select> <input type="submit" value="supprimer">
		</form>
	</div>

	<h3>Liste des comptes par employé</h3>

	<div>
		<form action="getEmployeCompte">
			<select name="idEmploye">
				<c:forEach items="${AttrEmploye}" var="ecp">
					<option value="${ecp.idEmploye}">${ecp.nomEmploye}</option>
				</c:forEach>
			</select> <input type="submit" value="ok">
		</form>
	</div>

	<div>
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


</body>
</html>