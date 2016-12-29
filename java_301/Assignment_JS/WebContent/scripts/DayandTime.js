function Time(){
	var d=new Date();
	var week=["Sunday","Monday","Tuesday","Wednesday","Friday","Saturday"];
	var hour=d.getHours();
	var type=" AM";
	
	if(hour==0)
		hour=12;
	else if(hour<13)
		type=" PM"
		else 
		{
			hour-=12;
			type=" PM";
		}
	alert("Today Date is : "+week[d.getDay()]+"\nCurrent Time is : "
			+hour+" : "+d.getMinutes()+" : "+d.getSeconds()+type);
}
Time();