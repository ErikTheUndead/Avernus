<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des opérations</title>
</head>
<body>
	<div>
		<form action="getOperation">
			<table>
				<tr>
					<td><h3>Liste des opérations</h3></td>
					<!-- <td><input type="text" name="motCle"></td> -->
					<td><input type="submit" value="ok"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
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

	<h3>Retrait</h3>

	<div>
		<form action="operationRetrait" method="post">
			<table class="table">
				<tr>
					<th>idCompte</th>
					<th>idEmploye</th>
					<th>montant</th>
				</tr>
				<tr>
					<td><input type="number" name="idCompte1" min="1"></td>
					<td><input type="number" name="idEmploye" min="1" value="1"></td>
					<td><input type="text" name="montant"></td>
					<td><input type="submit" value="Retrait"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
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

	<h3>Versement</h3>

	<div>
		<form action="operationVersement" method="post">
			<table class="table">
				<tr>
					<th>idCompte</th>
					<th>idEmploye</th>
					<th>montant</th>
				</tr>
				<tr>

					<td><input type="number" name="idCompte1" min="1"></td>
					<td><input type="number" name="idEmploye" min="1" value="1"></td>
					<td><input type="text" name="montant"></td>
					<td><input type="submit" value="Versement"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
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

	<h3>Virement</h3>

	<div>
		<form action="operationVirement" method="post">
			<table class="table">
				<tr>
					<th>idCompte 1</th>
					<th>idCompte 2</th>
					<th>idEmploye</th>
					<th>montant</th>
				</tr>
				<tr>

					<td><input type="number" name="idCompte1" min="1"></td>
					<td><input type="number" name="idCompte2" min="1"></td>
					<td><input type="number" name="idEmploye" min="1" value="1"></td>
					<td><input type="text" name="montant"></td>
					<td><input type="submit" value="Virement"></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<table class="table">
			<tr>
				<th>Type</th>
				<th>Id Operation</th>
				<th>Id Compte</th>
				<th>Montant Opération</th>
				<th>Date Opération</th>
			</tr>
			<c:forEach items="${AttrOperationVirement.listeOperations}" var="vir">
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

</body>
</html>