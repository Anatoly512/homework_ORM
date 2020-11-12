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
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "language")
    private String language;

    @Column (name = "skillLevel")
    private SkillLevel skillLevel;

    @ManyToMany(mappedBy = "skills", cascade = CascadeType.ALL)
    private Set<Developers> developers = new HashSet<>();



    public Skills(Long id, String language, SkillLevel skillLevel) {
        this.id = id;
        this.language = language;
        this.skillLevel = skillLevel;
    }

    public Skills() {     //  Этот конструктор нужен для корректной работы класса DevelopersDAO,
                          //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


// getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getLanguage() {
        return this.language;
    }

    public SkillLevel getSkillLevel() {
        return this.skillLevel;
    }

    public Long getId() {
        return this.id;
    }


//  setters

    public void setLanguage(String language) {

        this.language = language;
    }

    public void setSkillLevel(SkillLevel skillLevel) {

        this.skillLevel = skillLevel;
    }

    public void setId(Long id) {

        this.id = id;
    }


}
