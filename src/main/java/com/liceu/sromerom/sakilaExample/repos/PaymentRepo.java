package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Payment;

import java.util.List;

public interface PaymentRepo {
    List<Payment> findAll();
    int paymentProcess(long customerid, long staffid, long rentalid, double amount, String payment_date);
}
