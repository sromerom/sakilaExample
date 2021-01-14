package com.liceu.sromerom.sakilaExample.controllers;

import com.liceu.sromerom.sakilaExample.entities.*;
import com.liceu.sromerom.sakilaExample.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RentalController {
    @Autowired
    RentService rentService;

    @GetMapping("/rental")
    public String getRental(Model model) {
        List<Film> films = rentService.findAllFilms();
        List<Customer> customers = rentService.findAllCustomers();
        List<Staff> staffs = rentService.findAllStaff();
        model.addAttribute("films", films);
        model.addAttribute("customers", customers);
        model.addAttribute("staffs", staffs);
        return "rental";
    }

    @PostMapping("/rental")
    public String postRental(@RequestParam("films") Long filmid, @RequestParam("customers") Long customerid, @RequestParam("staffs") Long staffid, Model model) {
        short status = rentService.rentDVD(filmid, customerid, staffid);
        model.addAttribute("status", status);
        return "rental";
    }
}
