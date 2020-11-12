package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.SkillsDAO;
import com.anatoly.bondarenko.domain.Skills;

import java.sql.SQLException;
import java.util.List;

public class SkillsService {

    private final SkillsDAO skillsDAO;


    public SkillsService(SkillsDAO skillsDAO) {
        this.skillsDAO = skillsDAO;
    }




}
