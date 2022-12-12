package com.brunozarth.equipmentapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Embeddable
public class EquipmentRentHistoryId implements Serializable {


    public EquipmentRentHistoryId(Equipment equipment, String rentDate) {
        this.equipment = equipment;
        this.rentDate = rentDate;
    }

    public EquipmentRentHistoryId(){}

    private static final long serialVersionUID = 2310708218555751536L;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    Equipment equipment;

    String rentDate;

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
}