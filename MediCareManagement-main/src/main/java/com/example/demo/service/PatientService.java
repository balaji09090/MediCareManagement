package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService {

	void add(Patient patient);

	List<Patient> display();

	Patient delete(Integer id);

	Patient update(Patient patient, Integer id);

	Patient search(Integer id);
	
	
	

}