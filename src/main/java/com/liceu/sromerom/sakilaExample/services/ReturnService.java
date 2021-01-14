package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Customer;
import com.liceu.sromerom.sakilaExample.entities.Film;
import com.liceu.sromerom.sakilaExample.entities.Inventory;
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

    public short returnDVD(Long filmid, Long customerid) {
        //status = -1, Ha ocurregut un error
        //status = 0, Ha anat correctament
        //status = 1, No ha trobat inventori disponible
        short status = -1;
        LocalDateTime lt = LocalDateTime.now();
        if (filmid != null && customerid != null) {
            //Aconseguim en quin inventori esta rentat el film seleccionat amb l'usuari seleccionat
            List<Inventory> inventoriesWithSpecificFilm = inventoryRepo.getInventoryRentedByCustomer(customerid, filmid);
            Inventory inventory;
            if (inventoriesWithSpecificFilm.size() != 0) {
                inventory = inventoriesWithSpecificFilm.get(inventoriesWithSpecificFilm.size() - 1);
            } else {
                inventory = null;
            }

            //Si no hi ha inventori retornarem
            if (inventory != null) {
                //Aconseguim en rentalid amb el que ha sigut rentada, per poder modificar-la i poder retornar-la.
                // Si es dona el cas que no hi troba cap, voldra dir que el client no te rentada la pelicula seleccionada.
                //Long rentalid = mainService.isRentByCustomer(inventory.getInventory_id(), customerid);
                Long rentalid = rentalRepo.getRentalByInventoryAndCustomer(inventory.getInventory_id(), customerid).getRental_id();
                if (rentalid != null) {
                    //I feim el proces de retornada de la pelicula
                    rentalRepo.returnDVD(lt.toString(), rentalid);
                    status = 0;
                }
            } else {
                status = 1;
            }
        }
        return status;
    }
}
