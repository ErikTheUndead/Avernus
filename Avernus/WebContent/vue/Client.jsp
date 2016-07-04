<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div>
		<form action="getClientsMc">
			<table>
				<tr>
					<td>mot cle:</td>
					<td><input type="text" name="motCle"></td>
					<td><input type="submit" value="envoyer"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>nomClient</th>
				<th>PrenomClient</th>
				<th>AgeClient</th>
			</tr>
			<c:forEach items="${AttrClient}" var="cl">
				<tr>
					<td>${cl.idClient}</td>
					<td>${cl.nomClient}</td>
					<td>${cl.prenomClient}</td>
					<td>${cl.dateDeNaissance}</td>
					<td>${cl.adresseClient}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<form action="supprimerClient">
			<select name="idClient">
				<c:forEach items="${AttrClient}" var="e">
					<option value="${e.idClient}">${e.nomClient}</option>
				</c:forEach>
			</select> <input type="submit" value="supprimer">
		</form>
	</div>
	<div>
		<form action="saveClient" method="post">
		   <table> 
		    <tr>
				<td>Nom Client</td>
				<td><input type="text" name="nom"></td>
			</tr>
			<tr>
				<td>PreNom Client</td>
				<td><input type="text" name="prenom"></td>
			</tr>

			<tr>
				<td>Date de naissance Client</td>
				<td><input type="date" name="dateN" ></td>
			</tr>

			<tr>
				<td>Adresse Client</td>
				<td><input type="text" name="adresseClient" ></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="saveClient" /></td>
			</tr>
		   
		   </table>
		</form>
	</div>

	<div>
		<form action="updateClient" method="post">
		
		<select name="idClient">
				<c:forEach items="${AttrClient}" var="e">
					<option value="${e.idClient}">${e.nomClient}</option>
				</c:forEach>
			</select> 
			
		   <table>
		   
		    <tr>
				<td>Changer Nom Client</td>
				<td><input type="text" name="nom"></td>
			</tr>

			<tr>
				<td>Changer PreNom Client</td>
				<td><input type="text" name="prenom"></td>
			</tr>

			<tr>
				<td>Change date de naissance Client</td>
				<td><input type="date" name="dateN" ></td>
			</tr>

			<tr>
				<td>Changer adresse client</td>
				<td><input type="text" name="adresseClient" ></td>
			</tr>

			<tr>
				<td><input type="submit" value="updateClient" /></td>
			</tr>
		   
		   </table>
		</form>
	</div>	

</body>
</html>