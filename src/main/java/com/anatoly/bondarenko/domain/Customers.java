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
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private Set<Projects> projects = new HashSet<>();


    public Customers(Long id, String name) {
        this.id = id;
        this.name = name;
    }








}
