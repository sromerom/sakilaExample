package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Store;
import com.liceu.sromerom.sakilaExample.repos.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    StoreRepo storeRepo;

    public List<Store> findAll() {
        return storeRepo.findAll();
    }

    public Store getStoreByStaff(long staffid) {
        return storeRepo.getStoreByStaff(staffid);
    }
}
