package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.SkillsDAO;
import com.anatoly.bondarenko.domain.Skills;

import java.util.List;

public class SkillsService {

    private final SkillsDAO skillsDAO;


    public SkillsService(SkillsDAO skillsDAO) {
        this.skillsDAO = skillsDAO;
    }


    public void create(Skills skill){
        skillsDAO.save(skill);
    }

    public void update(Skills skill, Long id){
        skillsDAO.update(skill, id);
    }

    public void delete(Long id){ skillsDAO.remove(id); }


    public List<Skills> findAll(){
        return skillsDAO.getAll();
    }

    public Skills findById(Long id){ return skillsDAO.getById(id);}



}



