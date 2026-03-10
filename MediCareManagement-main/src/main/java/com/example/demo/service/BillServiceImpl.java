package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.model.Bill;
import com.example.demo.model.Doctor;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	 @Autowired
	    private AppointmentRepository appointmentRepository;
	 	private BillRepository billRepository;
		private Doctor doctor;
		private Appointment appointment;
	 	
	 	
	@Override
	public Bill generateBill(Integer appointmentId) {
		// TODO Auto-generated method stub
		
		// Create new Bill object
		Bill bill = new Bill();

		// Set appointment
		bill.setAppointment(appointment);

		// Set charges
		bill.setDoctorFee(doctor.getConsultationFee());
		bill.setMedicineCost(500.0);
		bill.setRoomCharge(1000.0);

		// Calculate total amount
		double totalAmount = bill.getDoctorFee() 
		                   + bill.getMedicineCost() 
		                   + bill.getRoomCharge();

		bill.setTotalAmount(totalAmount);

		// Set payment status
		bill.setPaymentStatus("PENDING");

		// Save bill in database
		return billRepository.save(bill);
	}
		
	

	@Override
	public Bill payBill(Integer billId) {
		// TODO Auto-generated method stub
		return null;
	}

}
