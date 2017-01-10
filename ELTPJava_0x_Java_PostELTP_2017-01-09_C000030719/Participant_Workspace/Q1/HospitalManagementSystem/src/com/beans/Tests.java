package com.beans;

public enum Tests {
	XRay(500.00), LipidProfile (400.00), CTScan(3000.00),StressTest(1500.00),Thyroid(500.00), B12(1300.00),ECG(800.00),BloodSugar(200.00);

 	private double charges;
	
	Tests(double charges){
		this.charges = charges;
	}
	
	public double getCharges(){
		return charges;
	}
}
