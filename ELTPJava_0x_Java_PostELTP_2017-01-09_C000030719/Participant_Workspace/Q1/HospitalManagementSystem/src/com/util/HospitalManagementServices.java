package com.util;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.beans.Doctor;
import com.beans.Patient;
import com.beans.Tests;
import com.exception.DoctorNotFoundException;

public interface HospitalManagementServices {

	String NOTIFICATION_MESSAGE_FORMAT = "Hello 'patientname',Your appointment is scheduled on 'date' with Dr. 'doctorname'.";

	public Set<Patient> populatePatientDetails();

	public Set<Doctor> populateDoctorDetails(String fileName);

	public Set<Doctor> getDoctorsAsPerSpecialtyAndAvailability(String specialty, Set<Doctor> doctors, String... day)throws DoctorNotFoundException;

	public List<String> getRecommendedTests(Patient patient);

	Patient updateDoctorsVisitDetails(Patient patient, Date appointmentDate,String analysisReport, List<Tests> prescribedTests);

	double calculateBill(Patient patient, Set<Doctor> doctors);

	public Patient scheduleNextAppointment(int patientId, String specialty,Set<Patient> patients, Set<Doctor> doctors);

	public String generateAppointmentNotification(Patient patient,Set<Doctor> doctors);

}
