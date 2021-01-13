package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Inventory;
import com.liceu.sromerom.sakilaExample.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepoImpl implements StoreRepo{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Store> findAll() {
        return jdbcTemplate.query("SELECT * FROM store", new BeanPropertyRowMapper<>(Store.class));
    }

    @Override
    public Store getStoreByStaff(long staffid) {
        return jdbcTemplate.query(
                "SELECT * FROM staff WHERE staff_id = ?",
                new Object[]{staffid},
                new BeanPropertyRowMapper<>(Store.class)).get(0);
    }
}
