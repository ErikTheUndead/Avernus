function validationRetrait() {
	var val1 = document.getElementById("retrait1").value;
	var val2 = document.getElementById("retrait2").value;
	var er1 = document.getElementById("errRetrait1");
	var er2 = document.getElementById("errRetrait2");
	var valid = true;
	if (val1 == "") {
		er1.innerHTML = "L'IdCompte doit etre correctement renseigné";
		er1.style.color = "red";
		valid = false;
	}
	if (val2 == "" || val2 < 20) {
		er2.innerHTML = "Le retrait doit etre correctement renseigné ! (min 20)";
		er2.style.color = "red";
		valid = false;
	}
	return valid;
}

function validationVersement() {
	var val1 = document.getElementById("ver1").value;
	var val2 = document.getElementById("ver2").value;
	var er1 = document.getElementById("errver1");
	var er2 = document.getElementById("errver2");
	var valid = true;
	if (val1 == "") {
		er1.innerHTML = "L'IdCompte doit etre correctement renseigné";
		er1.style.color = "red";
		valid = false;
	}
	if (val2 == "" || val2 < 10) {
		er2.innerHTML = "Le montant doit etre correctement renseigné ! (min 20)";
		er2.style.color = "red";
		valid = false;
	}
	return valid;
}

function validationVirement() {
	var val1 = document.getElementById("vir1").value;
	var val2 = document.getElementById("vir2").value;
	var val3 = document.getElementById("vir3").value;
	var er1 = document.getElementById("errvir1");
	var er2 = document.getElementById("errvir2");
	var er3 = document.getElementById("errvir3");
	var valid = true;
	if (val1 == "") {
		er1.innerHTML = "L'IdCompte 1 doit etre correctement renseigné";
		er1.style.color = "red";
		valid = false;
	}
	if (val2 == "") {
		er2.innerHTML = "L'IdCompte 2 doit etre correctement renseigné";
		er2.style.color = "red";
		valid = false;
	}
	if (val3 == "" || val3 < 10) {
		er3.innerHTML = "Le montant doit etre correctement renseigné ! (min 20)";
		er3.style.color = "red";
		valid = false;
	}
	return valid;
}