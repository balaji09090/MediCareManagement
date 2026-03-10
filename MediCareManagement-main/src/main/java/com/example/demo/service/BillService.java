package com.example.demo.service;

import com.example.demo.model.Bill;

public interface BillService {
	
    Bill generateBill(Integer appointmentId);
    Bill payBill(Integer billId);
}
