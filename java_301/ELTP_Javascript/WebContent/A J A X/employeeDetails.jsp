<%

    int empid=Integer.parseInt(request.getParameter("empid"));
    if(empid==1)
    {
    	out.println("Anand,CEO,Persistent");
    }
    else
    {
    	out.println("NA,NA,NA");
    }
%>