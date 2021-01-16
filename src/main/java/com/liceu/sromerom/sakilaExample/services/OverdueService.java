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
        return overdueDVDRepo.findAll();
    }
}
