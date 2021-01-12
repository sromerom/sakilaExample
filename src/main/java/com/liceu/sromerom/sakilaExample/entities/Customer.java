package com.liceu.sromerom.sakilaExample.entities;

import java.time.LocalDateTime;

public class Customer {
    private long customer_id;
    private long store_id;
    private String first_name;
    private String last_name;
    private String email;
    private long address_id;
    private short active;
    private LocalDateTime create_date;
    private LocalDateTime last_update;


    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", store_id=" + store_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", address_id=" + address_id +
                ", active=" + active +
                ", create_date=" + create_date +
                ", last_update=" + last_update +
                '}';
    }
}
