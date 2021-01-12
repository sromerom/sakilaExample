package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Staff;
import com.liceu.sromerom.sakilaExample.repos.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffRepo staffRepo;

    public List<Staff> findAll() {
        return staffRepo.findAll();
    }

    public Staff getStaffByStore(long storeid) {
        return staffRepo.getStaffByStore(storeid);
    }
}
