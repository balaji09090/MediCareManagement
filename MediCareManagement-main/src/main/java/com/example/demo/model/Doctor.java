package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Doctor {

	@Id
	private Integer id;
	private String name;
	private String specialization;
	private String qualification;
	private String email;
	private String mob;
	private Double consultationFee;
	private String availabilityStatus;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(Integer id, String name, String specialization, String qualification, String email, String mob,
			Double consultationFee, String availabilityStatus) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.qualification = qualification;
		this.email = email;
		this.mob = mob;
		this.consultationFee = consultationFee;
		this.availabilityStatus = availabilityStatus;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public Double getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", qualification="
				+ qualification + ", email=" + email + ", mob=" + mob + ", consultationFee=" + consultationFee
				+ ", availabilityStatus=" + availabilityStatus + "]";
	}
	
		
}
