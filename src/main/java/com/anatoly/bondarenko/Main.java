package com.anatoly.bondarenko;

import com.anatoly.bondarenko.repository.*;
import com.anatoly.bondarenko.domain.*;
import com.anatoly.bondarenko.service.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.List;

@ToString
@Data
public class Main {

    @Getter
    EntityManager entityManager;

    Main() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ORM homework");
        entityManager = entityManagerFactory.createEntityManager();
    }

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

    private static ProgrammLanguages languages = new ProgrammLanguages();

    public static void main(String[] args) throws SQLException {

    //  Тестовый вывод таблиц в удобном виде
        displayDevelopers();
        displayCompanies();
        displayCustomers();
      //  displayProjects();
      //  displaySkills();





        ///////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////

        System.out.println("\n  HIBERNATE  TASKS  !!!!!!!!!!!!!!!!!!!!!! \n");

        System.out.println(developersService.getDevelopersBySkill(languages.JAVA));


      //  showTables.displayEnities(developersService.getDevelopersBySkill(languages.JAVA));



  }



  ///////  Блок методов представления: вывода таблиц на консоль

  public static void displayDevelopers() throws SQLException {

        EntityManager entityManager = developersDAO.getEntityManager();

        System.out.println();
        try {

            List<Developers> developers = entityManager.createNativeQuery(" SELECT * FROM developers", Developers.class).getResultList();

            for (Developers developer : developers) {
                Long id = developer.getId();
                String name = developer.getName();
                Gender gender = developer.getGender();
                int age = developer.getAge();
                BigDecimal salary = developer.getSalary();

                System.out.println(String.format("DEVELOPERS:  id = %d, name = %s, gender = %s, age = %s, salary = %s", id, name, gender, age, salary));
            }
        }

        catch (Exception exception) {
            developersDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new SQLException(String.valueOf(exception));
        }
        finally {
            System.out.println();
        }

    }


  public static void displayCompanies() throws SQLException {

        EntityManager entityManager = companiesDAO.getEntityManager();

        try {

            List<Companies> companies = entityManager.createNativeQuery(" SELECT * FROM companies", Companies.class).getResultList();


            for (Companies company : companies) {
                Long id = company.getId();
                String name = company.getCompanyName();

                System.out.println(String.format("COMPANIES:  id = %d, company name = %s", id, name));
            }
        }

        catch (Exception exception) {
            companiesDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new SQLException(String.valueOf(exception));
        }
        finally {
            entityManager.close();
            System.out.println();
        }

    }


  public static void displayCustomers() throws SQLException {

        EntityManager entityManager = customersDAO.getEntityManager();

        try {

            List<Customers> customers = entityManager.createNativeQuery(" SELECT * FROM customers", Customers.class).getResultList();


            for (Customers customer : customers) {
                Long id = customer.getId();
                String name = customer.getName();

                System.out.println(String.format("CUSTOMERS:  id = %d, customer name = %s", id, name));
            }
        }

        catch (Exception exception) {
            customersDAO.logger.error("Error occurred while getting entities. Exeption message: {}", exception.getMessage());
            throw new SQLException(String.valueOf(exception));
        }
        finally {
            entityManager.close();
            System.out.println();
        }

    }






  //////////////////////////////////////

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
