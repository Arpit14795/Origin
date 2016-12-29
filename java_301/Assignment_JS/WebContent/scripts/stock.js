/**
 * 
 */

var stock={};

stock.name="Persistent";
stock.price="750";
stock.advice="Buy";
stock.description="IT company";

stock.setPrice=function(p)
{
	this.price=p;
}

stock.getPrice=function()
{
	return this.price;
}

stock.setAdvice=function(a)
{
	this.advice=a;
}

stock.getAdvice=function()
{
	return this.advice;
}

var a=stock.getPrice();
var b=stock.getAdvice();

alert("Before change "+a+" "+b+"\n");

stock.setPrice(100);
stock.setAdvice("Sell");

 a=stock.getPrice();
 b=stock.getAdvice();
alert("\nAfter change "+a+" "+b);