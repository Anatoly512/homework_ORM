package com.anatoly.bondarenko;

import com.anatoly.bondarenko.repository.*;
import com.anatoly.bondarenko.domain.Developers;
import com.anatoly.bondarenko.domain.DevelopersProjects;
import com.anatoly.bondarenko.domain.Gender;
import com.anatoly.bondarenko.domain.SkillLevel;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

import java.sql.*;
import java.util.List;

@ToString
@Data
public class ShowTables {

/*

        public void displayCustomers(CustomersDAO customersDAO) throws SQLException {
            try {
                Connection connection;
                Statement statement;

                connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

                while (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    System.out.println(String.format(" CUSTOMERS:  id = %d, name = %s", id, name));
                }
            } catch (SQLException exception) {
                customersDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
                throw new SQLException(String.valueOf(exception));
            }
            finally {
                System.out.println();
            }

    }


    public void displayProjects(ProjectsDAO projectsDAO) throws SQLException {
        try {
            Connection connection;
            Statement statement;

            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String projectsName = resultSet.getString("projects_name");
                BigDecimal cost = resultSet.getBigDecimal("cost");
                System.out.println(String.format(" PROJECTS:  id = %d, projects name = %s, cost = %s", id, projectsName, cost));
            }
        } catch (SQLException exception) {
            projectsDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new SQLException(String.valueOf(exception));
        } finally {
            System.out.println();
        }

    }


    public void displaySkills(SkillsDAO skillsDAO) throws SQLException {
        try {
            Connection connection;
            Statement statement;

            connection = DriverManager.getConnection(Main.getURL(), Main.getUser(), Main.getPassword());
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM skills");

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String language = resultSet.getString("language");
                String levelString = resultSet.getString("level");
                SkillLevel level = SkillLevel.valueOf(levelString);
                System.out.println(String.format(" SKILLS:  id = %d, language = %s, level = %s", id, language, level));
            }
        } catch (SQLException exception) {
            skillsDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new SQLException(String.valueOf(exception));
        }
        finally {
            System.out.println();
        }

    }

*/




///////////////////////////////////////////////////////
//////////////////////////////////////////////////////

/*

    public void displayEnities(List<Developers> list, String string) {

        for (Developers developer : list) {

            Long id = developer.getId();
            String name = developer.getName();
         //   Gender gender = developer.getGender();
            int age = developer.getAge();
            BigDecimal salary = developer.getSalary();

            System.out.println(String.format(string + " id = %d, name = %s, genger = %s, age = %s, salary = %s", id, name, age, salary));

        }

    }


    //  Перегрузка метода
    public void displayEnities(List<Developers> list) {

        for (Developers developer : list) {

            System.out.println(developer);

            Long id = developer.getId();
            String name = developer.getName();
     //       Gender gender = developer.getGender();
            int age = developer.getAge();
            BigDecimal salary = developer.getSalary();

            System.out.println(String.format("  id = %d, name = %s, genger = %s, age = %s, salary = %s", id, name, age, salary));

        }

    }


        public void displayAllEnitiesWithDate(List<DevelopersProjects> list) {

            for (DevelopersProjects developersProjects : list) {

                Date date = developersProjects.getDate();
                String name = developersProjects.getName();
                int amount = developersProjects.getAmountOfDevelopers();

                System.out.println(String.format("  date = %s, name = %s, amount of developers = %s", date, name, amount));

            }

        }

*/




}



