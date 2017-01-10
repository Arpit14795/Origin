package com.client;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.beans.Appointment;
import com.beans.Doctor;
import com.beans.Patient;
import com.beans.Tests;
import com.exception.DoctorNotFoundException;
import com.util.HospitalManagementServicesImpl;


public class Client
{
	public static void main(String[] args) 
	{
		HospitalManagementServicesImpl hos=new HospitalManagementServicesImpl();
		Set<Doctor>docset=hos.populateDoctorDetails("doctorDetails.txt");
		System.out.println(docset);
		//System.out.println("--------------------------------------------------------------------------");
		Set<Patient>patset=hos.populatePatientDetails();
		//System.out.println(patset);
		//System.out.println("--------------------------------------------------------------------------");
		
		Set<Doctor>avail=null;
//		try {
//			avail=hos.getDoctorsAsPerSpecialtyAndAvailability("General Physician", docset, "FRIDAY","TUESDAY");
//		} catch (DoctorNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("DOCTOR NOT FOUND");
//		}
		//System.out.println(avail);
		//System.out.println("--------------------------------------------------------------------------");
		for (Patient doctor : patset) {
		
		List<String> string=hos.getRecommendedTests(doctor);
		//System.out.println(doctor.getPatientId()+" "+string);
		}
		for (Patient pat : patset) 
		{
			//List<String> l=hos.getRecommendedTests(pat);
			//System.out.println(l);
//			for (Appointment a : pat.getAppointments()) {
//			Patient p=hos.updateDoctorsVisitDetails(pat, a.getAppointmentDate(),"updated",a.getTests());
//					System.out.println(p);
//			}
			String str=hos.generateAppointmentNotification(pat, docset);
		//	System.out.println(str);
		// double bill= hos.calculateBill(pat, docset);
		 //System.out.println(bill);
		}
		
		for (Patient pat : patset) 
		{
			//List<String> l=hos.getRecommendedTests(pat);
			//System.out.println(l);
			
			
			Patient p=hos.scheduleNextAppointment(pat.getPatientId(), "General Physician", patset, docset);
					System.out.println(p);
			
			
		}
		
		/*GregorianCalendar gc=new GregorianCalendar();
		gc.setTime(new java.util.Date ());
		System.out.println(gc.getTime());
		gc.set(Calendar.DAY_OF_WEEK	, 5);
		System.out.println(gc.getTime());*/
	}
}
