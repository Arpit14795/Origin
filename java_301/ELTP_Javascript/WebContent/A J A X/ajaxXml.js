
document.getElementById("empid").onblur = function() {
	var xmlHttp =  new XMLHttpRequest();
	
	var empid = document.getElementById("empid").value;
	var url = "xmlEmployees.jsp?empid="+empid;
	
	xmlHttp.open("GET", url, true);

	xmlHttp.onreadystatechange = responseHandler;

	
	//Send the request
	xmlHttp.send();
	
	//Process the response using callback handler
	function responseHandler() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {	//received usable response && successfully
			var resp = xmlHttp.responseXML;
			document.getElementById("empname").value = resp.getElementsByTagName("name")[0].firstChild.nodeValue;
			document.getElementById("emprole").value = resp.getElementsByTagName("role")[0].firstChild.nodeValue;
			document.getElementById("empcomp").value = resp.getElementsByTagName("company")[0].firstChild.nodeValue;
		}
	}		
}