package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@NoArgsConstructor
@Data
@Entity
@Table(name = "developers")
public class Developers {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Type(type = "com.anatoly.bondarenko.domain.GenderPostgresqlEnum")
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToMany(mappedBy = "developers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Projects> projects = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "developers_skills",
            joinColumns = {@JoinColumn(name = "developers_id")},
            inverseJoinColumns = {@JoinColumn(name = "skills_id")}
    )
    private Set<Skills> skills = new HashSet<>();



    public Developers(Long id, String name, Gender gender, Integer age, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }





    @Override                          //  Просто для сравнения, чтобы понять, лучше ли это делает Lombok автоматически (в других классах)
    public String toString() {
        return " Id = " + this.id + " Name =  " + this.name + " Gender = " + gender + " Age = " + this.age + " Salary = " + this.salary;
    }


}

