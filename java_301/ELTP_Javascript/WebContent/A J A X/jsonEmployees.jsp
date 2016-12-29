<%
	int empid = Integer.parseInt(request.getParameter("empid"));
	if(empid == 1) {
		out.println("{\"name\" : \"Anand\",\"role\" : \"CEO\",\"company\" : \"Persistent\"}");
	}else {
		out.println("{\"name\" : \"NA\",\"role\" : \"NA\",\"company\" : \"NA\"}");
		
	}
	
%>
	
	