function temperature_F2C(){
var val=parseInt(prompt("enter temperature in F:"));
	var result=(val-32)*5/9;
	alert(result);
}
temperature_F2C();

function temperature_C2F(){
	var val=parseInt(prompt("enter temperature in C:"));
		var result=(val*9/5)+32;
		alert(result);
	}
temperature_C2F();