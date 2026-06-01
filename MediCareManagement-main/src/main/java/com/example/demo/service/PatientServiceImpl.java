package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidAge;
import com.example.demo.exception.InvalidBloodGroup;
import com.example.demo.exception.InvalidDoB;
import com.example.demo.exception.InvalidGender;
import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.exception.InvalidName;
import com.example.demo.exception.InvalidSymptoms;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository pr; 

    
    @SuppressWarnings("unused")
	@Override
    public void add(Patient patient) {
        
        
//      id
      if (patient.getId() != null) {
          if (patient.getId() > 0) {
              if (pr.existsById(patient.getId())) {
                  throw new InvalidId("Id Already Exists");    
              }
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
        
//      Mobile validation
		String mob = patient.getMob();
		
		if (mob.length() == 10) {
			if (mob.charAt(0) == '0' || mob.charAt(0) == '1' || mob.charAt(0) == '2' || mob.charAt(0) == '3' || mob.charAt(0) == '4' || mob.charAt(0) == '5')
				throw new InvalidMobileNumber("INVALID MOBILE NUMBER");
			
			for (int i=0; i< mob.length(); i++) {
				if (!Character.isDigit(mob.charAt(i)))
					throw new InvalidMobileNumber("INVALID MOBILE NUMBER");
				}
			}else 
	    throw new InvalidMobileNumber("INVALID MOBILE NUMBER");  
		
//		Blood Group
		String bloodGroup = patient.getBloodGroup();
		if(patient.getBloodGroup() == null) {
			throw new InvalidBloodGroup("Invalid Blood Group");
		}
		
//		Disease Validation
		String disease = patient.getDisease();
		if (disease == null || disease.trim().isEmpty()) {
		    throw new InvalidSymptoms("Disease or symptoms field cannot be empty.");
		}
		
		// Address Validation
		String address = patient.getAddress();
		if (address == null || address.trim().isEmpty()) {
		    throw new InvalidName("Patient address cannot be empty.");
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