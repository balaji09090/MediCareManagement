package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.model.Bill;
import com.example.demo.model.Doctor;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.BillRepository;
// Import your custom exception packages here
// import com.example.demo.exception.*; 

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired  // FIXED: Added missing autowire injection
	private BillRepository billRepository;

	@Override
	public Bill generateBill(Integer appointmentId) {
		
		// 1. Exception Check: Validate if Appointment ID is null or missing
		if (appointmentId == null) {
			throw new RuntimeException("Appointment ID cannot be null"); 
		}

		// 2. Exception Check: Find the actual appointment or throw custom error
		Appointment appointment = appointmentRepository.findById(appointmentId)
				.orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + appointmentId));
		
		// 3. Exception Check: Verify if a bill is already linked to this appointment
		if (billRepository.existsByAppointmentId(appointmentId)) {
			throw new RuntimeException("A bill has already been generated for this appointment");
		}

		// 4. Exception Check: Get the Doctor from the appointment safely
		Doctor doctor = appointment.getDoctor();
		if (doctor == null) {
			throw new RuntimeException("No doctor is assigned to this appointment; billing aborted.");
		}

		// Create and populate the Bill object safely using retrieved database states
		Bill bill = new Bill();
		bill.setAppointment(appointment);

		// Pull fee dynamically from the assigned doctor object
		bill.setDoctorFee(doctor.getConsultationFee());
		bill.setMedicineCost(500.0);
		bill.setRoomCharge(1000.0);

		// Calculate total amount
		double totalAmount = bill.getDoctorFee() 
		                   + bill.getMedicineCost() 
		                   + bill.getRoomCharge();
		bill.setTotalAmount(totalAmount);

		// Set initial processing state status
		bill.setPaymentStatus("PENDING");

		// Save fresh database entry back to Railway
		return billRepository.save(bill);
	}

	@Override
	public Bill payBill(Integer billId) {
		// TODO Auto-generated method stub
		return null;
	}
}
