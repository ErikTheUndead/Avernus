<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Banque</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"> 

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

</head>

<body>

<%-- 
<c:forEach items="${BanqueModel.banques}" var="x">
  <c:out value="${x.idBanque}"></c:out>
</c:forEach> --%>
<!-- <form action="getBanque">
<input type="text" name="idBanque">
<button>Aficher</button>
</form> -->
<%-- ${BanqueModel.idBanque} --%>
<%-- ${BanqueModel.exceptionGetBanueById} --%>

<div class="perso">

<h1>Bienvenue sur la page Banque</h1></br></br>

</div></br></br>

 <div>
		<form action="getBanque">
		<h3>Selectionner une banque </h3>
			<select name="idBanque">
				<option value="1">BNP</option>
				<option value="2">CIC</option>
				<option value="3">LCL</option>
			</select>
		<input class="monBouton" type="submit" value="Consulter les infos de la banque">
		</form>
	</div></br></br>
	
	<h4>Les attributs de la banque selectionnée sont donnés dans le tableau suivant :</h4>
	<div>
		<table class="table1">
			<tr>
				<th>Identifiant de la banque</th>
				<!-- <th>nomBanque</th> -->
				<th>adresseBanque</th>
				<th>co dePostalBanque</th>
			</tr>
			<c:forEach items="${BanqueModel.tabBanque}" var="x">
  				 <tr>
   				<td><c:out value="${x.idBanque}"></c:out></td>
   				<td><c:out value="${x.adresseBanque}"></c:out></td>
   				<td><c:out value="${x.codePostalBanque}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		</div> 
		<h4>Les comptes appartenants à la banque selectionnée sont donnés dans le tableau suivant :</h4>
<div>
		<table class="table2">
			<tr>
				<th>Identifiant du compte</th>
				 <th>Nom du compte</th> 
				<th>Solde du compte</th>
				<th>Date de création du compte</th>
			</tr>
			<c:forEach items="${BanqueModel.tabCompte}" var="cl">
				<tr>
					<td>${cl.idCompte}</td>
					<td>${cl.numCompte}</td> 
					<td>${cl.soldeCompte}</td>
					<td>${cl.dateDeCreationCompte}</td>
				</tr>
			</c:forEach>
		</table>
		<p class="Exception">${BanqueModel.exceptionGetCompteBanque}</p>
	</div> </br></br>
	
	<h4>Les employés appartenant à la banque selectionnée sont donnés dans le tableau suivant :</h4>
	 <div>
		<table class="table3">
			<tr>
				<th>Identifiant de l'employé</th>
				<th>Nom de l'employé</th>
				<th>Code de l'employé</th>
			</tr>
			<c:forEach items="${BanqueModel.tabEmploye}" var="cl">
				<tr>
					<td>${cl.idEmploye}</td>
					<td>${cl.nomEmploye}</td>
					<td>${cl.codeEmploye}</td>
				</tr>
			</c:forEach>
		</table>
		<p class="Exception">${BanqueModel.exceptionGetEmployebanque}</p>
	</div> </br></br> 
	

	
	<h4>Les clients appartenant à la banque selectionnée sont donnés dans le tableau suivant :</h4>
	<div>
		<table class="table4">
			<tr>
				<th>Identifiant du client</th>
				 <th>Nom du client</th> 
				<th>Prénom du client</th>
			</tr>
			<c:forEach items="${BanqueModel.tabClient}" var="cl">
				<tr>
					<td>${cl.idClient}</td>
					<td>${cl.nomClient}</td> 
					<td>${cl.prenomClient}</td>
				</tr>
			</c:forEach>
		</table>
		<p class="Exception">${BanqueModel.exceptionGetClientBanque}</p>
	</div> 
	   
</body>
</html>