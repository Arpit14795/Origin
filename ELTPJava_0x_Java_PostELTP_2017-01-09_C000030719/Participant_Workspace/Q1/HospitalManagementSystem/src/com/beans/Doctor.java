package com.beans;

import java.util.List;

public class Doctor {
	

	
	private int doctorId;
	private String doctorName;
	private String specialty;
	private List<String> availability;
	private double consultationCharges;
	
	public Doctor() {
	}

	public Doctor(int doctorId, String doctorName, String specialty,
			List<String> availability, double consultationCharges) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialty = specialty;
		this.availability = availability;
		this.consultationCharges = consultationCharges;
	}

	

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public List<String> getAvailability() {
		return availability;
	}

	public void setAvailability(List<String> availability) {
		this.availability = availability;
	}

	public double getConsultationCharges() {
		return consultationCharges;
	}

	public void setConsultationCharges(double consultationCharges) {
		this.consultationCharges = consultationCharges;
	}
	
	@Override
	public String toString() {
		return "Doctor\n [doctorId=" + doctorId + ", doctorName=" + doctorName
				+ ", specialty=" + specialty + ", availability=\n" + availability
				+ ", consultationCharges=" + consultationCharges + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + doctorId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (doctorId != other.doctorId)
			return false;
		return true;
	}
	
}
