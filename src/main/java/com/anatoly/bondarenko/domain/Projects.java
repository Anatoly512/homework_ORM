package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity

@NamedNativeQuery(
        name = "DevelopersOnProject",
        query = "SELECT p.date pdt, p.projects_name pnm, count(dp.developers_id) c FROM projects p INNER JOIN developers_projects dp ON p.id = dp.projects_id GROUP BY p.id",
        resultSetMapping = "ProjectsResultsMapping")

@SqlResultSetMapping(
        name = "ProjectsResultsMapping",
        classes = {
                @ConstructorResult(
                        columns = {
                                @ColumnResult(name = "pdt", type = Date.class),
                                @ColumnResult(name = "pnm", type = String.class),
                                @ColumnResult(name = "c", type = Integer.class)
                        },
                        targetClass = ProjectsResults.class
                )
        }
)

@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "projects_name")
    private String projectsName;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "date")
    private Date date;

    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<Companies> companies = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_projects",
            joinColumns = {@JoinColumn(name = "projects_id")},
            inverseJoinColumns = {@JoinColumn(name = "developers_id")}
    )
    private Set<Developers> developers = new HashSet<>();



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customers_projects",
            joinColumns = {@JoinColumn(name = "projects_id")},
            inverseJoinColumns = {@JoinColumn(name = "customers_id")}
    )
    private Set<Customers> customers = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "companies_projects",
            joinColumns = {@JoinColumn(name = "projects_id")},
            inverseJoinColumns = {@JoinColumn(name = "companies_id")}
    )
    private Set<Companies> companies2 = new HashSet<>();






    @Override                          //  Lombok вызывет здесь ошибку с закрытием сессии entityManager
    public String toString() {
        return " Id = " + this.id + " Projects name =  " + this.projectsName + " Cost = " + this.cost + " Date = " + this.date;
    }



}
