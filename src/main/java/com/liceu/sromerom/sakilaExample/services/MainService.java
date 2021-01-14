package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.*;
import com.liceu.sromerom.sakilaExample.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class MainService {
    @Autowired
    FilmRepo filmRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    InventoryRepo inventoryRepo;

    @Autowired
    StaffRepo staffRepo;

    @Autowired
    RentalRepo rentalRepo;

    @Autowired
    PaymentRepo paymentRepo;

    public List<Film> findAllFilms() {
        return filmRepo.findAll();
    }

    public double getRentalDate(long filmid) {
        return filmRepo.getRentalRate(filmid);
    }


    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    public List<Customer> getCustomerWithOverdueDVD() {
        return customerRepo.getCustomerWithOverdue();
    }

    public boolean isInventoryStock(long inventoryid) {
        return inventoryRepo.isInventoryInStock(inventoryid);
    }

    public List<Inventory> findAllInventories() {
        return inventoryRepo.findAll();
    }


    public Inventory getInventoryWithRequiredFilm(long filmid, long storeid) {
        List<Inventory> inventoriesWithRequiredFilm = inventoryRepo.findAllInventoriesByStoreAndFilm(filmid, storeid);
        for (Inventory i : inventoriesWithRequiredFilm) {
            boolean stock = isInventoryStock(i.getInventory_id());
            if (stock) return i;
        }

        return null;
    }

    public Inventory getInventoryRentedByCustomer(long customerid, long filmid) {
        List<Inventory> inventoriesWithSpecificFilm = inventoryRepo.getInventoryRentedByCustomer(customerid, filmid);
        if (inventoriesWithSpecificFilm.size() != 0) {
            return inventoriesWithSpecificFilm.get(inventoriesWithSpecificFilm.size() - 1);
        } else {
            return null;
        }
    }

    public List<Staff> findAllStaff() {
        return staffRepo.findAll();
    }

    public Staff getStaffByStore(long storeid) {
        return staffRepo.getStaffByStore(storeid);
    }

    public List<Rental> findAllRental() {
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

    /*
    public List<Store> findAllStores() {
        return storeRepo.findAll();
    }

    public Store getStoreByStaff(long staffid) {
        return storeRepo.getStoreByStaff(staffid);
    }
     */
    public long getStoreIdFromStaff(long staffid) {
        return staffRepo.getStoreIdFromStaff(staffid);
    }

    public List<Payment> findAllPayments() {
        return paymentRepo.findAll();
    }
    public int paymentProcess(long customerid, long staffid, long rentalid, double amount) {
        LocalDateTime lt = LocalDateTime.now();
        return paymentRepo.paymentProcess(customerid, staffid, rentalid, amount, lt.toString());
    }

}
