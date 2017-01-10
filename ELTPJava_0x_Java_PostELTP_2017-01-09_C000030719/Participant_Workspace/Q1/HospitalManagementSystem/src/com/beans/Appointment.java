package com.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment implements Comparable<Appointment> {
	 	
	 	public Appointment(int appointmentId, int patientId, int doctorId,
				Date appointmentDate, String analysisReport) {
			super();
			this.appointmentId = appointmentId;
			this.patientId = patientId;
			this.doctorId = doctorId;
			this.appointmentDate = appointmentDate;
			this.analysisReport = analysisReport;
		}
	 	private int appointmentId;
	 	private int patientId;
		private int doctorId;
	 	private Date appointmentDate;
	 	private String analysisReport;
	 	private List<Tests> tests=new ArrayList<>();
	 	
	 	public Appointment() {
			// TODO Auto-generated constructor stub
		}
	 	
		public int getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}
		public Date getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(Date appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public String getAnalysisReport() {
			return analysisReport;
		}
		public void setAnalysisReport(String analysisReport) {
			this.analysisReport = analysisReport;
		}
		public int getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}
		public List<Tests> getTests() {
			return tests;
		}
		public void setTests(List<Tests> tests) {
			this.tests = tests;
		}

		public int getPatientId() {
			return patientId;
		}

		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}

		@Override
		public String toString() {
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
			return "Appointment [appointmentId=" + appointmentId
					+ ", doctorId=" + doctorId + ", appointmentDate="
					+ (appointmentDate!=null?sdf.format(appointmentDate):appointmentDate )+ ", analysisReport=" + analysisReport
					+ ", tests=" + tests + ", patientId=" + patientId + "]";
		}

		@Override
		public int compareTo(Appointment a) {
			// TODO Auto-generated method stub
			return a.getAppointmentDate().compareTo(this.getAppointmentDate());
		}
	 	
	 
		
}
