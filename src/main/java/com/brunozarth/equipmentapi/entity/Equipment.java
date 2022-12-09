package com.brunozarth.equipmentapi.entity;

import javax.persistence.*;

@Entity
public class Equipment {
    // equipment: id, type, model, name, color, size, observations, brand, img, isRented


    public Equipment(Long id, String type, String model, String name, String color, String size, String observations, String brand, String imgUrl, boolean isRented) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.name = name;
        this.color = color;
        this.size = size;
        this.observations = observations;
        this.brand = brand;
        this.imgUrl = imgUrl;
        this.isRented = isRented;
    }

    public Equipment(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;

    private String model;

    private String name;

    private String color;

    private String size;

    private String observations;

    private String brand;

    private String imgUrl;

    @Column(nullable = false)
    private boolean isRented;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
