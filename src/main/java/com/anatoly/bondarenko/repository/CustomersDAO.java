package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.Customers;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomersDAO extends GenericDAO <Customers, Long> {

// String.format("UPDATE customers SET name = '%s' WHERE id = '%d'", customers.getName(), id);

// String.format("INSERT INTO customers (id, name) VALUES ('%s', '%s')", customers.getId(), customers.getName());


    @Override
    public Customers getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Customers entityFromDb = entityManager.find(Customers.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Customers entityFromDb = entityManager.find(Customers.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Customers> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Customers> entities = (List<Customers>) entityManager.createNativeQuery("SELECT * FROM customers", Customers.class).getResultList();
        entityManager.close();
        return entities;
    }



    @Override
    protected String getTableName() {
        return "customers";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }





}
