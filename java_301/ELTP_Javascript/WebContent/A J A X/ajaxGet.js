/**
 * 
*/

document.getElementById("empid").onblur = function() {
	var xmlHttp =  new XMLHttpRequest();
	
	var empid = document.getElementById("empid").value;
	var url = "employeeDetails.jsp?empid="+empid;
	
	xmlHttp.open("GET", url, true);

	xmlHttp.onreadystatechange = responseHandler;

	
	//Send the request
	xmlHttp.send();
	
	//Process the response using callback handler
	function responseHandler() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {	//received usable response && successfully
			var res = xmlHttp.responseText;
			var empDetails = res.split(",");
			document.getElementById("empname").value = empDetails[0];
			document.getElementById("emprole").value = empDetails[1];
			document.getElementById("empcomp").value = empDetails[2];
		}
	}		
}