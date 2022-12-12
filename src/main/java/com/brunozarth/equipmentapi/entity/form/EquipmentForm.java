package com.brunozarth.equipmentapi.entity.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EquipmentForm {

    public EquipmentForm(String type, String model, String name, String color, String size, String observations, String brand, String imgUrl, boolean isRented) {
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

    String type;

    String model;

    String name;

    String color;

    String size;

    String observations;

    String brand;

    String imgUrl;

    @NotEmpty(message = "Field can't be empty. must be true or false.")
    @Size(min = 3, max =6, message = "'${validatedValue}' must have min {min} and max {max} characters.")
    boolean isRented;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
