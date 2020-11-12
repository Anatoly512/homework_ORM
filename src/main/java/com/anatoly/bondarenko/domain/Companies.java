package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Data
@Entity
@Table(name = "companies")
public class Companies {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "companies_projects",
            joinColumns = {@JoinColumn(name = "projects_id")},
            inverseJoinColumns = {@JoinColumn(name = "companies_id")}
    )
    private Set<Projects> projects = new HashSet<Projects>();



    public Companies(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public Companies() {     //  Этот конструктор нужен для корректной работы класса CompaniesDAO,
                             //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


// getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getCompanyName() {
        return this.companyName;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }


}


