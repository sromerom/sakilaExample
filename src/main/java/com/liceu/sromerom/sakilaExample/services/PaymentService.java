package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Payment;
import com.liceu.sromerom.sakilaExample.repos.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }
    public int paymentProcess(long customerid, long staffid, long rentalid, double amount) {
        LocalDateTime lt = LocalDateTime.now();
        return paymentRepo.paymentProcess(customerid, staffid, rentalid, amount, lt.toString());
    }
}
