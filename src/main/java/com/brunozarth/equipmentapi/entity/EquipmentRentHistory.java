package com.brunozarth.equipmentapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class EquipmentRentHistory {
    // equipmentRentHistory: id=(equipment, rentDate), devolutionPredictedDate, devolutionDate, client, observations


    public EquipmentRentHistory(EquipmentRentHistoryId equipmentRentHistoryId, String devolutionPredictedDate, String devolutionDate, Client client, String observations) {
        this.equipmentRentHistoryId = equipmentRentHistoryId;
        this.devolutionPredictedDate = devolutionPredictedDate;
        this.devolutionDate = devolutionDate;
        this.client = client;
        this.observations = observations;
    }

    public EquipmentRentHistory(){}

    @EmbeddedId
    EquipmentRentHistoryId equipmentRentHistoryId;

    private String devolutionPredictedDate;

    private String devolutionDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String observations;

    public EquipmentRentHistoryId getEquipmentRentHistoryId() {
        return equipmentRentHistoryId;
    }

    public void setEquipmentRentHistoryId(EquipmentRentHistoryId equipmentRentHistoryId) {
        this.equipmentRentHistoryId = equipmentRentHistoryId;
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
