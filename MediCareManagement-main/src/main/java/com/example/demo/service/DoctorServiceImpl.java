package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidEmail;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidName;
import com.example.demo.exception.InvalidQualification;
import com.example.demo.exception.InvalidSpecialization;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository dr;

	@Override
	public void add(Doctor doctor) {
		// TODO Auto-generated method stub
		
//		id
		int id = doctor.getId();
		if(id>0) {
			if(dr.existsById(id)) {
				throw new InvalidId("Id Already Exists");
			}
		}
		
//		name
		String name = doctor.getName();
		if(!doctor.getName().matches("[a-zA-Z ]+")) {
        	throw new InvalidName("Name Should Contain Only Letters");
		}
		
//		specialization
		String specialization = doctor.getSpecialization();
		if(specialization == null || specialization.isEmpty()) {
			throw new InvalidSpecialization("Specialization cannot be empty");
		}
		
//		qualification 
		String qualification = doctor.getQualification();
		if(qualification == null || qualification.isEmpty()) {
			throw new InvalidQualification("Qualification cannot be empty");
		}
		if(!qualification.matches("[a-zA-Z. ]+")) {
			throw new InvalidQualification("Qualification should contain only letters");
		}
		
//		email
		String email = doctor.getEmail();
		if (dr.existByEmail(email)) {
			throw new InvalidEmail("Email Already Exists");
		}
		if (email == null || email.isEmpty()) {
			throw new InvalidEmail("Email Cannot Be Empty");
		}
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new InvalidEmail("Invalid Email Format");
		}
		
//		mob
		
		dr.save(doctor);
	}

	@Override
	public List<Doctor> display() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}

	@Override
	public Doctor delete(Integer id) {
		// TODO Auto-generated method stub
		if (dr.findById(id).isPresent()) {
			Doctor temp = dr.findById(id).get();
			dr.deleteById(id);
			return temp;
		}
		return null;
	}

	@Override
	public Patient update(Doctor doctor, Integer id) {
		// TODO Auto-generated method stub
		doctor.setId(id);
		dr.save(doctor);
		return null;
	}

	@Override
	public Doctor search(Integer id) {
		// TODO Auto-generated method stub
		if(dr.findById(id).isPresent()) {
			return dr.findById(id).get();
		}
		return null;
	}

	@Override
	public Doctor getDoctorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> findBySpecialty(String specialization) {
		// TODO Auto-generated method stub
		return null;
	}

}	
