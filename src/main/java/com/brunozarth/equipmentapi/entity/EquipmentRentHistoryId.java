package com.brunozarth.equipmentapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@Embeddable
public class EquipmentRentHistoryId implements Serializable {

    public EquipmentRentHistoryId(Equipment equipment, Timestamp rentDate) {
        this.equipment = equipment;
        this.rentDate = rentDate;
    }

    public EquipmentRentHistoryId(){}

    private static final long serialVersionUID = 2310708218555751536L;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    Equipment equipment;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    Timestamp rentDate;

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
}