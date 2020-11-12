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

    public DevelopersSkills() {     //  Этот конструктор нужен для корректной работы класса DevelopersSkills,
                                    //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


    // getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public Integer getDevelopersId() {
        return this.developersId;
    }

    public Integer getSkillsId() {
        return this.skillsId;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setDevelopersId(Integer developersId) {
        this.developersId = developersId;
    }

    public void setSkillsId(Integer skillsId) {
        this.skillsId = skillsId;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
