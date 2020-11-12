package com.anatoly.bondarenko.service;

import com.anatoly.bondarenko.repository.ProjectsDAO;
import com.anatoly.bondarenko.domain.Projects;

import java.sql.SQLException;
import java.util.List;

public class ProjectsService {

    private final ProjectsDAO projectsDAO;


    public ProjectsService(ProjectsDAO projectsDAO) {
        this.projectsDAO = projectsDAO;
    }





}
