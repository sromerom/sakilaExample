package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Payment;
import com.liceu.sromerom.sakilaExample.entities.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentRepoImpl implements PaymentRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Payment> findAll() {
        return jdbcTemplate.query("SELECT * FROM payment", new BeanPropertyRowMapper<>(Payment.class));
    }

    @Override
    public int paymentProcess(long customerid, long staffid, long rentalid, double amount, String paymentdate) {
        return jdbcTemplate.update(
                "INSERT INTO payment (customer_id, staff_id, rental_id, amount,  payment_date) VALUES(?, ?, ?, ?, ?);", customerid, staffid, rentalid, amount, paymentdate);
    }
}
