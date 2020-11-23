package com.anatoly.bondarenko.repository;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class GenericDAO <K, ID> {

    public Logger logger = LoggerFactory.getLogger("Logger");

    @Getter
    EntityManager entityManager;


    GenericDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ORM homework");
        entityManager = entityManagerFactory.createEntityManager();
    }




    public void save(K k){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(k);
        entityManager.getTransaction().commit();
        entityManager.close();
    }



    public void update(K k, ID id){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        K entityFromDb = (K) entityManager.find(Object.class, id);
        entityManager.merge(k);
        entityManager.persist(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();

    }



    public abstract K getById(ID id);

    public abstract void remove(ID id);

    public abstract List<K> getAll();




    protected abstract String getTableName();

    protected abstract String getColumnId();


}