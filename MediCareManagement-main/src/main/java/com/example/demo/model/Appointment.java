package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {
	   	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	private String status;
	private String symptoms;
	private LocalDateTime appointmentDate;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appointment(Integer id, Patient patient, Doctor doctor, String status, String symptoms,
			LocalDateTime appointmentDate) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.status = status;
		this.symptoms = symptoms;
		this.appointmentDate = appointmentDate;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}


	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patient=" + patient + ", doctor=" + doctor + ", status=" + status
				+ ", symptoms=" + symptoms + ", appointmentDate=" + appointmentDate + "]";
	}
	
	
	
		
}
