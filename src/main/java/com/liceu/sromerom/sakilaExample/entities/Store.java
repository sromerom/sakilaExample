package com.liceu.sromerom.sakilaExample.entities;

import java.time.LocalDateTime;

public class Store {
    private long store_id;
    private long manager_staff_id;
    private long address_id;
    private LocalDateTime last_update;


    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public long getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(long manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

    public long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(long address_id) {
        this.address_id = address_id;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Store{" +
                "store_id=" + store_id +
                ", manager_staff_id=" + manager_staff_id +
                ", address_id=" + address_id +
                ", last_update=" + last_update +
                '}';
    }
}
