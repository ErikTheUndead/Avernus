 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>css/ss.css">

 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Employe</title>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- Theme CSS -->
    <link href="../css/grayscale.css" rel="stylesheet">
</head>

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

<div  >
		  <form   action="addEmploye" method="post" onsubmit="return myFunction();">
					<label>nomEmploye : </label>
					<input type="text" name="nomEmploye" id="nom1"><span id="error1"></span></br></br>
					<label>codeEmploye: </label>
					<input type="text" name="codeEmploye" id="nom2"><span id="error2"></span></br></br>
					<input type="submit" value="Enregistrer l'employé">
		  </form>  
		  
</div></br></br>

<div>
		<table>
			<tr>
				<th>idEmploye</th>
				<th>nomEmploye</th>
				<th>codeEmploye</th>
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
	</div>  --%>

</body>
</html>