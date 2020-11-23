package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.CustomersDAO;
import com.anatoly.bondarenko.domain.Customers;

import java.util.List;

public class CustomersService {

    private final CustomersDAO customersDAO;


    public CustomersService(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }


    public void create(Customers customer){
        customersDAO.save(customer);
    }

    public void update(Customers customer, Long id){
        customersDAO.update(customer, id);
    }

    public void delete(Long id) { customersDAO.remove(id); }



    public List<Customers> findAll(){
        return customersDAO.getAll();
    }

    public Customers findById(Long id) { return customersDAO.getById(id);}




}
