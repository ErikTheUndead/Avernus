<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employe</title>
</head>
<body>

<div>
		<form action="addEmploye" method="post">
			<table>
				<tr>
					<td>nomEmploye : </td>
					<td><input type="text" name="nomEmploye"></td>
					<td>codeEmploye: </td>
					<td><input type="text" name="codeEmploye"></td>
					<td><input type="submit" value="Enregistrer l'employé"></td>
				</tr>
			</table>
		</form>
	</div>
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
	</div>  
	
	<div>
		<form action="delete">
			<select name="idEmploye">
				<c:forEach items="${AttrEmploye}" var="e">
					<option value="${e.idEmploye}">${e.nomEmploye}</option>
				</c:forEach>
			</select> <input type="submit" value="supprimer">
		</form>
	</div>

</body>
</html>