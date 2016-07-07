<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Grayscale - Start Bootstrap Theme</title>

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

<%-- <link href="<c:url value="${pageContext.request.contextPath}/ressources/theme1/css/grayscale.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="${pageContext.request.contextPath}/ressources/theme1/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<script
	src="<c:url value="${pageContext.request.contextPath}/ressources/theme1/vendor/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="${pageContext.request.contextPath}/ressources/theme1/js/main.js" />"></script> --%>




<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<!-- Navigation -->
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

	<!-- Intro Header -->
	<header class="intro">
		<div class="intro-body">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<h1 class="brand-heading">Avernus</h1>
						<p class="intro-text">
							Le site de gestion des banques BNP, LCL et CIC. <br>Created by
							groupe 3.
						</p>
						<a href="#about" class="btn btn-circle page-scroll"> <i
							class="fa fa-angle-double-down animated"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- About Section -->
	<section id="about" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>About Avernus</h2>
				<p>
					Avernus est un site de gestion de banques, clients, comptes, employés, groupes et opérations 
				</p>
				
			</div>
		</div>
	</section>

	<!-- Download Section -->
	<section id="download" class="content-section text-center">
		<div class="download-section">
			<div class="container">
				<div class="col-lg-8 col-lg-offset-2">
					<h2>Auteurs</h2>
					<p>BERNARD Thomas - DUHEM Eric - BROUQUE Julie.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Map Section -->
	<div id="map"></div>

	<!-- Footer -->
	<footer>
		<div class="container text-center">
			<p>Copyright &copy; Your Website 2016</p>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="vendor/jquery/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

	<!-- Theme JavaScript -->
	<script src="js/grayscale.min.js"></script>

</body>

</html>
