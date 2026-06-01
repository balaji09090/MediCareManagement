package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nurse {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String qualification;
	private String mob;
	private String shift;
	
	public Nurse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nurse(Integer id, String name, String qualification, String mob, String shift) {
		super();
		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.mob = mob;
		this.shift = shift;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", qualification=" + qualification + ", mob=" + mob + ", shift="
				+ shift + "]";
	}
	
	
	
}
