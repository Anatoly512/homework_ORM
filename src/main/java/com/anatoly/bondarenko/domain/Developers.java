package com.anatoly.bondarenko.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
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

    public Developers() {     //  Этот конструктор нужен для корректной работы класса DevelopersDAO,
        //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }


// getters  (Lombok почему-то не создал их автоматически, поэтому по старинке)

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Integer getAge() {
        return this.age;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public Long getId() {
        return this.id;
    }

    public Set<Skills> getSkills() {
        return this.skills;
    }


//  setters

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setId(Long id) {
        this.id = id;
    }





    @Override
    public String toString() {
        return " id = " + id + " name =  " + name + " gender = " + gender + " age = " + age + " salary = " + salary;
    }



}