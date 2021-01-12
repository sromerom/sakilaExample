package com.liceu.sromerom.sakilaExample.entities;

import java.time.LocalDateTime;

public class Rental {
    private long rental_id;
    private LocalDateTime rental_date;
    private long inventory_id;
    private long customer_id;
    private LocalDateTime return_date;
    private long staff_id;
    private LocalDateTime last_update;

    public long getRental_id() {
        return rental_id;
    }

    public void setRental_id(long rental_id) {
        this.rental_id = rental_id;
    }

    public LocalDateTime getRental_date() {
        return rental_date;
    }

    public void setRental_date(LocalDateTime rental_date) {
        this.rental_date = rental_date;
    }

    public long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rental_id=" + rental_id +
                ", rental_date=" + rental_date +
                ", inventory_id=" + inventory_id +
                ", customer_id=" + customer_id +
                ", return_date=" + return_date +
                '}';
    }
}
