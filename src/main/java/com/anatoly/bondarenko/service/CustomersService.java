package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.CustomersDAO;
import com.anatoly.bondarenko.domain.Customers;

import java.sql.SQLException;
import java.util.List;


public class CustomersService {

    private final CustomersDAO customersDAO;


    public CustomersService(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }




}
