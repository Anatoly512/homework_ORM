package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DevelopersDAO extends GenericDAO <Developers> {


    @Override
    protected String createQueryForUpdate(Long id, Developers developers) {
        return String.format("UPDATE developers SET name = '%s', gender = '%s', age = '%d', salary = '%s' WHERE id = '%d'", developers.getName(), developers.getName(), developers.getAge(), developers.getSalary(), id);
    }


    @Override
    protected String createQuery(Developers developers) {
        return String.format("INSERT INTO developers (id, name, gender, age, salary) VALUES ('%d', '%s', '%s', '%s', '%s')", developers.getId(), developers.getName(), developers.getName(), developers.getAge(), developers.getSalary());
    }


    @Override
    protected List<Developers> convertToList(ResultSet resultSet) {
        List<Developers> developers = new ArrayList<>();
        try {
            while (resultSet.next()){
                Developers developerEntity = new Developers();  //  Пустой конструктор.  Получается, поля будут не заполнены (на этом этапе).
                                                                //  Далее поля заполняются через сеттеры в обязательном порядке.
                developerEntity.setId(resultSet.getLong("id"));
                developerEntity.setName(resultSet.getString("name"));
                developerEntity.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
                developerEntity.setAge(resultSet.getInt("age"));
                developerEntity.setSalary(resultSet.getBigDecimal("salary"));
                developers.add(developerEntity);
            }
        }
        catch (SQLException exception){
            logger.info("Exeption SQL: {}", exception.getMessage());
        }

        return developers;
    }


    ///////////////////////////////////////////


    public List<Developers> getDevelopersBySkill(String language){

        EntityManager entityManager = getEntityManager();

        List<Developers> developers = entityManager.createNativeQuery(String.format(" SELECT * FROM developers_skills ds INNER JOIN developers d ON ds.developers_id = d.id INNER JOIN skills s ON ds.skills_id = s.id WHERE s.language = '%s'", language), Developers.class).getResultList();

        System.out.println("number of developers = " + developers.size());
        System.out.println(developers);


        for (Developers developer : developers) {
            Long id = developer.getId();
            String name = developer.getName();
            Gender gender = developer.getGender();
            int age = developer.getAge();
            BigDecimal salary = developer.getSalary();

            System.out.println(String.format("  id = %d, name = %s, gender = %s, age = %s, salary = %s", id, name, gender, age, salary));
        }





        entityManager.close();

        return developers;
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
