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

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	private DoctorService ds;
	
	@PostMapping("add")
	public void add(@RequestBody Doctor doctor) {
	ds.add(doctor);
	}
	
	@GetMapping("display")
	public List<Doctor> display() {
		return ds.display();
	}
	
	@DeleteMapping("delete/{id}")
	public Doctor delete(@PathVariable Integer id) {
		return ds.delete(id);
	}
	
	@PutMapping("update/{id}")
	public Patient update(@RequestBody Doctor doctor, @PathVariable Integer id) {
		return ds.update(doctor, id);
	}
	
	@PostMapping("search/{id}")
	public Doctor search(@PathVariable Integer id) {
		return ds.search(id);
	}
}
