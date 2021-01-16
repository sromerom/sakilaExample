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

    //status = -1, Ha ocurregut un error
    //status = 0, Ha anat correctament
    //status = 1, No ha trobat inventori disponible
    public short rentDVD(Long filmid, Long customerid, Long staffid) {
        short status = -1;
        LocalDateTime lt = LocalDateTime.now();
        if (filmid != null && customerid != null && staffid != null) {
            //Conseguir storeid;
            Long storeid = staffRepo.getStoreIdByStaff(staffid);

            //A partir de la pelicula y de la store, agafam tots els inventaris que compleixin amb aquests requisits
            List<Inventory> inventoriesWithRequiredFilm = inventoryRepo.findAllInventoriesByStoreAndFilm(filmid, storeid);

            //Agafam el primer disponible, que no estigui rentat previament
            Inventory inventory = checkInventories(inventoriesWithRequiredFilm);

            //Si no hi troba cap inventory, voldra dir que no hi cap inventory disponible per rentar
            if (inventory != null) {
                //Cream el registre a la taula rental. Al mateix temps que feim aixo, rebrem el rentalid amb el que se ha creat el registre
                Long rentalid = rentalRepo.rent(lt.toString(), inventory.getInventory_id(), customerid, staffid);

                //Aconseguim quan costa la pelicula seleccionada
                double amount = filmRepo.getRentalRate(filmid);

                //Cream la paga a la taula payment
                paymentRepo.paymentProcess(customerid, staffid, rentalid, amount, lt.toString());

                //I indicam que tot ha sortit correctament
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
