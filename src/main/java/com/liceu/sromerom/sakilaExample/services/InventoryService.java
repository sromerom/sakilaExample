package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Inventory;
import com.liceu.sromerom.sakilaExample.repos.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;

    public boolean isInventoryStock(long inventoryid) {
        return inventoryRepo.isInventoryInStock(inventoryid);
    }

    public List<Inventory> findAll() {
        return inventoryRepo.findAll();
    }


    public Inventory getInventoryWithRequiredFilm(long filmid, long storeid) {
        //List<Inventory> inventoriesWithActualFilm = inventoryRepo.findAllInventoriesByFilmId(filmid);
        List<Inventory> inventoriesWithRequiredFilm = inventoryRepo.findAllInventoriesByStoreAndFilm(filmid, storeid);
        for (Inventory i : inventoriesWithRequiredFilm) {
            boolean stock = isInventoryStock(i.getInventory_id());
            if (stock) return i;
        }

        return null;
    }

    public Inventory getInventoryRentedByCustomer(long customerid, long filmid) {
        return inventoryRepo.getInventoryRentedByCustomer(customerid, filmid).get(0);
    }

}
