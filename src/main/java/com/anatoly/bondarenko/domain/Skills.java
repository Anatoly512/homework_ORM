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






}
