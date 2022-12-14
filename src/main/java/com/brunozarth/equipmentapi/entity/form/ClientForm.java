package com.brunozarth.equipmentapi.entity.form;
import javax.validation.constraints.*;

public class ClientForm {

    public ClientForm(String name, String adress, String email, String phone) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
    }

    public ClientForm(){}

    @NotEmpty(message = "Field can't be empty.")
    @Size(min = 3, max =50, message = "'${validatedValue}' must have min {min} and max {max} characters.")
    String name;

    String adress;

    String email;

    String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
