/**
 * 
 */

function myFunction(){
	var val1=document.getElementById("nom1").value;
	var val2=document.getElementById("nom2").value;
	var er1=document.getElementById("error1");
	var er2=document.getElementById("error2");
	var valid=true;
		if(val1=="" || val1==0){
			er1.innerHTML="  Le num doit être renseigné !";
			er1.style.color = "red";
			valid=false;
		}if(val2=="" || val1<=0){
			er2.innerHTML="  Le solde doit être renseigné !";
			er2.style.color = "red";
			valid=false;
		}
		return valid;
}