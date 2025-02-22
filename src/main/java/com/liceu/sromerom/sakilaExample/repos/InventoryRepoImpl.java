package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryRepoImpl implements InventoryRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Inventory> findAll() {
        return jdbcTemplate.query("SELECT * FROM inventory", new BeanPropertyRowMapper<>(Inventory.class));
    }

    @Override
    public List<Inventory> findAllInventoriesByStoreAndFilm(long filmid, long storeid) {
        return jdbcTemplate.query(
                "SELECT * FROM inventory WHERE film_id = ? AND store_id = ?",
                new BeanPropertyRowMapper<>(Inventory.class),
                filmid, storeid);
    }

    @Override
    public boolean isInventoryInStock(long inventoryid) {
        SimpleJdbcCall jdbcCall = new
                SimpleJdbcCall(jdbcTemplate).withFunctionName("inventory_in_stock");
        SqlParameterSource in = new MapSqlParameterSource().addValue("p_inventory_id", inventoryid);
        return jdbcCall.executeFunction(Boolean.class, in);
    }

    @Override
    public List<Inventory> getInventoriesRentedByCustomerAndFilm(long customerid, long filmid) {
        // SELECT inventory.inventory_id, inventory.film_id, inventory.store_id, inventory.last_update FROM rental INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id WHERE rental.customer_id = 10 AND inventory.film_id = 10 AND return_date IS NULL;
        String query = "SELECT inventory.inventory_id, inventory.film_id, inventory.store_id, inventory.last_update FROM rental INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id WHERE rental.customer_id = ? AND inventory.film_id = ? AND return_date IS NULL";
        return jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(Inventory.class),
                customerid, filmid);
    }


}
