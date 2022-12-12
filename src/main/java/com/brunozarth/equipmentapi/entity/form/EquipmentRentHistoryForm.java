package com.brunozarth.equipmentapi.entity.form;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistoryId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EquipmentRentHistoryForm {

    public EquipmentRentHistoryForm(Equipment equipment, String rentDate, String devolutionPredictedDate, String devolutionDate, Client client, String observations) {
        this.equipment = equipment;
        this.rentDate = rentDate;
        this.devolutionPredictedDate = devolutionPredictedDate;
        this.devolutionDate = devolutionDate;
        this.client = client;
        this.observations = observations;
    }

    public EquipmentRentHistoryForm(){};

    @NotNull(message = "Field can't be null.")
    Equipment equipment;

    @NotEmpty(message = "Field can't be empty.")
    @Size(min = 8, max =50, message = "'${validatedValue}' must have min {min} and max {max} characters.")
    String rentDate;

    String devolutionPredictedDate;

    String devolutionDate;

    Client client;

    String observations;

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getDevolutionPredictedDate() {
        return devolutionPredictedDate;
    }

    public void setDevolutionPredictedDate(String devolutionPredictedDate) {
        this.devolutionPredictedDate = devolutionPredictedDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
