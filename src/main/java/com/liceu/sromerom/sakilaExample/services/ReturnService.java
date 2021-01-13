package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.*;
import com.liceu.sromerom.sakilaExample.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReturnService {
    @Autowired
    FilmRepo filmRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    InventoryRepo inventoryRepo;


    @Autowired
    RentalRepo rentalRepo;


    public List<Film> findAllFilms() {
        return filmRepo.findAll();
    }

    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    public Inventory getInventoryRentedByCustomer(long customerid, long filmid) {
        List<Inventory> inventoriesWithSpecificFilm = inventoryRepo.getInventoryRentedByCustomer(customerid, filmid);

        return inventoriesWithSpecificFilm.get(inventoriesWithSpecificFilm.size() - 1);
    }

    public long isRentByCustomer(long inventoryid, long customerid) {
        return rentalRepo.getRentalByInventoryAndCustomer(inventoryid, customerid).getRental_id();
    }

    public int returnDVD(long rentalid) {
        LocalDateTime lt = LocalDateTime.now();
        return rentalRepo.returnDVD(lt.toString(), rentalid);
    }

}
