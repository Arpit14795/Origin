var num=parseInt(prompt("Enter a number"));
prime(num);
function prime(num)
{
	var d=Math.sqrt(num);
  	for(count =2;count<=d;count++)
  		{
  		if(num%count==0)
  			{
  			d=num;
  			break;
  			}
  		}
  	if(d!=num || num==1)
  		alert("Number is Prime");
  		else
  			alert("Number is not Prime");
}