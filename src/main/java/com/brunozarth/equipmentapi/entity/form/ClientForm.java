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
}
