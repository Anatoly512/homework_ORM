package com.anatoly.bondarenko.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectsResults {

    private Date date;

    private String projectsName;

    private Integer amountOfDevelopers;


    public ProjectsResults(Date date, String projectsName, Integer amountOfDevelopers) {         //  PUBLIC  !!!!!!!!
                                                                                                 //  иначе не будет доступа к конструктору !!!
        this.date = date;
        this.projectsName = projectsName;
        this.amountOfDevelopers = amountOfDevelopers;

    }




}


