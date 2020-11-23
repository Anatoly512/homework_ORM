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


    public void create(Projects project){
        projectsDAO.save(project);
    }

    public void update(Projects project, Long id){
        projectsDAO.update(project, id);
    }

    public void delete(Long id) { projectsDAO.remove(id); }


    public List<Projects> findAll(){
        return projectsDAO.getAll();
    }

    public Projects findById(Long id) { return projectsDAO.getById(id);}


    public List<Projects> getProjectFromDB() { return projectsDAO.getProjectsFromDB(); }



}
