package com.liceu.sromerom.sakilaExample.entities;

import java.time.LocalDateTime;

public class Staff {
    private long staff_id;
    private String first_name;
    private String last_name;
    private String address_id;
    private String picture;
    private long store_id;
    private boolean active;
    private String username;
    private String password;
    private LocalDateTime last_update;
    private String email;

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
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

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address_id='" + address_id + '\'' +
                ", picture='" + picture + '\'' +
                ", store_id=" + store_id +
                ", active=" + active +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", last_update=" + last_update +
                ", email='" + email + '\'' +
                '}';
    }
}
