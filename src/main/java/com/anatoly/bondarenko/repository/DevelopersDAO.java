package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class DevelopersDAO extends GenericDAO <Developers, Long> {


// String.format("UPDATE developers SET name = '%s', gender = '%s', age = '%d', salary = '%s' WHERE id = '%d'", developers.getName(), developers.getName(), developers.getAge(), developers.getSalary(), id);

// String.format("INSERT INTO developers (id, name, gender, age, salary) VALUES ('%d', '%s', '%s', '%s', '%s')", developers.getId(), developers.getName(), developers.getName(), developers.getAge(), developers.getSalary());


 ///////////////////////////////////////////////////////////


    public List<Developers> getDevelopersBySkill(String language) {

        EntityManager entityManager = getEntityManager();

        List<Developers> developers = entityManager.createNativeQuery(String.format(" SELECT * FROM developers_skills ds INNER JOIN developers d ON ds.developers_id = d.id INNER JOIN skills s ON ds.skills_id = s.id WHERE s.language = '%s'", language), Developers.class).getResultList();

        System.out.println("number of " + language + " developers = " + developers.size());
//      System.out.println(developers);


        for (Developers developer : developers) {
            Long id = developer.getId();
            String name = developer.getName();
            Gender gender = developer.getGender();
            int age = developer.getAge();
            BigDecimal salary = developer.getSalary();

            System.out.print(language + " developer :  ");
            System.out.println(String.format("  id = %d, name = %s, gender = %s, age = %s, salary = %s", id, name, gender, age, salary));
        }

    //    entityManager.close();

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


///////////////////////////////////////////////////////////////////////////////////



    public List<Developers>  getAllDevelopersFromProject(Long id){
        EntityManager entityManager = getEntityManager();
        List<Developers> developers = entityManager.createNativeQuery("SELECT * FROM developers_projects as dp JOIN developers as d on dp.developer_id = d.developers_id WHERE project_id = " + id, Developers.class).getResultList();
        entityManager.close();
        return developers;
    }



    public List<BigDecimal> getSumSalaryOfDevelopers(Long id){
        EntityManager entityManager = getEntityManager();
        List<BigDecimal> sum = entityManager.createNativeQuery(String.format("SELECT sum(salary) FROM developers_projects pd inner join projects p on pd.project_id = p.project_id inner join developers d on pd.developer_id = d.developers_id where p.project_id = %d", id), BigDecimal.class).getResultList();
        entityManager.close();

        return sum;
    }







    @Override
    public Developers getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Developers entityFromDb = entityManager.find(Developers.class, id);
       // entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Developers entityFromDb = entityManager.find(Developers.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Developers> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Developers> entities = (List<Developers>) entityManager.createNativeQuery("SELECT * FROM developers", Developers.class).getResultList();
     //   entityManager.close();
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
