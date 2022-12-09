package com.brunozarth.equipmentapi.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class EquipmentRentHistory {
    // equipmentRentHistory: id=(equipment, rentDate), devolutionPredictedDate, devolutionDate, client, observations


    public EquipmentRentHistory(EquipmentRentHistoryId equipmentRentHistoryId, Timestamp devolutionPredictedDate, Timestamp devolutionDate, Client client, String observations) {
        this.equipmentRentHistoryId = equipmentRentHistoryId;
        this.devolutionPredictedDate = devolutionPredictedDate;
        this.devolutionDate = devolutionDate;
        this.client = client;
        this.observations = observations;
    }

    public EquipmentRentHistory(){}

    @EmbeddedId
    EquipmentRentHistoryId equipmentRentHistoryId;

    private Timestamp devolutionPredictedDate;

    private Timestamp devolutionDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String observations;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EquipmentRentHistoryId getEquipmentRentHistoryId() {
        return equipmentRentHistoryId;
    }

    public void setEquipmentRentHistoryId(EquipmentRentHistoryId equipmentRentHistoryId) {
        this.equipmentRentHistoryId = equipmentRentHistoryId;
    }

    public Timestamp getDevolutionPredictedDate() {
        return devolutionPredictedDate;
    }

    public void setDevolutionPredictedDate(Timestamp devolutionPredictedDate) {
        this.devolutionPredictedDate = devolutionPredictedDate;
    }

    public Timestamp getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Timestamp devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
