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
    FilmService filmService;

    @Autowired
    CustomerService customerService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    StaffService staffService;

    @Autowired
    RentalService rentalService;

    @Autowired
    StoreService storeService;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/rental")
    public String getRental(Model model) {
        List<Film> films = filmService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Staff> staffs = staffService.findAll();
        model.addAttribute("films", films);
        model.addAttribute("customers", customers);
        model.addAttribute("staffs", staffs);
        return "rental";
    }

    @PostMapping("/rental")
    public String postRental(@RequestParam("films") Long filmid, @RequestParam("customers") Long customerid, @RequestParam("staffs") Long staffid, Model model) {
        boolean status = false;
        if (filmid != null && customerid != null && staffid != null) {
            //Conseguir storeid;
            Store store = storeService.getStoreByStaff(staffid);
            Inventory inventory = inventoryService.getInventoryWithRequiredFilm(filmid, store.getStore_id());
            //Inventory inventory = new Inventory();
            if (inventory != null) {
                //Cream el registre a la taula rental
                rentalService.rentDVD(inventory.getInventory_id(), customerid, staffid);

                //Aconseguim quan costa la pelicula seleccionada
                double amount = filmService.getRentalDate(filmid);

                //Aconseguim el rentalid del registre que s'ha creat fa uns moments
                long rentalid = rentalService.isRentByCustomer(inventory.getInventory_id(), customerid);

                //Cream la paga a la taula payment
                paymentService.paymentProcess(customerid, staffid, rentalid, amount);

                status = true;
            }
        }
        model.addAttribute("status", status);
        return "rental";
    }
}
