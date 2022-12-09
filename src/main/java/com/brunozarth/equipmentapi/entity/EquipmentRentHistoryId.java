package com.brunozarth.equipmentapi.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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