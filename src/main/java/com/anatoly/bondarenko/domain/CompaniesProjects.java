package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity
@Table(name = "companies_projects")
public class CompaniesProjects {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "projects_id")
    private Integer projects_id;

    @Column(name = "companies_id")
    private Integer companies_id;



    @Override                          //  Lombok вызывет здесь ошибку с закрытием сессии entityManager
    public String toString() {
        return " Id = " + this.id + " Projects Id =  " + this.projects_id + " Companies Id = " + this.companies_id;
    }

}
