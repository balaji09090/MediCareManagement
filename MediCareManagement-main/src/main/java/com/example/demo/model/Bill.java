package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Bill {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @OneToOne
	    private Appointment appointment;
	    private Double doctorFee;
	    private Double medicineCost;
	    private Double roomCharge;
	    private Double totalAmount;
	    private Double mediCareCoverage;
	    private Double patientResponsibility;
	    private String paymentStatus;
	    
	    
		public Bill() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Bill(Integer id, Appointment appointment, Double doctorFee, Double medicineCost, Double roomCharge,
				Double totalAmount, Double mediCareCoverage, Double patientResponsibility, String paymentStatus) {
			super();
			this.id = id;
			this.appointment = appointment;
			this.doctorFee = doctorFee;
			this.medicineCost = medicineCost;
			this.roomCharge = roomCharge;
			this.totalAmount = totalAmount;
			this.mediCareCoverage = mediCareCoverage;
			this.patientResponsibility = patientResponsibility;
			this.paymentStatus = paymentStatus;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Appointment getAppointment() {
			return appointment;
		}


		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
		}


		public Double getDoctorFee() {
			return doctorFee;
		}


		public void setDoctorFee(Double doctorFee) {
			this.doctorFee = doctorFee;
		}


		public Double getMedicineCost() {
			return medicineCost;
		}


		public void setMedicineCost(Double medicineCost) {
			this.medicineCost = medicineCost;
		}


		public Double getRoomCharge() {
			return roomCharge;
		}


		public void setRoomCharge(Double roomCharge) {
			this.roomCharge = roomCharge;
		}


		public Double getTotalAmount() {
			return totalAmount;
		}


		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}


		public Double getMediCareCoverage() {
			return mediCareCoverage;
		}


		public void setMediCareCoverage(Double mediCareCoverage) {
			this.mediCareCoverage = mediCareCoverage;
		}


		public Double getPatientResponsibility() {
			return patientResponsibility;
		}


		public void setPatientResponsibility(Double patientResponsibility) {
			this.patientResponsibility = patientResponsibility;
		}


		public String getPaymentStatus() {
			return paymentStatus;
		}


		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}


		@Override
		public String toString() {
			return "Bill [id=" + id + ", appointment=" + appointment + ", doctorFee=" + doctorFee + ", medicineCost="
					+ medicineCost + ", roomCharge=" + roomCharge + ", totalAmount=" + totalAmount
					+ ", mediCareCoverage=" + mediCareCoverage + ", patientResponsibility=" + patientResponsibility
					+ ", paymentStatus=" + paymentStatus + "]";
		}
	    
	    
		
			    
}
