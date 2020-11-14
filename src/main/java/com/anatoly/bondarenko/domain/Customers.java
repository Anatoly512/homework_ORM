package com.anatoly.bondarenko.domain;

import lombok.Data;

@Data
public class Customers {

    private Long id;
    private String name;

    public Customers(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customers() {     //  Этот конструктор нужен для корректной работы класса CustomersDAO,
                             //  пустые поля потом (после создания объекта) заполняются через сеттеры
    }






}
