package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.*;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DevelopersDAO extends GenericDAO <Developers, Long> {


// String.format("UPDATE developers SET name = '%s', gender = '%s', age = '%d', salary = '%s' WHERE id = '%d'", developers.getName(), developers.getName(), developers.getAge(), developers.getSalary(), id);

// String.format("INSERT INTO developers (id, name, gender, age, salary) VALUES ('%d', '%s', '%s', '%s', '%s')", developers.getId(), developers.getName(), developers.getName(), developers.getAge(), developers.getSalary());


 ///////////////////////////////////////////////////////////


    public List<Developers> getDevelopersBySkill(String language) {

        EntityManager entityManager = getEntityManager();

        List<Developers> developers = entityManager.createNativeQuery(String.format(" SELECT * FROM developers_skills ds INNER JOIN developers d ON ds.developers_id = d.id INNER JOIN skills s ON ds.skills_id = s.id WHERE s.language = '%s'", language), Developers.class).getResultList();

        System.out.println("number of " + language + " developers = " + developers.size());


        for (Developers developer : developers) {
            Long id = developer.getId();
            String name = developer.getName();
            Gender gender = developer.getGender();
            int age = developer.getAge();
            BigDecimal salary = developer.getSalary();

            System.out.print(language + " developer :  ");
            System.out.println(String.format("  id = %d, name = %s, gender = %s, age = %s, salary = %s", id, name, gender, age, salary));
        }


        return developers;
    }



    public List<Developers> getDevelopersBySkillOfLanguage(String level){

        EntityManager entityManager = getEntityManager();

        List<Developers> developers = entityManager.createNativeQuery(String.format("SELECT * FROM developers_skills ds INNER JOIN developers d ON ds.developers_id = d.id INNER JOIN skills s ON ds.skills_id = s.id WHERE s.level = '%s' ORDER BY d.id;", level), Developers.class).getResultList();

        System.out.println("number of " + level + " developers = " + developers.size());


        for (Developers developer : developers) {
            Long id = developer.getId();
            String name = developer.getName();
            Gender gender = developer.getGender();
            int age = developer.getAge();
            BigDecimal salary = developer.getSalary();

            System.out.println(String.format("  id = %d, name = %s, gender = %s, age = %s, salary = %s", id, name, gender, age, salary));
        }


        return developers;
    }




    public List<Developers>  getAllDevelopersFromProject(Long id){
        EntityManager entityManager = getEntityManager();
        List<Developers> developers = entityManager.createNativeQuery(String.format("SELECT * FROM developers_projects as dp JOIN developers as d on dp.developers_id = d.id WHERE projects_id = '%s'", id), Developers.class).getResultList();

        return developers;
    }



    public List<BigDecimal> getSumSalaryOfDevelopers(Long id){
        EntityManager entityManager = getEntityManager();
        List<BigDecimal> sum = (List<BigDecimal>) entityManager.createNativeQuery(String.format("SELECT sum(salary) FROM developers_projects dp INNER JOIN projects p on dp.projects_id = p.id INNER JOIN developers as d on dp.developers_id = d.id WHERE p.id = %d", id)).getResultList();

        return sum;
    }




    public List<ProjectsResults> getAllProjectsAndItsAmountOfDevelopers() {

        EntityManager entityManager = getEntityManager();
        List<Objects> array = new ArrayList<Objects>();

        List<ProjectsResults> results = new ArrayList<>();
        System.out.println();

    try {

        // results = (List<ProjectsResults>) entityManager.createNativeQuery(String.format("SELECT p.date AS pdt, p.projects_name AS pnm, count(dp.developers_id) AS c FROM projects AS p INNER JOIN developers_projects AS dp ON p.id = dp.projects_id GROUP BY pnm"), ProjectsResults.class).getResultList();

        // results = entityManager.createNamedQuery("DevelopersOnProject", ProjectsResults.class).getResultList();

        results = entityManager.createNamedQuery("DevelopersOnProject", ProjectsResults.class).getResultList();

        System.out.println(results);

/*

            for (ProjectsResults project : results) {
                Date date = project.getDate();
                String name = project.getProjectsName();
             // Integer amountOfDevelopers = project.getAmountOfDevelopers();

                System.out.println(String.format("  Date = %s, Name = %s", date, name));
            }
*/


/*
            while(resultSet.next()){
                Date date = resultSet.getDate("pdt");
                String name = resultSet.getString("pn");
                Integer amountOfDevelopers = resultSet.getInt("c");
                projectsDevelopers.add(new DevelopersProjects(name, amountOfDevelopers, date));
            }
*/



        }

        catch (Exception exception){
            System.out.println("Error message : " + exception);
        }


        System.out.println(results);

        return results;

    }




    @Override
    public Developers getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Developers entityFromDb = entityManager.find(Developers.class, id);

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Developers entityFromDb = entityManager.find(Developers.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Developers> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Developers> entities = (List<Developers>) entityManager.createNativeQuery("SELECT * FROM developers", Developers.class).getResultList();

        return entities;
    }






    @Override
    protected String getTableName() {
        return "developers";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
