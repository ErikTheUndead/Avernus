 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Employe</title>
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
<!-- <style>

table{
text-align: c;
}
table, th{
	border: 1px solid;
	padding: 10px;
	margin: 10px;

}

</style> -->

<body>
<script type="text/javascript">

function myFunction(){
	var val1=document.getElementById("nom1").value;
	var val2=document.getElementById("nom2").value;
	var er1=document.getElementById("error1");
	var er2=document.getElementById("error2");
	var valid=true;
		if(val1==""){
			er1.innerHTML="  Le nom doit être renseigné !";
			er1.style.color = "red";
			valid=false;
		}if(val2==""){
			er2.innerHTML="  Le code doit être renseigné !";
			er2.style.color = "red";
			valid=false;
		}
		return valid;
}
</script>

<div class="perso">

<h1>Bienvenue sur la page Employé</h1></br></br>

</div></br></br>
<div  >
			<h3>Formulaire d'enregistrement d'un employé :</h3>
		  <form   action="addEmploye" method="post" onsubmit="return myFunction();">
					<label>Nom de l'employé : </label>
					<input type="text" name="nomEmploye" id="nom1"><span id="error1"></span></br></br>
					<label>Code de l'employé : </label>
					<input type="text" name="codeEmploye" id="nom2"><span id="error2"></span></br></br>
					<input class="monBouton" type="submit" value="Enregistrer l'employé">
		  </form>  
		  
</div></br></br>

<div>
		<h4>Vous trouverez ci-dessous la liste des employés, toutes banques confondues :</h4>
		<table>
			<tr>
				<th>Identifiant de l'employé</th>
				<th>Nom de l'employé</th>
				<th>Code de l'employé</th>
			</tr>
			<c:forEach items="${EmployeModel.tabEmploye}" var="cl">
				<tr>
					<td>${cl.idEmploye}</td>
					<td>${cl.nomEmploye}</td>
					<td>${cl.codeEmploye}</td>
				</tr>
			</c:forEach>
		</table>
	</div>  
	
 <%-- <div>
		<form action="delete">
			<select name="idEmploye">
				<c:forEach items="${AttrEmploye}" var="e">
					<option value="${e.idEmploye}">${e.nomEmploye}</option>
				</c:forEach>
			</select> <input type="submit" value="supprimer">
		</form>
	</div>   --%>

</body>
</html>