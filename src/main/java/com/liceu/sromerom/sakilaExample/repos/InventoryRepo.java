package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Inventory;

import java.util.List;

public interface InventoryRepo {
    List<Inventory> findAll();
    List<Inventory> findAllInventoriesByStoreAndFilm(long filmid, long storeid);
    boolean isInventoryInStock(long inventoryid);
    List<Inventory> getInventoriesRentedByCustomerAndFilm(long customerid, long filmid);

}
