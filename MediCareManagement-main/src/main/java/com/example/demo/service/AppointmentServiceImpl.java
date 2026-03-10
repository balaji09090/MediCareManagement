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
	private DoctorRepository dr;
	
	@Override
	public void add(Appointment appointment) {
		// TODO Auto-generated method stub
		ar.save(appointment);
	}

	@Override
	public List<Appointment> display() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public Appointment delete(Integer id) {
		// TODO Auto-generated method stub
		if(ar.findById(id).isPresent()) {
			Appointment temp = ar.findById(id).get();
			ar.deleteById(id);
			return temp;
		}
		return null;
	}

	@Override
	public Appointment update(Appointment appointment, Integer id) {
		// TODO Auto-generated method stub
		appointment.setId(id);
		return ar.save(appointment);
	}

	@Override
	public Appointment search(Integer id) {
		// TODO Auto-generated method stub
		return ar.findById(id).orElse(null);
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(Integer doctorId) {
		// TODO Auto-generated method stub
		return ar.findByDoctorId(doctorId);
	}

	@Override
	public List<Appointment> getAppointmentsByPatient(Integer patientId) {
		// TODO Auto-generated method stub
		return ar.findByPatientId(patientId);
	}
	
	@Override
	public Appointment bookAppointment(String specialization, Appointment appointment) {

		List<Doctor> doctors = dr.findBySpecialization(specialization);

		Doctor assignedDoctor = null;

		for (Doctor d : doctors) {
		    if (d.getAvailabilityStatus().equalsIgnoreCase("Available")) {
		        assignedDoctor = d;
		        break;
		    }
		}

		if (assignedDoctor == null) {
		    throw new DoctorNotAvailable("No doctor available");
		}

		appointment.setDoctor(assignedDoctor);

		// Optional but recommended: mark doctor as busy
		assignedDoctor.setAvailabilityStatus("Busy");
		dr.save(assignedDoctor);

		return ar.save(appointment);

	}
}
