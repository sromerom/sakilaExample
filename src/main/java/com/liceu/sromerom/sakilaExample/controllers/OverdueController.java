package com.liceu.sromerom.sakilaExample.controllers;


import com.liceu.sromerom.sakilaExample.entities.OverdueDVD;
import com.liceu.sromerom.sakilaExample.services.OverdueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OverdueController {
    @Autowired
    OverdueService overdueService;

    @GetMapping("/overdue")
    public String getReturn(Model model) {
        List<OverdueDVD> customersOverdue = overdueService.findAll();
        model.addAttribute("customersOverdue", customersOverdue);
        return "overdue";
    }
}
