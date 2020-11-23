package com.anatoly.bondarenko.repository;

import com.anatoly.bondarenko.domain.Skills;

import javax.persistence.EntityManager;
import java.util.List;


public class SkillsDAO extends GenericDAO <Skills, Long> {

//  String.format("UPDATE skills SET language = '%s', level = '%s' WHERE id = '%d'", skills.getLanguage(), skills.getSkillLevel(), id);

//  String.format("INSERT INTO skills (id, language, level) VALUES ('%s', '%s', '%s')", skills.getId(), skills.getLanguage(), skills.getSkillLevel());


    @Override
    public Skills getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Skills entityFromDb = entityManager.find(Skills.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Skills entityFromDb = entityManager.find(Skills.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Skills> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Skills> entities = entityManager.createNativeQuery("SELECT * FROM skills", Skills.class).getResultList();
        entityManager.close();
        return entities;
    }



    @Override
    protected String getTableName() {
        return "skills";
    }


    @Override
    protected String getColumnId() {
        return "id";
    }



}
