package com.brunozarth.equipmentapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class EquipmentRentHistory {
    // equipmentRentHistory: id=(equipment, rentDate), devolutionPredictedDate, devolutionDate, client, observations


    public EquipmentRentHistory(Long id, Equipment equipment, Client client, String observations) {
        this.id = id;
        this.equipment = equipment;
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

    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    //Timestamp rentDate;

    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    //private Timestamp devolutionPredictedDate;

    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    //private Timestamp devolutionDate;

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
