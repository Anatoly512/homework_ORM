package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "language")
    private String language;

    @Enumerated(EnumType.STRING)
    @Type(type = "com.anatoly.bondarenko.domain.SkillLevelPostgresqlEnum")
    @Column (name = "skillLevel")
    private SkillLevel skillLevel;

    @ManyToMany(mappedBy = "skills", cascade = CascadeType.ALL)
    private Set<Developers> developers = new HashSet<>();




    @Override                          //  Lombok вызывет здесь ошибку с закрытием сессии entityManager
    public String toString() {
        return " Id = " + this.id + " Language  =  " + this.language + " SkillLevel = " + this.skillLevel;
    }




}
