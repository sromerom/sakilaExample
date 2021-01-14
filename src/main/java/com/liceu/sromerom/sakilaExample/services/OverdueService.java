package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.OverdueDVD;
import com.liceu.sromerom.sakilaExample.repos.OverdueDVDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class OverdueService {
    @Autowired
    OverdueDVDRepo overdueDVDRepo;


    public List<OverdueDVD> findAll() {
        List<OverdueDVD> overdueDVDS = overdueDVDRepo.findAll();

        LocalDateTime today =  LocalDateTime.now();     //Today
        LocalDateTime tomorrow = today.plusDays(1);     //Plus 1 day
        LocalDateTime yesterday = today.minusDays(1);   //Minus 1 day

        System.out.println(today);          //2018-07-14
        System.out.println(tomorrow);       //2018-07-15
        System.out.println(yesterday);      //2018-07-13
        return overdueDVDRepo.findAll();
    }
}
