package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Store;

import java.util.List;

public interface StoreRepo {
    List<Store> findAll();
    Store getStoreByStaff(long staffid);
}
