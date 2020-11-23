package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Data
@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String projectsName;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "date")
    private Date date;

    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<Companies> companies = new HashSet<Companies>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customers_projects",
            joinColumns = {@JoinColumn(name = "projects_id")},
            inverseJoinColumns = {@JoinColumn(name = "customers_id")}
    )
    private Set<Customers> customers = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_projects",
            joinColumns = {@JoinColumn(name = "projects_id")},
            inverseJoinColumns = {@JoinColumn(name = "developers_id")}
    )
    private Set<Developers> developers = new HashSet<>();

    private Integer amount;



    public Projects(Long id, String projectsName, BigDecimal cost, Date date) {
        this.id = id;
        this.projectsName = projectsName;
        this.cost = cost;
        this.date = date;
    }

    public Projects() {     //  Этот конструктор нужен для корректной работы класса DevelopersDAO,
                            //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }





}
