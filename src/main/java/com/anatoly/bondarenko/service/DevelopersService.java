package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.DevelopersDAO;
import com.anatoly.bondarenko.domain.Developers;

import java.math.BigDecimal;
import java.util.List;

public class DevelopersService {

    private final DevelopersDAO developersDAO;


    public DevelopersService(DevelopersDAO developersDAO) {
        this.developersDAO = developersDAO;
    }



    public List<Developers> getDevelopersBySkill(String language) {
        return developersDAO.getDevelopersBySkill(language);
    }


    public void create(Developers developer){
        developersDAO.save(developer);
    }

    public void update(Developers developer, Long id){
        developersDAO.update(developer, id);
    }

    public void delete(Long id){ developersDAO.remove(id); }



    public Developers findById(Long id) { return developersDAO.getById(id);}

    public List<Developers> findAll(){
        return developersDAO.getAll();
    }




    public List<BigDecimal> sumOfSalary(Long id){ return developersDAO.getSumSalaryOfDevelopers(id);}

    public List<Developers> getDevelopersFromProject(Long id){ return developersDAO.getAllDevelopersFromProject(id);}

    public List<Developers> getDevelopersByLevel(String level){ return developersDAO.getDevelopersBySkillOfLanguage(level);}



}
