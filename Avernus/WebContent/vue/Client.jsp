<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>
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
</head>

<script type="text/javascript">
function myFunction(){
	
	var fieldNumber1 = document.getElementById("cc1").value;	
	var fieldNumber2 = document.getElementById("cc2").value;	
	var fieldNumber3 = document.getElementById("cc3").value;	
	var fieldNumber4 = document.getElementById("cc4").value;	
	var error01 = document.getElementById("error1");
	
	var valid = true;

	if(fieldNumber1.length=="" || fieldNumber2.length=="" || fieldNumber3.length=="" ||fieldNumber4.length=="")
	{
		error01.innerHTML ="il faut remplir tous les champs";
		error01.style.color="red";
		valid=false;
	}
	return valid;
}
function myFunction2(){
	

	var valid = true;
	var fes= document.getElementById("selectSupr").value;
	var error01 = document.getElementById("error3");
	if( fes==0)
	{
		error01.innerHTML ="veuillez selectionner un client";
		error01.style.color="red";
		valid=false;
	}
	return valid;
}
function myFunction3(){
	

	var valid = true;
	var fes= document.getElementById("selectUpdt").value;
	var error01 = document.getElementById("error5");
	if( fes==0)
	{
		error01.innerHTML ="veuillez selectionner un client";
		error01.style.color="red";
		valid=false;
	}
	return valid;
}
</script>
<body>
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
					<li class="hidden"><a href="#page-top"></a></li>
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
		<!-- /.container -->
	</nav>
<header class="intro">

		<div class="intro-body">
		<h1 class="brand-heading">Clients</h1>
						<p class="intro-text">
							Bienvenue sur la page de gestion des clients.
						</p>

</div></br></br>
</header>

<div>
<h4>Recherche des client par mot cle (si vide affiche tous les clients)</h4>
		<form action="getClientsMc">
		
		
					<label>mot cle:</label>
					<input type="text" name="motCle">
					<button class="btn btn-primary" >Chercher les clients</button>
				
			
			
				<p>${ClientModel.exceptionByMc}</p>
		</form>
	</div>
	<div>
		<table class="table">
			<tr>
				<th>Id client</th>
				<th>nom du client</th>
				<th>Prenom du client</th>
				<th>Date de naissance</th>
				<th>adresse</th>
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
	<h4>Remplissez les champs pour ajouter un client</h4>
		<form action="saveClient" method="post" onsubmit="return myFunction();">
		   <table> 
		    <tr>
				<td>Nom Client</td>
				<td><input type="text" name="nom" id="cc1"></td>
			</tr>
			<tr>
				<td>PreNom Client</td>
				<td><input type="text" name="prenom" id="cc2"></td>
			</tr>

			<tr>
				<td>Date de naissance Client</td>
				<td><input type="date" name="dateN" id="cc3" ></td>
			</tr>

			<tr>
				<td>Adresse Client</td>
				<td><input type="text" name="adresseClient" id="cc4"></td>
			</tr>
			
			<tr>
			<td></td>
			<td><button class="btn btn-primary" >Ajouter un client</button></td>
			
			</tr>
		   
		   </table>
		</form>
	</div>
<br>
	<div>
	<h4> Modifier un client deja existant</h4>
	<h5>Selectionner le client a modifié et remplissez uniquement les champs a modifié</h5>
		<form action="selectionner" method="post" onsubmit="return myFunction3();">
		
		<select name="idClient" id="selectUpdt">
				<option value="0">Choisir un Client</option>
				<c:forEach items="${ClientModel.listClient}" var="e">
					<option value="${e.idClient}">${e.nomClient}</option>
				</c:forEach>
			</select> 
			<input type="submit" value="selectionner">
			</br></br>
			<span id="error5"></span>
			</form>
			<form action="updateClient" method="post">
		   <table>
		   <tr>
				<td>Changer id Client</td>
				<td><input type="text" name="idClient" value="${ClientModel.client.idClient}"></td>
			</tr>
		    
				<td>Changer Nom Client</td>
				<td><input type="text" name="nom" value="${ClientModel.client.nomClient}"></td>
			</tr>

			<tr>
				<td>Changer Prenom Client</td>
				<td><input type="text" name="prenom" value="${ClientModel.client.prenomClient}"></td>
			</tr>

			<tr>
				<td>Changer date de naissance Client</td>
				<td><input type="date" name="dateN" value="${ClientModel.client.dateDeNaissance}"></td>
			</tr>

			<tr>
				<td>Changer adresse client</td>
				<td><input type="text" name="adresseClient" value="${ClientModel.client.adresseClient}"></td>
			</tr>
			
		   </table>
		  
				<button class="btn btn-primary" >Modifier un client</button>
		   
		</form>
		</br></br>
	</div>	 
	
	<div>
	<h4>Selectionner un client pour le supprimer</h4>
		<form action="supprimerClient" onsubmit="return myFunction2();">
			<select name="idClient" id="selectSupr">
				<option value="0">Choisir un Client</option>
				<c:forEach items="${ClientModel.listClient}" var="e">
					<option value="${e.idClient}">${e.nomClient}</option>
				</c:forEach>
			</select>  <input type="submit" value="supprimer"><p> </p>
			<span id="error3"></span>
		</form>
	</div>
		<div class="download-section">
		<h5> Nous vous remercions de votre visite</h5>
	
	</div>
</body>
</html>