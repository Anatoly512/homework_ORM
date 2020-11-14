package com.anatoly.bondarenko.domain;

import lombok.Data;

import java.util.Date;

@Data
public class DevelopersProjects {

    private String name;
    private Integer amountOfDevelopers;
    private Date date;

    public DevelopersProjects(String name, Integer amountOfDevelopers) {
        this.name = name;
        this.amountOfDevelopers = amountOfDevelopers;
    }

    public DevelopersProjects(String name, Integer amountOfDevelopers, Date date) {
        this.name = name;
        this.amountOfDevelopers = amountOfDevelopers;
        this.date = date;
    }

    DevelopersProjects() {
    }





}
