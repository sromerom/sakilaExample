package com.liceu.sromerom.sakilaExample.entities;

import java.time.LocalDateTime;

public class Payment {
    private long payment_id;
    private long customer_id;
    private long staff_id;
    private long rental_id;
    private double amount;
    private LocalDateTime payment_date;
    private LocalDateTime last_update;

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public long getRental_id() {
        return rental_id;
    }

    public void setRental_id(long rental_id) {
        this.rental_id = rental_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", customer_id=" + customer_id +
                ", staff_id=" + staff_id +
                ", rental_id=" + rental_id +
                ", amount=" + amount +
                ", payment_date=" + payment_date +
                ", last_update=" + last_update +
                '}';
    }
}
