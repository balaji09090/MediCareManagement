package com.example.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity

public class Patient {
	
	@Id 
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private Integer dateOfBirth;
	private String address;
	private String disease;
	private String mob;
	private String bloodGroup;
	private String attendant;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(Integer id, String name, String gender, Integer age, Integer dateOfBirth, String address,
			String disease, String mob, String bloodGroup, String attendant) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.disease = disease;
		this.mob = mob;
		this.bloodGroup = bloodGroup;
		this.attendant = attendant;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Integer dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAttendant() {
		return attendant;
	}
	public void setAttendant(String attendant) {
		this.attendant = attendant;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", disease=" + disease + ", mob=" + mob + ", bloodGroup="
				+ bloodGroup + ", attendant=" + attendant + "]";
	}
	
	
	
}
