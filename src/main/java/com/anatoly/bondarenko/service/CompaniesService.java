package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.CompaniesDAO;
import com.anatoly.bondarenko.domain.Companies;

import java.sql.SQLException;
import java.util.List;

public class CompaniesService {


    private final CompaniesDAO companiesDAO;


    public CompaniesService(CompaniesDAO companiesDAO) {
        this.companiesDAO = companiesDAO;
    }



    public void create(Companies company){
        companiesDAO.save(company);
    }

    public void update(Companies company, Long id){
        companiesDAO.update(company,id);
    }

    public void delete(Long id) { companiesDAO.remove(id); }


    public List<Companies> findAll(){
        return companiesDAO.getAll();
    }

    public Companies findById(Long id) { return companiesDAO.getById(id);}



}
