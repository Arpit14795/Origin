package com.beans;

import java.text.SimpleDateFormat;
import java.util.List;

public class Patient {
	

	public Patient(int patientId, String patientName, int age) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
	}
	private int patientId;
	private String patientName;
	public Patient(int patientId, String patientName, int age,
			List<Appointment> appointments) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.appointments = appointments;
	}
	private int age;
	private List<Appointment> appointments;
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	@Override
	public String toString() {
		
		return "Patient [patientId=" + patientId + ", patientName="
				+ patientName + ", age=" + age + ", appointments=\n"
				+ appointments + "]\n";
	}

}
