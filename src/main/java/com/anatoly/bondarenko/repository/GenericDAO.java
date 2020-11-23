package com.anatoly.bondarenko.repository;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;


public abstract class GenericDAO <K> {

    public Logger logger = LoggerFactory.getLogger("Logger");

    @Getter
    EntityManager entityManager;


    GenericDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ORM homework");
        entityManager = entityManagerFactory.createEntityManager();
    }







    protected abstract String createQueryForUpdate(Long id, K value);

    protected abstract String createQuery(K value);

    protected abstract List<K> convertToList(ResultSet resultSet);






    protected abstract String getTableName();

    protected abstract String getColumnId();



}