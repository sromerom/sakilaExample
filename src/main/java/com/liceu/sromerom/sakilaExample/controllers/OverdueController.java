package com.liceu.sromerom.sakilaExample.controllers;

import com.liceu.sromerom.sakilaExample.entities.Customer;
import com.liceu.sromerom.sakilaExample.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OverdueController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/overdue")
    public String getReturn(Model model) {
        List<Customer> customersOverdue = customerService.getCustomerWithOverdueDVD();
        model.addAttribute("customersOverdue", customersOverdue);
        return "overdue";
    }
}
