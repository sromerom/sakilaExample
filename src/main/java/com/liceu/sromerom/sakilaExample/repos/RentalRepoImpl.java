package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalRepoImpl implements RentalRepo{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Rental> findAll() {
        return jdbcTemplate.query("SELECT * FROM rental", new BeanPropertyRowMapper<>(Rental.class));
    }

    @Override
    public int rent(String rentaldate, long inventoryid, long customerid, long staffid) {
        //INSERT INTO rental(rental_date, inventory_id, customer_id, staff_id) VALUES(NOW(), 10, 3, 1);
        return jdbcTemplate.update(
                "INSERT INTO rental(rental_date, inventory_id, customer_id, staff_id) VALUES(?, ?, ?, ?)", rentaldate, inventoryid, customerid, staffid);
    }

    @Override
    public int returnDVD(String returndate, long rentalid) {
        return jdbcTemplate.update(
                "UPDATE rental SET return_date = ? WHERE rental_id = ?", returndate, rentalid);
    }

    @Override
    public Rental getRentalByInventoryAndCustomer(long inventoryid, long customerid) {
        return jdbcTemplate.queryForObject(
                "SELECT rental_id FROM rental WHERE inventory_id = ? AND customer_id = ? AND return_date IS NULL",
                new Object[]{inventoryid, customerid},
                Rental.class);
    }
}
