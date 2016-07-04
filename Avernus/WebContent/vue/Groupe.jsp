<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<table class="table">
			<tr>
				<th>IdGroupe</th>
				<th>nomGroupe</th>
			</tr>
			<c:forEach items="${AttrGroupe}" var="cl">
				<tr>
					<td>${cl.idGroupe}</td>
					<td>${cl.nomGroupe}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		<div>
		<form action="getEmploye" method="post">
			<select name="idGroupe">
				<c:forEach items="${AttrGroupe}" var="e">
					<option value="${e.idGroupe}">${e.nomGroupe}</option>
				</c:forEach>
			</select> <input type="submit" value="afficher">
		</form>
	</div>
	<div>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>nom Employet</th>
				<th>Code</th>
				
			</tr>
			<c:forEach items="${AttrEmployeG}" var="em">
				<tr>
					<td>${em.idEmploye}</td>
					<td>${em.nomEmploye}</td>
					<td>${em.codeEmploye}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
	<form action="addEmployeGroupe" method="post">
	<select name="idEmploye">
				<c:forEach items="${AttrEmploye}" var="f">
					<option value="${f.idEmploye}">${f.nomEmploye}</option>
				</c:forEach>
			</select> 
			<select name="idGroupe">
				<c:forEach items="${AttrGroupe}" var="d">
					<option value="${d.idGroupe}">${d.nomGroupe}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Ajouter">
	
	</form>
	</div>
	<div>
	<form action = "addGroupe" method="post">
	  <table> 
		    <tr>
				<td>Nom Groupe</td>
				<td><input type="text" name="nomGroupe"></td>
			</tr>
				<tr>
				<td><input type="submit" value="saveGroupe" /></td>
			</tr>
	</table>
	
	</form>
	
	</div>
</body>
</html>