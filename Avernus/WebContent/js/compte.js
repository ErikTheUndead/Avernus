/*
 * AUTEUR : ERIK DUHEM
 * DATE : 06.07.2016
 * VERSION : 1.0
 */

function validationCreation() {
	var val1 = document.getElementById("crea1").value;
	var val2 = document.getElementById("crea2").value;
	var val3 = document.getElementById("crea3").value;
	var val4 = document.getElementById("crea4").value;
	var val5 = document.getElementById("crea5").value;
	var er1 = document.getElementById("errcrea1");
	var er2 = document.getElementById("errcrea2");
	var er3 = document.getElementById("errcrea3");
	var er4 = document.getElementById("errcrea4");
	var er5 = document.getElementById("errcrea5");
	var valid = true;
	if (val1 == "" || val1 <= 0) {
		er1.innerHTML = "  Le num doit être renseigné !";
		er1.style.color = "red";
		valid = false;
	}
	if (val2 == "" || val2 <= 0) {
		er2.innerHTML = "  Le solde doit être renseigné !";
		er2.style.color = "red";
		valid = false;
	}
	if (val3 = "" || val3 <= 0) {
		er3.innerHTML = "  L'idClient doit être renseigné !";
		er3.style.color = "red";
		valid = false;
	}
	if (val4 = "" || val4 <= 0) {
		er4.innerHTML = "  L'idEmploye doit être renseigné !";
		er4.style.color = "red";
		valid = false;
	}
	if (val5 = "" || val5 <= 0) {
		er5.innerHTML = "  L'idBanque doit être renseigné !";
		er5.style.color = "red";
		valid = false;
	}
	return valid;
}

function validationUpdate() {
	var val1 = document.getElementById("upd1").value;
	var er1 = document.getElementById("errupd1");
	var valid = true;
	if (val1 == "0") {
		er1.innerHTML = "Selectionner un IdCompte valide !";
		er1.style.color = "red";
		valid = false;
	}
	return valid;
}

function validationSuppr() {
	var val1 = document.getElementById("suppr1").value;
	var er1 = document.getElementById("errsuppr1");
	var valid = true;
	if (val1 == "0") {
		er1.innerHTML = "Selectionner un IdCompte valide !";
		er1.style.color = "red";
		valid = false;
	}
	return valid;
}

function validationEmployeCompte() {
	var val1 = document.getElementById("ce1").value;
	var er1 = document.getElementById("errce1");
	var valid = true;
	if (val1 == "0") {
		er1.innerHTML = "Selectionner un IdEmployé valide !";
		er1.style.color = "red";
		valid = false;
	}
	return valid;
}