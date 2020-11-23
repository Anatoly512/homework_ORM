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
@Table(name = "developers_skills")
public class DevelopersSkills {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "developers_id")
    private Integer developersId;

    @Column(name = "skills_id")
    private Integer skillsId;


/*

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Developers> developers = new HashSet<>();

*/



    public DevelopersSkills(Long id, Integer developersId, Integer skillsId) {
        this.id = id;
        this.developersId = developersId;
        this.skillsId = skillsId;
    }





}
