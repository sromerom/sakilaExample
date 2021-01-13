package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Rental;
import com.liceu.sromerom.sakilaExample.repos.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentallService {
    @Autowired
    RentalRepo rentalRepo;

    public List<Rental> findAll() {
        return rentalRepo.findAll();
    }

    public int rentDVD(long inventoryid, long customerid, long staffid) {
        LocalDateTime lt = LocalDateTime.now();
        return rentalRepo.rent(lt.toString(), inventoryid, customerid, staffid);
    }

    public long isRentByCustomer(long inventoryid, long customerid) {
        return rentalRepo.getRentalByInventoryAndCustomer(inventoryid, customerid).getRental_id();
    }

    public int returnDVD(long rentalid) {
        LocalDateTime lt = LocalDateTime.now();
        return rentalRepo.returnDVD(lt.toString(), rentalid);
    }
}
