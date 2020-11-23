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
@Table(name = "developers_projects")
public class DevelopersProjects {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "projects_id")
    private Integer projects_id;

    @Column(name = "developers_id")
    private Integer developers_id;



    @Override                          //  Lombok вызывет здесь ошибку с закрытием сессии entityManager
    public String toString() {
        return " Id = " + this.id + " Projects Id =  " + this.projects_id + " Developers Id = " + this.developers_id;
    }




}
