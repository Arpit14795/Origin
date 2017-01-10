package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.beans.Appointment;
import com.beans.Doctor;
import com.beans.Patient;
import com.beans.Tests;
import com.exception.DoctorNotFoundException;


public class HospitalManagementServicesImpl implements
		HospitalManagementServices {
	ConnectionManagerImpl cmi=new ConnectionManagerImpl();
	@Override
	public Set<Patient> populatePatientDetails()
	{
		Set<Patient> set=new LinkedHashSet<>();
		Connection con=cmi.getConnection();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from patient_tbl");
			while(rs.next())
			{
				
				Patient p=new Patient(rs.getInt("patientid"),rs.getString("patientName"),rs.getInt("age"),
						new ArrayList<Appointment>());
				set.add(p);
			}
			
			rs=st.executeQuery("select * from appointment_tbl");
			while(rs.next())
			{
				Appointment app=new Appointment(rs.getInt("appointmentId"), rs.getInt("patientId"),
						rs.getInt("doctorId"), rs.getDate("appointmentDate"),rs.getString("analysisReport")
						);
				
				String s=rs.getString("tests");
				String str[]=null;
				if(s!=null)
				 str=s.split(",");
				
				List<Tests>list=new ArrayList<Tests>();
				if(str!=null)
				for (String string : str)
				{
				list.add(Tests.valueOf(string));	
				}
				
				app.setTests(list);
			
				
				for (Patient inset : set) 
				{
					if(inset.getPatientId()==app.getPatientId())
						inset.getAppointments().add(app);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return set;
	}

	@Override
	public Set<Doctor> populateDoctorDetails(String fileName) 
	{
		Set<Doctor>set=new LinkedHashSet<Doctor>();
		
		try(Scanner sc=new Scanner(new File(fileName)))
		{
			while(sc.hasNext())
			{
			String str[]=sc.nextLine().trim().split(",");
			String s[]=str[3].trim().split(":");
			List<String>list=new ArrayList<>();
			for (String string : s) 
			{
				list.add(string.trim());
			}
			Doctor d=new Doctor(Integer.parseInt(str[0].trim()), 
					str[1].trim(), str[2].trim(),list, Double.parseDouble(str[4].trim()));
			
			set.add(d);						
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	@Override
	public Set<Doctor> getDoctorsAsPerSpecialtyAndAvailability(
			String specialty, Set<Doctor> doctors, String... day)
			throws DoctorNotFoundException 
			{
		
		Set<Doctor> set=new LinkedHashSet<Doctor>();
		for (Doctor doctor : doctors)
		{
			if(doctor.getSpecialty().equals(specialty))
				set.add(doctor);
		}
		Set<Doctor> newset=new LinkedHashSet<Doctor>();
		if(day!=null && day.length!=0)
		{
			for (String string : day) 
			{
				
				for (Doctor doctor : set)
				{
					if(doctor.getAvailability().contains(string))
					{
						newset.add(doctor);
					}
				}
			}
		}
		if(newset.size()==0)
			throw new DoctorNotFoundException ();
		return newset;
	}

	@Override
	public List<String> getRecommendedTests(Patient patient) 
	{
		 List<String> list=new ArrayList<String>();
		 
		List<Appointment> l=patient.getAppointments();
		Collections.sort(l);
		for (Appointment app : l) 
		{
			List<Tests> test=app.getTests();
			if(test.size()!=0)
			{
				for (Tests tests : test) 
				{
					list.add(tests.toString());
				}
			}
		}
		return list;
	}

	@Override
	public Patient updateDoctorsVisitDetails(Patient patient,
			Date appointmentDate, String analysisReport,
			List<Tests> prescribedTests) 
	{
		
		for (Appointment app : patient.getAppointments())
		{
			if(appointmentDate.equals(app.getAppointmentDate()))
			{
				app.setAnalysisReport(analysisReport);
					app.setTests(prescribedTests);
			}
		}
		return patient;
	}

	@Override
	public double calculateBill(Patient patient, Set<Doctor> doctors) 
	{
		List<Appointment> l=patient.getAppointments();
		if(l.size()!=0)
		{
		Collections.sort(l);
		Appointment app=l.get(0);
		double bill=0;
		for (Doctor doc : doctors)
		{
			if(doc.getDoctorId()==app.getDoctorId())
			{
				bill=doc.getConsultationCharges();
			}
		}
		for (Tests t : app.getTests()) 
		{
			bill+=t.getCharges();
		}
		if(patient.getAge()>60)
		{
			bill=((bill-(bill*.10)));
		}
		return bill;
		
		}
		else
			return 0;
	}

	@Override
	public Patient scheduleNextAppointment(int patientId, String specialty,
			Set<Patient> patients, Set<Doctor> doctors) 
	{
		Patient p=null;
		for (Patient pat : patients) 
		{
			if(pat.getPatientId()==patientId)
			{
				p=new Patient(patientId,pat.getPatientName(),pat.getAge(),
						pat.getAppointments());
			}
		}
		//System.out.println(p);
		List<Appointment>a=p.getAppointments();
		Collections.sort(a);
		p.setAppointments(a);
		if(p.getAppointments().size()!=0)
		{
			for (Doctor doctor : doctors)
			{
				if(doctor.getSpecialty().equals(specialty) && doctor.getDoctorId()==a.get(0).getDoctorId())
				{
					GregorianCalendar gc=new GregorianCalendar();
					gc.setTime(a.get(0).getAppointmentDate());
					
					List<String>l=doctor.getAvailability();
					
					int t=gc.get(Calendar.DAY_OF_WEEK);
					Map<String,Integer>map=new LinkedHashMap<String,Integer>();
					map.put("MONDAY", 2);
					map.put("TUESDAY", 3);
					map.put("WEDNESDAY", 4);
					map.put("THURSDAY", 5);
					map.put("FRIDAY", 6);
					map.put("SATURDAY", 7);
					
					int days=0;
					int count=0;
					for (String string : l) 
					{
						for (Entry<String, Integer> ent : map.entrySet()) 
						{
								if(count<2)
							if(ent.getKey().equals(l));
							{
								days=ent.getValue();
								count++;
							}
							
						}
					}
					gc.set(Calendar.DAY_OF_WEEK, days);
					a.get(0).setAppointmentDate(gc.getTime());
					
					
				}
			}
		}
		else
		{
		
			String str[]={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
			try {
				Set<Doctor> doc=getDoctorsAsPerSpecialtyAndAvailability(
						specialty,doctors,str);
				Appointment ap=new Appointment();
				ap.setAppointmentDate(new Date());
				List<Doctor> d=new ArrayList<Doctor>(doc);
				ap.setDoctorId(d.get(0).getDoctorId());
				p.getAppointments().add(ap);
			} catch (DoctorNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
		
	}

	@Override
	public String generateAppointmentNotification(Patient patient,
			Set<Doctor> doctors) 
	{
		StringBuffer msg=new StringBuffer(NOTIFICATION_MESSAGE_FORMAT);
		String name=patient.getPatientName();
		
		List<Appointment>list=patient.getAppointments();
		if(list.size()!=0)
		{
		Collections.sort(list);
		SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM YYYY");
		String date=sdf.format(list.get(0).getAppointmentDate());
		
		String dname="";
		for (Doctor docs : doctors) 
		{
			if(docs.getDoctorId()==list.get(0).getDoctorId())
			{
				dname=docs.getDoctorName();
				break;
			}
		}
		String s1="'patientname'";
		int index=msg.indexOf(s1);
		msg.replace(index, index+s1.length(), name);
		String s2="'date'";
		index=msg.indexOf(s2);
		msg.replace(index, index+s2.length(), date);
		String s3="'doctorname'";
		index=msg.indexOf(s3);
		msg.replace(index,index+s3.length(), dname);
		
		//"Hello 'patientname',Your appointment is scheduled on 'date' with Dr. 'doctorname'."
		return msg.toString();
		}
		return "Hello 'patientname',Your appointment is scheduled on 'date' with Dr. 'doctorname'.";
	}

	

}
