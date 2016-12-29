function DateFormat(){
	var d=new Date();
	var da=d.getDate();
	var m=d.getMonth()+1;
	var y=d.getFullYear();
	var line= da+"-"+m+"-"+y+"\n"+
		      da+"/"+m+"/"+y+"\n"+
		      m+"-"+da+"-"+y+"\n"+
		      m+"/"+da+"/"+y+"\n";
	alert(line);
		      
}
DateFormat();