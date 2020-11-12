package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.DevelopersDAO;
import com.anatoly.bondarenko.domain.Developers;

import java.util.List;


public class DevelopersService {

    private final DevelopersDAO developersDAO;


    public DevelopersService(DevelopersDAO developersDAO) {
        this.developersDAO = developersDAO;
    }





    public List<Developers> getDevelopersBySkill(String language) {
        return developersDAO.getDevelopersBySkill(language);
    }



}
