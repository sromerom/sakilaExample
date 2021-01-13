package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Rental;

import java.util.List;

public interface RentalRepo {
    List<Rental> findAll();
    int rent(String rentaldate, long inventoryid, long customerid, long staffid);
    int returnDVD(String returndate, long rentalid);
    Rental getRentalByInventoryAndCustomer(long inventoryid, long customerid);
}
