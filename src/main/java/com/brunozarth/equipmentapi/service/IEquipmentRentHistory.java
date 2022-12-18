package com.brunozarth.equipmentapi.service;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistory;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistoryId;
import com.brunozarth.equipmentapi.entity.form.ClientForm;
import com.brunozarth.equipmentapi.entity.form.EquipmentRentHistoryForm;

import java.util.List;

public interface IEquipmentRentHistory {

    //GET / READ
    List<EquipmentRentHistory> findAll();

    EquipmentRentHistory findById(EquipmentRentHistoryId equipmentRentHistoryId);

    List<EquipmentRentHistory> findByEquipment(Equipment equipment);


    List<EquipmentRentHistory> findByClient(Client client);

    List<EquipmentRentHistory> findByRentDate(String rentDate);

    List<EquipmentRentHistory> findByDevolutionPredictedDate(String devolutionPredictedDate);

    List<EquipmentRentHistory> findByDevolutionDate(String devolutionDate);

    //POST / CREATE
    EquipmentRentHistory saveEquipmentRentHistory(EquipmentRentHistoryForm equipmentRentHistoryForm);

    //UPDATE
    EquipmentRentHistory updateEquipmentRentHistory(Long equipmentId, String rentDate, EquipmentRentHistoryForm equipmentRentHistoryForm);

    //DELETE
    void deleteEquipmentRentHistory(Long equipmentId, String rentDate);


}
