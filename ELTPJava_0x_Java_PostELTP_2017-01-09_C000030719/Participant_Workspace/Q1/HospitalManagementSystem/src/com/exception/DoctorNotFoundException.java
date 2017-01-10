package com.exception;

public class DoctorNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public DoctorNotFoundException() {
		super("Doctor not found for specified speciality");
	}
	
}
