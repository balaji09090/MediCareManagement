package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Appointment;

public interface AppointmentService {

	void add(Appointment appointment);

	List<Appointment> display();

	Appointment delete(Integer id);

	Appointment update(Appointment appointment, Integer id);

	Appointment search(Integer id);
	
	List<Appointment> getAppointmentsByDoctor(Integer doctorId);
	
    List<Appointment> getAppointmentsByPatient(Integer patientId);

	Appointment bookAppointment(String specialization, Appointment appointment);
}
