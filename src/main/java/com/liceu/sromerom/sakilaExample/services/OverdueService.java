package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.OverdueDVD;
import com.liceu.sromerom.sakilaExample.repos.OverdueDVDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverdueService {
    @Autowired
    OverdueDVDRepo overdueDVDRepo;


    public List<OverdueDVD> findAll() {
        return overdueDVDRepo.findAll();
    }
}
