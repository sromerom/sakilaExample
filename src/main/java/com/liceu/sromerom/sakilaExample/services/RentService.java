package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.*;
import com.liceu.sromerom.sakilaExample.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentService {
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

    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    public List<Staff> findAllStaff() {
        return staffRepo.findAll();
    }

    public short rentDVD(Long filmid, Long customerid, Long staffid) {
        //status = -1, Ha ocurregut un error
        //status = 0, Ha anat correctament
        //status = 1, No ha trobat inventori disponible
        short status = -1;
        LocalDateTime lt = LocalDateTime.now();
        if (filmid != null && customerid != null && staffid != null) {
            //Conseguir storeid;
            Long storeid = staffRepo.getStoreIdFromStaff(staffid);
            //Inventory inventory = inventoryRepo.getInventoryWithRequiredFilm(filmid, storeid);
            List<Inventory> inventoriesWithRequiredFilm = inventoryRepo.findAllInventoriesByStoreAndFilm(filmid, storeid);
            Inventory inventory = checkInventories(inventoriesWithRequiredFilm);
            if (inventory != null) {
                //Cream el registre a la taula rental
                rentalRepo.rent(lt.toString(), inventory.getInventory_id(), customerid, staffid);

                //Aconseguim quan costa la pelicula seleccionada
                double amount = filmRepo.getRentalRate(filmid);

                //Aconseguim el rentalid del registre que s'ha creat fa uns moments
                System.out.println("Inventory ID: " + inventory.getInventory_id());
                System.out.println("Customer ID: " + customerid);
                System.out.println(rentalRepo.getRentalByInventoryAndCustomer(inventory.getInventory_id(), customerid));
                Long rentalid = rentalRepo.getRentalByInventoryAndCustomer(inventory.getInventory_id(), customerid).getRental_id();//inv, date, client

                //Cream la paga a la taula payment
                paymentRepo.paymentProcess(customerid, staffid, rentalid, amount, lt.toString());

                status = 0;
            } else {
                status = 1;
            }
        }
        return status;
    }

    private Inventory checkInventories(List<Inventory> inventories) {
        for (Inventory i : inventories) {
            boolean stock = inventoryRepo.isInventoryInStock(i.getInventory_id());
            if (stock) return i;
        }
        return null;
    }
}
