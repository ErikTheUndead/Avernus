<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
   <!-- Theme CSS -->
    <!-- <link href="../css/grayscale.min.css" rel="stylesheet"> -->
<title>Banque</title>
</head>
<body>


 <div>
		<form action="getBanque">
		<p>Selectionner une banque </p>
			<select name="idBanque">
				<option value="1">BNP</option>
				<option value="2">CIC</option>
				<option value="3">LCL</option>
			</select>
		<input type="submit" value="Consulter les attributs de la banque">
		</form>
	</div> </br></br>
	
	<h3>Les attributs de la banque selectionnée sont les suivants</h3>
	<div>
		<table class="table">
			<tr>
				<th>idBanque</th>
				<!-- <th>nomBanque</th> -->
				<th>adresseBanque</th>
				<th>codePostalBanque</th>
			</tr>
			<c:forEach items="${AttrBanque}" var="cl">
				<tr>
					<td>${cl.idBanque}</td>
					<%-- <td>${cl.nomBanque}</td> --%>
					<td>${cl.adresseBanque}</td>
					<td>${cl.codePostalBanque}</td>
				</tr>
			</c:forEach>
		</table>
	</div>  </br></br>
	
	<h3>Les employés appartenant à la banque selectionnée sont les suivants</h3>
	 <div>
		<table class="table">
			<tr>
				<th>idEmploye</th>
				<th>nomEmploye</th>
				<th>codeEmploye</th>
			</tr>
			<c:forEach items="${AttrEmploye}" var="cl">
				<tr>
					<td>${cl.idEmploye}</td>
					<td>${cl.nomEmploye}</td>
					<td>${cl.codeEmploye}</td>
				</tr>
			</c:forEach>
		</table>
	</div> </br></br>
	
	<h3>Les comptes appartenants à la banque selectionnée sont les suivants</h3>
<div>
		<table class="table1">
			<tr>
				<th>idCompte</th>
				 <th>nomCompte</th> 
				<th>SoldeCompte</th>
				<th>dateDecreationCompte</th>
			</tr>
			<c:forEach items="${AttrCompte}" var="cl">
				<tr>
					<td>${cl.idCompte}</td>
					<td>${cl.numCompte}</td> 
					<td>${cl.soldeCompte}</td>
					<td>${cl.dateDeCreationCompte}</td>
				</tr>
			</c:forEach>
		</table>
	</div> </br></br>
	
	<h3>Les clients appartenant à la banque selectionnée sont les suivants</h3>
	<div>
		<table class="table3">
			<tr>
				<th>idClient</th>
				 <th>nomClient</th> 
				<th>prenomClient</th>
			</tr>
			<c:forEach items="${AttrClient}" var="cl">
				<tr>
					<td>${cl.idClient}</td>
					<td>${cl.nomClient}</td> 
					<td>${cl.prenomClient}</td>
				</tr>
			</c:forEach>
		</table>
	</div> 
	  
</body>
</html>