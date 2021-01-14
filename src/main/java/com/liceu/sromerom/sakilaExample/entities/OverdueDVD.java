package com.liceu.sromerom.sakilaExample.entities;

import java.time.LocalDateTime;

public class OverdueDVD {
    private String name;
    private String phone;
    private String title;
    private LocalDateTime theorical_return_date;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTheorical_return_date() {
        return theorical_return_date;
    }

    public void setTheorical_return_date(LocalDateTime theorical_return_date) {
        this.theorical_return_date = theorical_return_date;
    }

    @Override
    public String toString() {
        return "OverdueDVD{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", theorical_return_date=" + theorical_return_date +
                '}';
    }
}
