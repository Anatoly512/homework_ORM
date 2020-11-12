package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.Gender;
import lombok.Data;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


@Data
public class DevelopersDAO extends GenericDAO <Developers> {

    @Override
    protected String createQueryForUpdate(Long id, Developers developers) {
        return String.format("UPDATE developers SET name = '%s', gender = '%s', age = '%d', salary = '%s' WHERE id = '%d'", developers.getName(), developers.getGender(), developers.getAge(), developers.getSalary(), id);
    }


    @Override
    protected String createQuery(Developers developers) {
        return String.format("INSERT INTO developers (id, name, gender, age, salary) VALUES ('%d', '%s', '%s', '%s', '%s')", developers.getId(), developers.getName(), developers.getGender(), developers.getAge(), developers.getSalary());
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

      //  String query = (String.format(" SELECT * FROM developers_skills ds INNER JOIN developers d ON ds.developers_id = d.id INNER JOIN skills s ON ds.skills_id = s.id WHERE s.language = '%s'", language));

        String query = (String.format(" SELECT * FROM developers"));


        List<Developers> developers = entityManager.createNativeQuery(" SELECT * FROM developers").getResultList();


        System.out.println("number of developers = " + developers.size());
        System.out.println(developers);

        if (developers.isEmpty()) {
            return new ArrayList<>();
        }


/*
        for (Developers d : developers) {
            System.out.println("Developer "
                    + d.getId()
                    + " "
                    + d.getName());
        }
*/



/*
        new Configuration().configure().buildSessionFactory().getCurrentSession();
        Query query2 = createSQLQuery(query).addEntity(Developers.class);

*/



        //   List<Object[]> rows = query.list();

/*

        for(Developers row : developers) {
            Developers developer2 = new Developers();

         //   developer2.setId     (Long.valueOf(row[0].toString()));
            developer2.setId(Long.valueOf(developers.get(0).toString()));
            developer2.setName(String.valueOf(developers.get(1).toString()));
            developer2.setGender(Gender.valueOf(developers.get(2).toString()));
            developer2.setAge(Integer.valueOf(developers.get(3).toString()));
            developer2.setSalary(BigDecimal.valueOf(Long.parseLong(developers.get(4).toString())));

            System.out.println(developer2.toString());
        }
*/


/*
        for (Iterator<Developers> it = developers.iterator(); it.hasNext();) {
            Developers developer = (Developers) it.next();
            System.out.println(developer.toString());
        }
*/



      ////  Solve the problem of duplicated sql alias [id]
      //  SELECT t.id , b.id FROM table AS t INNER JOIN bench AS b ON (t.bench_id = b.id) INNER JOIN window AS w ON (t.window_id = w.id)

      //       The select clause did not have unique alias for t.id and b.id. I fixed it by having unique alias as below.

      //  SELECT t.id as table_id, b.id as bench_id FROM table AS t INNER JOIN bench AS b ON (t.bench_id = b.id) INNER JOIN window AS w ON (t.window_id = w.id) INNER JOIN seat AS s ON (s.id = w.target_id)


        System.out.println(developers);

        entityManager.close();

        return developers;
    }




/*  //  Backup Query
    public List<Developers> getDevelopersBySkill(String language){
        EntityManager entityManager = getEntityManager();
        List<Developers> developers = entityManager.createNativeQuery(String.format(" SELECT * FROM developers_skills ds INNER JOIN developers d ON ds.developers_id = d.id INNER JOIN skills s ON ds.skills_id = s.id WHERE s.language = '%s' ", language)).getResultList();
        entityManager.close();

        return developers;
    }
*/



    @Override
    protected String getTableName() {
        return "developers";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
