function duplicate(){
	var arr=[1,2,3,4,5,5,5,6,6,3,2,1,1];
	arr.sort();
	var dupl="";var val=arr[0];var c=0;
	for(var count=1;count<arr.length;count++){
		if(val==arr[count]&& c==0){
			val=arr[count];
			dupl+=arr[count]+" ";
			c++;
		}
		else {
			c=0;
			val=arr[count];
		}
	}
	alert(dupl);
}
duplicate();

