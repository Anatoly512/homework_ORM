package com.anatoly.bondarenko;

import com.anatoly.bondarenko.repository.*;
import com.anatoly.bondarenko.domain.*;
import com.anatoly.bondarenko.service.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@Data
@RequiredArgsConstructor
public class Main {


//    static ShowTables showTables = new ShowTables();          //  Все представления данных вынесены в класс ShowTables

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

    static ProgrammLanguages languages = new ProgrammLanguages();

    public static void main(String[] args) throws SQLException {

/*
        //  Тестовый вывод таблиц в удобном виде
        showTables.displayDevelopers(developersDAO);
        showTables.displayCompanies(companiesDAO);
        showTables.displayCustomers(customersDAO);
        showTables.displayProjects(projectsDAO);
        showTables.displaySkills(skillsDAO);
*/




        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////

        System.out.println("\n  HIBERNATE  TASKS  !!!!!!!!!!!!!!!!!!!!!! \n");
        System.out.println(developersService.getDevelopersBySkill(languages.JAVA));







    }





}
