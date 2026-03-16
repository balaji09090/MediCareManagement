package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidAge;
import com.example.demo.exception.InvalidDoB;
import com.example.demo.exception.InvalidGender;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidName;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository pr; 

    
    @Override
    public void add(Patient patient) {
        
        
//        id
        int id = patient.getId();
        if(id>0) {
    		if(pr.existsById(id)) {
    			throw new InvalidId("Id Already Exists");	
    		}
    	}
        
//        name
        String name = patient.getName();
        if(!patient.getName().matches("[a-zA-Z ]+")) {
        	throw new InvalidName("Name Should Contain Only Letters");
        }
        
//        gender
        String gender = patient.getGender();
        if(!(gender.equalsIgnoreCase("male") ||
        	     gender.equalsIgnoreCase("female") ||
        	     gender.equalsIgnoreCase("other"))) {

        	    throw new InvalidGender("Gender must be MALE, FEMALE or OTHER");
        	}
        
//        age 
        Integer age = patient.getAge();
        if(age < 0 || age > 120) {
        	throw new InvalidAge("Age must be between 0 to 120");
        }
        
//        dob
        Integer dateOfBirth = patient.getDateOfBirth();
        if(patient.getDateOfBirth() == null ) {
        	throw new InvalidDoB("Date of Birth cannot be null");
        }
        pr.save(patient);
    }

    @Override
    public List<Patient> display() {
        return pr.findAll();
    }

    @Override
    public Patient delete(Integer id) {
        // Find the patient first so we can return the deleted data
        if (pr.findById(id).isPresent()) {
            Patient temp = pr.findById(id).get();
            pr.deleteById(id);
            return temp;
        }
        return null;
    }

    @Override
    public Patient update(Patient patient, Integer id) {
        // Ensure the ID is set to the existing record ID before saving
        patient.setId(id);
        return pr.save(patient);
    }

	@Override
    public Patient search(Integer id) {
        // Returns the patient if found, otherwise returns null
		if(pr.findById(id).isPresent()) {
			return pr.findById(id).get();
		}
		return null;
    }

	
}