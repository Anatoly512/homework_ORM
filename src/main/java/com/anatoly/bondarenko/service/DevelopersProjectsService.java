package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.DevelopersProjectsDAO;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.DevelopersProjects;

import java.util.List;

public class DevelopersProjectsService {

    private final DevelopersProjectsDAO developersProjectsDAO;


    public DevelopersProjectsService(DevelopersProjectsDAO developersProjectsDAO) {
        this.developersProjectsDAO = developersProjectsDAO;
    }




}
