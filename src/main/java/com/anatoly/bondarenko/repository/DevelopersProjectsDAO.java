package com.anatoly.bondarenko.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevelopersProjectsDAO {



/*

    public List<DevelopersProjects> findProjectAndAmountOfDevelopers(Long id) {
        List<DevelopersProjects> projectsDevelopers = new ArrayList<>();
        String name = "";
        int amount = 0;

        String queryForProjects = String.format("SELECT projects_name FROM projects p INNER JOIN developers_projects dp ON p.id = dp.projects_id WHERE p.id = '%s' ORDER BY dp.projects_id", id);
        System.out.println("\n" + queryForProjects);

        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForProjects);

             while(resultSet.next()){
                name = resultSet.getString("projects_name");
             }

            connection.close();
        }

        catch (SQLException exception){
            System.out.println("Error message : " + exception);
        }


        String queryForAmountOfDevelopers = String.format("SELECT count(developers_id) c FROM projects p INNER JOIN developers_projects dp ON p.id = dp.projects_id WHERE p.id = '%s'", id);
        System.out.println(queryForAmountOfDevelopers);

        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForAmountOfDevelopers);

            while (resultSet.next()) {
              amount = resultSet.getInt("c");
            }

            connection.close();
        }

        catch (SQLException exception){
            System.out.println("Error message : " + exception);
        }

        System.out.println("\nProjects name : " + name);
        System.out.println("Amount of developers : " + amount);

        projectsDevelopers.add(new DevelopersProjects(name, amount));


        BigDecimal sumOfSalary = new BigDecimal(0);

        String queryForSum = String.format("SELECT sum(salary) s FROM developers_projects dp INNER JOIN projects p ON dp.projects_id = p.id INNER JOIN developers d ON dp.developers_id = d.id WHERE p.id = %d ", id);

        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForSum);

            while (resultSet.next()){
                sumOfSalary = resultSet.getBigDecimal("s");
            }

            System.out.println("Sum of all developer's salary : " + sumOfSalary);

            connection.close();
        }

        catch (SQLException exception){
            System.out.println("Error message : " + exception);
        }

        return projectsDevelopers;
    }

*/




}
