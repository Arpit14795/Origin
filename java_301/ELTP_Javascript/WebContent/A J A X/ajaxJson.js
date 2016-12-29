
document.getElementById("empid").onblur = function() {
	var xmlHttp =  new XMLHttpRequest();
	
	var empid = document.getElementById("empid").value;
	var url = "jsonEmployees.jsp?empid="+empid;
	
	xmlHttp.open("GET", url, true);

	xmlHttp.onreadystatechange = responseHandler;

	
	//Send the request
	xmlHttp.send();
	
	//Process the response using callback handler
	function responseHandler() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {	//received usable response && successfully
			var resp = xmlHttp.responseText;
			var jsonObj = JSON.parse(resp);	
			document.getElementById("empname").value = jsonObj.name;
			document.getElementById("emprole").value = jsonObj.role;
			document.getElementById("empcomp").value = jsonObj.company;
		}
	}		
}