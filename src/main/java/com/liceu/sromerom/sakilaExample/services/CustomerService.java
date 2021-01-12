package com.liceu.sromerom.sakilaExample.services;

import com.liceu.sromerom.sakilaExample.entities.Customer;
import com.liceu.sromerom.sakilaExample.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
