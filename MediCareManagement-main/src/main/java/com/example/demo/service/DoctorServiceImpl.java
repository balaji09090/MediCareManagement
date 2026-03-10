package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
