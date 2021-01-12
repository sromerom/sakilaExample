package com.liceu.sromerom.sakilaExample.controllers;

import com.liceu.sromerom.sakilaExample.entities.Customer;
import com.liceu.sromerom.sakilaExample.entities.Film;
import com.liceu.sromerom.sakilaExample.entities.Inventory;
import com.liceu.sromerom.sakilaExample.entities.Staff;
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
    FilmService filmService;

    @Autowired
    CustomerService customerService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    StaffService staffService;

    @Autowired
    RentalService rentalService;

    @GetMapping("/rental")
    public String getRental(Model model) {
        List<Film> films = filmService.findAll();
        List<Customer> customers = customerService.findAll();
        model.addAttribute("films", films);
        model.addAttribute("customers", customers);
        return "rental";
    }

    @PostMapping("/rental")
    public String postRental(@RequestParam("films") Long filmid, @RequestParam("customers") Long customerid, Model model) {
        boolean status = false;
        if (filmid != null && customerid != null) {
            Inventory inventory = inventoryService.getInventoryFromFilmId(filmid);
            Staff staff = staffService.getStaffByStore(inventory.getStore_id());
            if (inventory != null && staff != null) {
                rentalService.rentDVD(inventory.getInventory_id(), customerid, staff.getStaff_id());
                status = true;
            }
        }
        model.addAttribute("status", status);
        return "rental";
    }
}
