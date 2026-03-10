package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;

public interface DoctorService {
	
	
	void add(Doctor doctor);

	List<Doctor> display();

	Doctor delete(Integer id);

	Patient update(Doctor doctor, Integer id);

	Doctor search(Integer id);
	
	Doctor getDoctorById(Integer id);
	
	List<Doctor> findBySpecialty(String specialization);
}
