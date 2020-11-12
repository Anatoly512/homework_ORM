package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.DevelopersDAO;
import com.anatoly.bondarenko.domain.Developers;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class DevelopersService {

    private final DevelopersDAO developersDAO;


    public DevelopersService(DevelopersDAO developersDAO) {
        this.developersDAO = developersDAO;
    }





    public List<Developers> getDevelopersBySkill(String language) {
        return developersDAO.getDevelopersBySkill(language);
    }



}
