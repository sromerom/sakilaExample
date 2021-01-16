package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RentalRepoImpl implements RentalRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Rental> findAll() {
        return jdbcTemplate.query("SELECT * FROM rental", new BeanPropertyRowMapper<>(Rental.class));
    }

    @Override
    public Long rent(String rentaldate, long inventoryid, long customerid, long staffid) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO rental(rental_date, inventory_id, customer_id, staff_id) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, rentaldate);
            ps.setLong(2, inventoryid);
            ps.setLong(3, customerid);
            ps.setLong(4, staffid);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

        /*
        return jdbcTemplate.update(
                "INSERT INTO rental(rental_date, inventory_id, customer_id, staff_id) VALUES(?, ?, ?, ?)", rentaldate, inventoryid, customerid, staffid);
         */

    @Override
    public int returnDVD(String returndate, long rentalid) {
        return jdbcTemplate.update(
                "UPDATE rental SET return_date = ? WHERE rental_id = ?", returndate, rentalid);
    }

    @Override
    public Rental getRentalByInventoryAndCustomer(long inventoryid, long customerid) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM rental WHERE inventory_id = ? AND customer_id = ? AND return_date IS NULL",
                new BeanPropertyRowMapper<>(Rental.class),
                inventoryid, customerid);
    }
}
