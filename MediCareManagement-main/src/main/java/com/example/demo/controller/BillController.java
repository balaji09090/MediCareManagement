package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bill;
import com.example.demo.service.BillService;

@RestController
@RequestMapping("bill")
public class BillController {

	    @Autowired
	    private BillService billService;

	    @PostMapping("generate/{appointmentId}")
	    public Bill generateBill(@PathVariable Integer appointmentId) {
	        return billService.generateBill(appointmentId);
	    }

	    @PutMapping("pay/{billId}")
	    public Bill payBill(@PathVariable Integer billId) {
	        return billService.payBill(billId);
	    }
	}

