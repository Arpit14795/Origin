document.getElementById("mybtn").onclick=reset;
document.getElementById("t1").onclick=copy;
document.getElementById("t2").onclick=copy;
document.getElementById("t3").onclick=copy;
document.getElementById("t4").onclick=copy;
document.getElementById("t5").onclick=copy;
document.getElementById("t6").onclick=copy;
document.getElementById("t7").onclick=copy;

var count=1;

function copy(event)
{
	if(count<6)
	{
		var img=document.getElementById(event.target.id);
		var temp=count;
		var bool=1;
		while(temp>0)
		{
			if(event.target.src==document.getElementById("j"+temp).src)
				{
				bool=0;
				break;
				}
			temp--;
		}
		if(bool==1)
		{
			var cimg=document.getElementById("j"+count);
			cimg.setAttribute("src", event.target.src);
			img.style.border="5px solid red";
			count++;
		}
	}
	if(count==6)
		{
		document.getElementById("msg").innerHTML="You can select only 5 elements";
		document.getElementById("mybtn").disabled = false;
		}
}
function reset()
{
	var rs=1;
	while(rs!=6)
		{
		var s=document.getElementById("j"+rs);
		s.setAttribute("src", "images/blank.jpg");
		rs++;
		}
	var c=1;
	while(c<=7)
		{
		document.getElementById("i"+c).style.border="5px solid black";
		c++;
		}
	document.getElementById("msg").innerHTML="";
	document.getElementById("mybtn").disabled = true;
	count=1;
}
