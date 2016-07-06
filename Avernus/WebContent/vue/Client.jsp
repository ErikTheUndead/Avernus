 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script src="<%=request.getContextPath()%>/js/client.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
myFunction(){
	
	var fieldNumber1 = document.getElementById("c1").value;	
	var fieldNumber2 = document.getElementById("c2").value;	
	var fieldNumber3 = document.getElementById("c3").value;	
	var fieldNumber4 = document.getElementById("c4").value;	
	var error01 = document.getElementById("error1");
	
	var valid = true;

	if(fieldNumber1.length==0 || fieldNumber2.length==0 || fieldNumber3.length==0 ||fieldNumber4.length==0)
	{
		error01.innerHTML ="il faut remplir tous les champs";
		error01.style.color="red"
		valid=false;
	}
	return valid;
}

</script>
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
				<p>${ClientModel.exceptionByMc}</p>
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
			<c:forEach items="${ClientModel.listClientByMc}" var="cl">
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
				<c:forEach items="${ClientModel.listClient}" var="e">
					<option value="${e.idClient}">${e.nomClient}</option>
				</c:forEach>
			</select> <input type="submit" value="supprimer">
		</form>
	</div>
	<div>
		<form action="saveClient" method="post" onsubmit="return myFunction();">
		   <table> 
		    <tr>
				<td>Nom Client</td>
				<td><input type="text" name="nom" id="c1"></td>
			</tr>
			<tr>
				<td>PreNom Client</td>
				<td><input type="text" name="prenom" id="c2"></td>
			</tr>

			<tr>
				<td>Date de naissance Client</td>
				<td><input type="date" name="dateN" id="c3" ></td>
			</tr>

			<tr>
				<td>Adresse Client</td>
				<td><input type="text" name="adresseClient" id="c4"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="saveClient" /> <span id="error1"></span></td>
			</tr>
		   
		   </table>
		</form>
	</div>

	<div>
		<form action="updateClient" method="post">
		
		<select name="idClient">
				<c:forEach items="${ClientModel.listClient}" var="e">
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