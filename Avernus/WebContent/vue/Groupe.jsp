<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">  
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

<title>Groupes</title>
</head>
<body>

	<script type="text/javascript">
		function myFunction() {

			var fieldNumber1 = document.getElementById("ccc1").value;

			var error01 = document.getElementById("error2");

			var valid = true;

			if (fieldNumber1.length == "") {
				error01.innerHTML = "il faut remplir le nom du groupe";
				error01.style.color = "red";
				valid = false;
			}
			return valid;
		}
		function myFunction2() {

			var valid = true;
			var fes = document.getElementById("select1").value;
			var error01 = document.getElementById("error1");
			if (fes == 0) {
				error01.innerHTML = "veuillez selectionner un groupe";
				error01.style.color = "red";
				valid = false;
			}
			return valid;
		}
		function myFunction3() {

			var valid = true;
			var fes2 = document.getElementById("select3").value;
			var fes1 = document.getElementById("select2").value;

			var error01 = document.getElementById("error2");
			if (fes1 == 0 || fes2 == 0) {
				error01.innerHTML = "veuillez tout selectionner";
				error01.style.color = "red";
				valid = false;
			}
			return valid;
		}
	</script>

	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-main-collapse">
				Menu <i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="/Avernus/vue/index.jsp"> <i
				class="fa fa-play-circle"></i> <span class="light">GESTION</span>
				BANQUE
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div
			class="collapse navbar-collapse navbar-right navbar-main-collapse">
			<ul class="nav navbar-nav">
				<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
				<li class="hidden"><a href="/Avernus/vue/index.jsp"></a></li>
				<li><a class="page-scroll" href="/Avernus/indexClient">Clients</a></li>
				<li><a class="page-scroll" href="/Avernus/compte">Comptes</a></li>
				<li><a class="page-scroll" href="/Avernus/operation">Opérations</a></li>
				<li><a class="page-scroll" href="/Avernus/indexEmploye">Employés</a></li>
				<li><a class="page-scroll" href="/Avernus/indexGroupe">Groupes</a></li>
				<li><a class="page-scroll" href="/Avernus/indexBanque">Banques</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<header class="intro">
	<div class="intro-body">

		<h1 class="brand-heading">Groupes</h1>
		</br>
		</br>
		<p class="intro-text">Bienvenue sur la page de gestion des
			groupes.</p>
	</div>
	</br>
	</br>

	</header>
	<h4>Le tableau ci-dessous affiche l'ensemble des groupes existants :</h4>
	<div>
		<table >
			<tr>
				<th>Identifiant du groupe</th>
				<th>Nom du groupe</th>
			</tr>
			<c:forEach items="${GroupeModel.listGroupe}" var="cl">
				<tr>
					<td>${cl.idGroupe}</td>
					<td>${cl.nomGroupe}</td>
				</tr>
			</c:forEach>
		</table>
	</div></br></br>
	<h4>Formulaire d'affichage d'un groupe donné et de ses membres :</h4>
	<div>
		<form action="getEmploye" method="post"
			onsubmit="return myFunction2();">
			<select name="idGroupe" id="select1">
				<option value="0">Choisir un groupe</option>
				<c:forEach items="${GroupeModel.listGroupe}" var="e">
					<option value="${e.idGroupe}">${e.nomGroupe}</option>
				</c:forEach>
			</select> <input type="submit" value="afficher"> <span id="error1"></span>
		</form>
	</div><br/><br/>
	
	<div>
	<c:if test="${not empty GroupeModel.listEmployeG}">
		<table >
			<tr>
				<th>Identifiant de l'employé</th>
				<th>Nom de l'employé</th>
				<th>Code de l'employé</th>

			</tr>
			<c:forEach items="${GroupeModel.listEmployeG}" var="em">
				<tr>
					<td>${em.idEmploye}</td>
					<td>${em.nomEmploye}</td>
					<td>${em.codeEmploye}</td>

				</tr>
			</c:forEach>
			
		</table>
		</c:if>
		<p class="Exception">${GroupeModel.exceptionGetGroupe}</p>
	</div>
	
	<br><br>
	
	<h4>Formulaire d'ajout d'un employé à un groupe :</h4>
	<div>
		<form action="addEmployeGroupe" method="post"
			onsubmit="return myFunction3();">
			<select name="idEmploye" id="select2">
				<option value="0">Choisir un Employe</option>
				<c:forEach items="${GroupeModel.listEmploye}" var="f">
					<option value="${f.idEmploye}">${f.nomEmploye}</option>
				</c:forEach>
			</select> <select name="idGroupe" id="select3">
				<option value="0">Choisir un groupe</option>
				<c:forEach items="${GroupeModel.listGroupe}" var="d">
					<option value="${d.idGroupe}">${d.nomGroupe}</option>
				</c:forEach>
			</select> <input type="submit" value="Ajouter"><span id="error2"></span>

		</form>
	</div></br></br>
	<h4>Formulaire d'enregistrement d'un nouveau groupe :</h4>
	<div>
		<form action="addGroupe" method="post" onsubmit="return myFunction();">

			<label>Nom Groupe</label> <input type="text" name="nomGroupe"
				id="ccc1"> <span id="error2"> <input type="submit"
				value="saveGroupe" />
		</form>

	</div></br></br>
	
	<div class="download-section">
		<h5> Nous vous remercions de votre visite</h5>
	
	</div>
</body>
</html>