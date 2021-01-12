package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Inventory;

import java.util.List;

public interface InventoryRepo {
    List<Inventory> findAll();
    List<Inventory> findAllInventoriesByFilmId(long filmid);
    boolean isInventoryInStock(long inventoryid);
    List<Inventory> getInventoryRentedByCustomer(long customerid, long filmid);

}
