word(prompt("Enter a string"));

function word(str)
{
var arr=str.split(" ");
var count=0,index=0;
for(c in arr)
	{
	if(arr[c].length>count)
		{
		count=arr[c].length;
		index=c;
		}
	}

alert("Longest word in string is "+ arr[index]);
}
