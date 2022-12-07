package com.brunozarth.equipmentapi.entity;

import javax.persistence.*;

@Entity
public class Equipment {
    // equipment: id, type, model, name, color, size, observations, brand, img, isRented


    public Equipment(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Equipment(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //private String type;

    //private String model;

    private String name;

    //private String color;

    //private String size;

    //private String observations;

    //private String brand;

    //private String imgUrl;

    //private boolean isRented;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
