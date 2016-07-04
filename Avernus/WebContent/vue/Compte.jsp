<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pages des comptes</title>
</head>
<body>
	<div>
		<form action="getCompte">
			<table>
				<tr>
					<td>Liste des comptes</td>
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
				<th>Date de création</th>
				<th>idClient</th>
				<th>idEmploye</th>
			</tr>
			<c:forEach items="${AttrCompte}" var="cp">
				<tr>
					<td>${cp.idCompte}</td>
					<td>${cp.numCompte}</td>
					<td>${cp.soldeCompte}</td>
					<td>${cp.dateDeCreationCompte}</td>
					<td>${cp.client.idClient}</td>
					<td>${cp.employe.idEmploye}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<h3>Update Compte</h3>
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
			<c:forEach items="${AttrCompteId}" var="ucp">
				<tr>
					<td>${ucp.idCompte}</td>
					<td>${ucp.numCompte}</td>
					<td>${ucp.soldeCompte}</td>
					<td>${ucp.dateDeCreationCompte}</td>
					<td>${ucp.client.idClient}</td>
				</tr>
			</c:forEach>
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
				
					<td><input type="text" name="idCompte"></td>
					<td><input type="text" name="num"></td>
					<td><input type="text" name="solde"></td>
					<td><input type="text" name="idClient"></td>
					<td><input type="submit" value="mis a jour"></td>
				</tr>
			</table>
		</form>
		<%-- <c:catch var="ExceptionPerso"><% Long idCompte = null;%></c:catch>
		<c:if test="${ExceptionPerso != null}">
			<p>
				The exception is : ${catchException} <br /> There is an exception:
				${catchException.message}
			</p>
		</c:if> --%>
	</div>
	<h3>Supression Compte</h3>
</body>
</html>