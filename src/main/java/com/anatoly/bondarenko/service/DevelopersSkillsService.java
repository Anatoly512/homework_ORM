package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.DevelopersSkillsDAO;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.SkillLevel;

import java.util.List;

public class DevelopersSkillsService {

    private final DevelopersSkillsDAO developersSkillsDAO;


    public DevelopersSkillsService(DevelopersSkillsDAO developersSkillsDAO) {
        this.developersSkillsDAO = developersSkillsDAO;
    }




}
