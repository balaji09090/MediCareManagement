package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Appointment;
import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByDoctorId(Integer doctorId);
	
	List<Appointment> findByPatientId(Integer patientId);
	
	List<Appointment> findByStatus(String status);
}
