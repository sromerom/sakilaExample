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
    MainService mainService;

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
        short status = returnService.returnDVD(filmid, customerid);
        model.addAttribute("status", status);
        return "return";
    }
}
