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





}
