package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController {

	@Autowired
	private PatientService ps;
	
	@PostMapping("add")
	public void add (@RequestBody Patient patient) {
		ps.add(patient);
	}
	
	@GetMapping("display")
	public List<Patient> display() {
		return ps.display();
	}
	
	@DeleteMapping("delete/{id}")
	public Patient delete(@PathVariable Integer id) {
		return ps.delete(id);
	}
	
	@PutMapping("update/{id}")
	public Patient update(@RequestBody Patient patient, @PathVariable Integer id) {
		return ps.update(patient, id);
	}
	
	@PostMapping("search/{id}")
	public Patient search(@PathVariable Integer id) {
		return ps.search(id);
	}
}
