function validationRetrait() {
	var val1 = document.getElementById("retrait1").value;
	var val1 = document.getElementById("retrait2").value;
	var er1 = document.getElementById("errRetrait1");
	var er1 = document.getElementById("errRetrait2");
	var valid = true;
	if (val2 == "" || val2 <= 20) {
		er2.innerHTML = "Le retrait doit etre correctement renseigné ! (min 20)";
		er2.style.color = "red";
		valid = false;
	}
	if (val2 == "" || val2 <= 20) {
		er2.innerHTML = "Le retrait doit etre correctement renseigné ! (min 20)";
		er2.style.color = "red";
		valid = false;
	}
	return valid;
}
function validationVersement() {
	var val1 = document.getElementById("crea1").value;
	var er1 = document.getElementById("errcrea1");
	var valid = true;
	if (val1 == "" || val1 <= 0) {
		er1.innerHTML = "  Le num doit être renseigné !";
		er1.style.color = "red";
		valid = false;
	}
	return valid;
}
function validationVirement() {
	var val1 = document.getElementById("crea1").value;
	var er1 = document.getElementById("errcrea1");
	var valid = true;
	if (val1 == "" || val1 <= 0) {
		er1.innerHTML = "  Le num doit être renseigné !";
		er1.style.color = "red";
		valid = false;
	}
	return valid;
}