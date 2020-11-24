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
@Table(name = "customers_projects")

public class CustomersProjects {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "projects_id")
    private Integer projects_id;

    @Column(name = "customers_id")
    private Integer customers_id;



    @Override                          //  Lombok вызывет здесь ошибку с закрытием сессии entityManager
    public String toString() {
        return " Id = " + this.id + " Projects Id =  " + this.projects_id + " Customers Id = " + this.customers_id;
    }


}
