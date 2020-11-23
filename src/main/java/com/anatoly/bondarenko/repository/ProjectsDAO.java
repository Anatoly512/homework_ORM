package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.Projects;
import lombok.Data;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO extends GenericDAO <Projects, Long> {

// String.format("UPDATE projects SET projects_name = '%s', cost = '%s', date = '%s' WHERE id = '%d'", projects.getProjectsName(), projects.getCost(),  projects.getDate(), id);

// String.format("INSERT INTO projects (id, projects_name, cost, date) VALUES ('%s', '%s', '%s', '%s')", projects.getId(), projects.getProjectsName(), projects.getCost(), projects.getDate());


    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Projects entityFromDb = entityManager.find(Projects.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public Projects getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Projects entityFromDb = entityManager.find(Projects.class, id);
        entityManager.close();

        return entityFromDb;
    }


    @Override
    public List<Projects> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Projects> entities = entityManager.createNativeQuery("SELECT * FROM projects").getResultList();
        entityManager.close();
        return entities;
    }


    public List<Projects> getProjectsFromDB(){
        EntityManager entityManager = getEntityManager();
        List<Projects> projects = entityManager.createNativeQuery("select p.date, p.name, count(pd.developer_id) from projects p join developers_projects pd on p.projects_id = pd.project_id group by pd.project_id").getResultList();
        entityManager.close();

        return projects;
    }



    @Override
    protected String getTableName() {
        return "projects";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
