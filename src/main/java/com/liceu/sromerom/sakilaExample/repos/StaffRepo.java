package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Staff;

import java.util.List;

public interface StaffRepo {
    List<Staff> findAll();
    Long getStoreIdByStaff(long staffid);
}
