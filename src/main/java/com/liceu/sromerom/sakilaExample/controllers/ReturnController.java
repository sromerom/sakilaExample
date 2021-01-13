package com.liceu.sromerom.sakilaExample.controllers;

import com.liceu.sromerom.sakilaExample.entities.Customer;
import com.liceu.sromerom.sakilaExample.entities.Film;
import com.liceu.sromerom.sakilaExample.entities.Inventory;
import com.liceu.sromerom.sakilaExample.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReturnController {
    @Autowired
    ReturnService returnService;

    @GetMapping("/return")
    public String getReturn(Model model) {
        List<Film> films = returnService.findAllFilms();
        List<Customer> customers = returnService.findAllCustomers();
        model.addAttribute("films", films);
        model.addAttribute("customers", customers);
        return "return";
    }

    @PostMapping("/return")
    public String postReturn(@RequestParam("films") Long filmid, @RequestParam("customers") Long customerid, Model model) {
        boolean status = false;
        if (filmid != null && customerid != null) {
            //Aconseguim en quin inventori esta rentat el film seleccionat amb l'usuari seleccionat
            Inventory inventory = returnService.getInventoryRentedByCustomer(customerid, filmid);

            //Aconseguim en rentalid amb el que ha sigut rentada, per poder modificar-la i poder retornar-la.
            // Si es dona el cas que no hi troba cap, voldra dir que el client no te rentada la pelicula seleccionada.
            Long rentalid = returnService.isRentByCustomer(inventory.getInventory_id(), customerid);
            System.out.println("Rental ID: " + rentalid);
            if (rentalid != null) {
                //I feim el proces de retornada de la pelicula
                returnService.returnDVD(rentalid);
                status = true;
            }
        }
        model.addAttribute("status", status);
        return "return";
    }
}
