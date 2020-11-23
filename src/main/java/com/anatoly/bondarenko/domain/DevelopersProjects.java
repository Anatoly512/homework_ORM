package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Data
@Entity
@Table(name = "developers_projects")
public class DevelopersProjects {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")

    @Column(name = "projects_id")
    private Integer projects_id;

    @Column(name = "developers_id")
    private Integer developers_id;




}
