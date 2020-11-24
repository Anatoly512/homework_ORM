package com.anatoly.bondarenko;

import com.anatoly.bondarenko.repository.*;
import com.anatoly.bondarenko.service.*;

import java.sql.SQLException;


public class Main {

    private static final DevelopersDAO developersDAO = new DevelopersDAO();
    private static final CompaniesDAO companiesDAO = new CompaniesDAO();
    private static final CustomersDAO customersDAO = new CustomersDAO();
    private static final ProjectsDAO projectsDAO = new ProjectsDAO();
    private static final SkillsDAO skillsDAO = new SkillsDAO();
    private static final DevelopersSkillsDAO developersSkillsDAO = new DevelopersSkillsDAO();
    private static final DevelopersProjectsDAO developersProjectsDAO = new DevelopersProjectsDAO();

    private static final DevelopersService developersService = new DevelopersService(developersDAO);
    private static final CompaniesService companiesService = new CompaniesService(companiesDAO);
    private static final CustomersService customersService = new CustomersService(customersDAO);
    private static final ProjectsService projectsService = new ProjectsService(projectsDAO);
    private static final SkillsService skillsService = new SkillsService(skillsDAO);
    private static final DevelopersSkillsService developersSkillsService = new DevelopersSkillsService(developersSkillsDAO);
    private static final DevelopersProjectsService developersProjectsService = new DevelopersProjectsService(developersProjectsDAO);


    public static void main(String[] args) throws SQLException {

        DisplayAllTasks displayAllTasks = new DisplayAllTasks();
        displayAllTasks.ShowAllTasks();


    }

}
