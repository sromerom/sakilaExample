package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Rental;
import com.liceu.sromerom.sakilaExample.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepoImpl implements StaffRepo{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Staff> findAll() {
        return jdbcTemplate.query("SELECT * FROM staff", new BeanPropertyRowMapper<>(Staff.class));
    }

    @Override
    public Staff getStaffByStore(long storeid) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM staff WHERE store_id = ?",
                new Object[]{storeid},
                Staff.class);
    }
}
