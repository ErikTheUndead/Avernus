<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Banque</title>

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

<body>
<script type="text/javascript">

function mafonction(){
	var val1=document.getElementById("variable").value;
	var er1=document.getElementById("error1");
	var valid=true;
		if(val1==0){
			er1.innerHTML="  Vous n'avez pas selectionné de banque !";
			valid=false;
		}
	return valid;
}
</script>
<%-- 
<c:forEach items="${BanqueModel.banques}" var="x">
  <c:out value="${x.idBanque}"></c:out>
</c:forEach> --%>
<!-- <form action="getBanque">
<input type="text" name="idBanque">
<button>Aficher</button>
</form> -->
<%-- ${BanqueModel.idBanque} --%>
<%-- ${BanqueModel.exceptionGetBanueById} --%>
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
		<!-- /.container -->
	</nav>
<header class="intro">

		<div class="intro-body">
		<h1 class="brand-heading">Banque</h1>
						<p class="intro-text">
							Bienvenue sur la page de gestion des banques.
						</p>

</div></br></br>

</header>

 <div>
		<form action="getBanque"  onsubmit="return mafonction();">
		<h3>Selectionner une banque </h3>
			<select name="idBanque" id="variable">
				<option value="0">Selectionner</option>
				<option value="1">BNP</option>
				<option value="2">CIC</option>
				<option value="3">LCL</option>
			</select>  &nbsp; &nbsp; &nbsp;
		<button class="btn btn-primary" >Consulter les infos de la banque</button><p> </p>
		<span class="Exception" id="error1"></span>
		</form>
</div><br/><br/>

<c:if test="${not empty BanqueModel.tabBanque}">
	<h4>Les attributs de la banque selectionnée sont donnés dans le tableau suivant :</h4>
	<div>
		<table class="table1">
			<tr>
				<th>Identifiant de la banque</th>
				<!-- <th>nomBanque</th> -->
				<th>Adresse de la banque</th>
				<th>Code postal de la banque</th>
			</tr>
			<c:forEach items="${BanqueModel.tabBanque}" var="x">
  				 <tr>
   				<td><c:out value="${x.idBanque}"></c:out></td>
   				<td><c:out value="${x.adresseBanque}"></c:out></td>
   				<td><c:out value="${x.codePostalBanque}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		</div > 
		</c:if>
		
		<div >
		<c:if test="${not empty BanqueModel.tabCompte}">
		<h4>Les comptes appartenants à la banque selectionnée sont donnés dans le tableau suivant :</h4>

		<table class="table2">
			<tr>
				<th>Identifiant du compte</th>
				 <th>Nom du compte</th> 
				<th>Solde du compte</th>
				<th>Date de création du compte</th>
			</tr>
			<c:forEach items="${BanqueModel.tabCompte}" var="cl">
				<tr>
					<td>${cl.idCompte}</td>
					<td>${cl.numCompte}</td> 
					<td>${cl.soldeCompte}</td>
					<td>${cl.dateDeCreationCompte}</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<p class="Exception">${BanqueModel.exceptionGetCompteBanque}</p>
		
	</div> <br/><br/>
	
	 <div>
	 <c:if test="${not empty BanqueModel.tabEmploye}">
	<h4>Les employés appartenant à la banque selectionnée sont donnés dans le tableau suivant :</h4>
	
		<table class="table3">
			<tr>
				<th>Identifiant de l'employé</th>
				<th>Nom de l'employé</th>
				<th>Code de l'employé</th>
			</tr>
			<c:forEach items="${BanqueModel.tabEmploye}" var="cl">
				<tr>
					<td>${cl.idEmploye}</td>
					<td>${cl.nomEmploye}</td>
					<td>${cl.codeEmploye}</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<p class="Exception">${BanqueModel.exceptionGetEmployebanque}</p>
	</div> <br/><br/>
	
<div>
	 <c:if test="${not empty BanqueModel.tabClient}">
	<h4>Les clients appartenant à la banque selectionnée sont donnés dans le tableau suivant :</h4>
	
		<table class="table4">
			<tr>
				<th>Identifiant du client</th>
				 <th>Nom du client</th> 
				<th>Prénom du client</th>
			</tr>
			<c:forEach items="${BanqueModel.tabClient}" var="cl">
				<tr>
					<td>${cl.idClient}</td>
					<td>${cl.nomClient}</td> 
					<td>${cl.prenomClient}</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<p class="Exception">${BanqueModel.exceptionGetClientBanque}</p>
	</div> 
	
	<div class="download-section">
		<h5> Nous vous remercions de votre visite</h5>
	
	</div>
	   
</body>
</html>