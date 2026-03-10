package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Appointment {

	@Autowired
	@ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
	
	@Id
	private Integer id;
	private String status;
	private String symptoms;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Appointment(Patient patient, Doctor doctor, Integer id, String status, String symptoms) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.id = id;
		this.status = status;
		this.symptoms = symptoms;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Appointment [patient=" + patient + ", doctor=" + doctor + ", id=" + id + ", status=" + status
				+ ", symptoms=" + symptoms + "]";
	}
	
		
}
