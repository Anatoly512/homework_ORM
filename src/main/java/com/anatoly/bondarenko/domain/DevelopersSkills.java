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





    public DevelopersSkills(Long id, Integer developersId, Integer skillsId) {
        this.id = id;
        this.developersId = developersId;
        this.skillsId = skillsId;
    }




    @Override                          //  Lombok вызывет здесь ошибку с закрытием сессии entityManager
    public String toString() {
        return " Id = " + this.id + " Developers Id =  " + this.developersId + " Skills Id = " + this.skillsId;
    }




}
