function merge()
{
	var arr1=[1,2,3,4,5,6,1,1,1];
	var arr2=[2,4,6,8,9,2,3,5,5];
	var arr3=arr1.concat(arr2);
	var arr4=[];
	arr3.sort();
	arr4.push(arr3[0]);
	var val=arr3[0];var c=0;
	for(var count=1;count<arr3.length;count++)
	{
		if(val==arr3[count])
		{
			val=arr3[count];
		}
		else 
		{
			arr4.push(arr3[count]);
			val=arr3[count];
		}
	}
	alert(arr4);
}
merge();

function myFunctionregex() 
{
	 var str = "Visit W3Schools!"; 
	    var n = str.search(/w3Schools/i);
   alert(n);
}
myFunctionregex();