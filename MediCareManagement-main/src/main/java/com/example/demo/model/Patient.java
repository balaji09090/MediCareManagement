package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Patient {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private Integer dateOfBirth;
	private String address;
	private String disease;
	private String mob;
	private String bloodGroup;
	private String appointedDoctor;
	private String patientStatus;
	private String admittingRoom;
	private String roomType;
	private String roomNumber;
	private String appointedNurse;
	private LocalDateTime admissionDate;
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(Integer id, String name, String gender, Integer age, Integer dateOfBirth, String address,
			String disease, String mob, String bloodGroup, String appointedDoctor, String patientStatus,
			String admittingRoom, String roomType, String roomNumber, String appointedNurse,
			LocalDateTime admissionDate) {
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
		this.appointedDoctor = appointedDoctor;
		this.patientStatus = patientStatus;
		this.admittingRoom = admittingRoom;
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		this.appointedNurse = appointedNurse;
		this.admissionDate = admissionDate;
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


	public String getAppointedDoctor() {
		return appointedDoctor;
	}


	public void setAppointedDoctor(String appointedDoctor) {
		this.appointedDoctor = appointedDoctor;
	}


	public String getPatientStatus() {
		return patientStatus;
	}


	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}


	public String getAdmittingRoom() {
		return admittingRoom;
	}


	public void setAdmittingRoom(String admittingRoom) {
		this.admittingRoom = admittingRoom;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	public String getAppointedNurse() {
		return appointedNurse;
	}


	public void setAppointedNurse(String appointedNurse) {
		this.appointedNurse = appointedNurse;
	}


	public LocalDateTime getAdmissionDate() {
		return admissionDate;
	}


	public void setAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", disease=" + disease + ", mob=" + mob + ", bloodGroup="
				+ bloodGroup + ", appointedDoctor=" + appointedDoctor + ", patientStatus=" + patientStatus
				+ ", admittingRoom=" + admittingRoom + ", roomType=" + roomType + ", roomNumber=" + roomNumber
				+ ", appointedNurse=" + appointedNurse + ", admissionDate=" + admissionDate + "]";
	}
	
	
	
	
	
	
}
