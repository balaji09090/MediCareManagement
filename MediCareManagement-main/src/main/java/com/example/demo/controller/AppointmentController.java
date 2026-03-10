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

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService as;
	
	@PostMapping("add")
	public void add(@RequestBody Appointment appointment) {
		as.add(appointment);
	}
	
	@GetMapping("display")
	public List<Appointment> display() {
		return as.display();
	}
	
	@DeleteMapping("delete/{id}")
	public Appointment delete(@PathVariable Integer id) {
		return as.delete(id);
	}
	
	@PostMapping("search/{id}")
	public Appointment search(@PathVariable Integer id) {
		return as.search(id);
	}
	
	@PutMapping("update/{id}")
	public Appointment update(@RequestBody Appointment appointment, @PathVariable Integer id) {
		return as.update(appointment, id);
	}

}
