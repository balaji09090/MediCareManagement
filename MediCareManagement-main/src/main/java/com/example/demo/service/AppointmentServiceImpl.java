package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DoctorNotAvailable;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.DoctorRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository ar; 
	
	@Autowired // FIXED: Added missing annotation to prevent NullPointerException on 'dr'
	private DoctorRepository dr;
	
	@Override
	public void add(Appointment appointment) {
		ar.save(appointment);
	}

	@Override
	public List<Appointment> display() {
		return ar.findAll();
	}

	@Override
	public Appointment delete(Integer id) {
		if(ar.findById(id).isPresent()) {
			Appointment temp = ar.findById(id).get();
			ar.deleteById(id);
			return temp;
		}
		return null;
	}

	@Override
	public Appointment update(Appointment appointment, Integer id) {
		appointment.setId(id);
		return ar.save(appointment);
	}

	@Override
	public Appointment search(Integer id) {
		return ar.findById(id).orElse(null);
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(Integer doctorId) {
		return ar.findByDoctorId(doctorId);
	}

	@Override
	public List<Appointment> getAppointmentsByPatient(Integer patientId) {
		return ar.findByPatientId(patientId);
	}
	
	@Override
	public Appointment bookAppointment(String specialization, Appointment appointment) {
		
		// 1. Exception Check: Safeguard against a null search string
		if (specialization == null || specialization.trim().isEmpty()) {
			throw new RuntimeException("Specialization query string cannot be empty");
		}

		List<Doctor> doctors = dr.findBySpecialization(specialization);
		
		// 2. Exception Check: Catch if the specialty doesn't exist at all
		if (doctors == null || doctors.isEmpty()) {
			throw new DoctorNotAvailable("No doctors found with specialization: " + specialization);
		}

		Doctor assignedDoctor = null;

		for (Doctor d : doctors) {
			// FIXED: Defensive null check on getAvailabilityStatus() to avoid NPE
		    if (d.getAvailabilityStatus() != null && d.getAvailabilityStatus().equalsIgnoreCase("Available")) {
		        assignedDoctor = d;
		        break;
		    }
		}

		if (assignedDoctor == null) {
		    throw new DoctorNotAvailable("No doctor available currently under: " + specialization);
		}

		appointment.setDoctor(assignedDoctor);

		// Mark doctor as busy so they don't get double booked
		assignedDoctor.setAvailabilityStatus("NOT_AVAILABLE"); // Matches your Doctor class constraints
		dr.save(assignedDoctor);

		return ar.save(appointment);
	}
}
