package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.Companies;

import javax.persistence.EntityManager;
import java.util.List;

public class CompaniesDAO extends GenericDAO <Companies, Long> {

//  String.format("UPDATE companies SET company_name = '%s' WHERE id = '%d'", companies.getCompanyName(), id);

//  String.format("INSERT INTO companies (id, company_name) VALUES ('%s', '%s')", companies.getId(), companies.getCompanyName());



    @Override
    public Companies getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Companies entityFromDb = entityManager.find(Companies.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Companies entityFromDb =entityManager.find(Companies.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Companies> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Companies> entities = entityManager.createNativeQuery("SELECT * FROM companies").getResultList();
        entityManager.close();
        return entities;
    }





    @Override
    protected String getTableName() {
        return "companies";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
