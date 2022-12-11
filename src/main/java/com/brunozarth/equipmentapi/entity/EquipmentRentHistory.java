package com.brunozarth.equipmentapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class EquipmentRentHistory {
    // equipmentRentHistory: id=(equipment, rentDate), devolutionPredictedDate, devolutionDate, client, observations


    public EquipmentRentHistory(Long id, Equipment equipment, Timestamp rentDate, Timestamp devolutionPredictedDate, Timestamp devolutionDate, Client client, String observations) {
        this.id = id;
        this.equipment = equipment;
        this.rentDate = rentDate;
        this.devolutionPredictedDate = devolutionPredictedDate;
        this.devolutionDate = devolutionDate;
        this.client = client;
        this.observations = observations;
    }

    public EquipmentRentHistory(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    Equipment equipment;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    Timestamp rentDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp devolutionPredictedDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp devolutionDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String observations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Timestamp getRentDate() {
        return rentDate;
    }

    public void setRentDate(Timestamp rentDate) {
        this.rentDate = rentDate;
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
