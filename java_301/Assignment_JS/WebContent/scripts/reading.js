function read(){
	var library = [ 
	               {
	                   author: 'Bill Gates',
	                   title: 'The Road Ahead',
	                   readingStatus: true
	               },
	               {
	                   author: 'Walter Isaacson ',
	                   title: 'Steve Jobs',
	                   readingStatus: true
	               },
	               {
	                   author: 'Randy Pauch',
	                   title:  'The Last Lecture', 
	                   readingStatus: false
	               }];
for(var count in library){
	var status;
	if(library[count].readingStatus==false)
		 status= "You still need to read" ;
	else
		status="Already read";
	
	alert(library[count].author+"\n"+library[count].title+"\n"+status);
}
}
read();