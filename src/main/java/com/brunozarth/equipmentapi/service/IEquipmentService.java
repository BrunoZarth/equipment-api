package com.brunozarth.equipmentapi.service;

import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.form.EquipmentForm;

import java.util.List;

public interface IEquipmentService {
    //GET / READ
    List<Equipment> findAll();

    List<Equipment> findByName(String name);

    Equipment findById(Long id);

    List<Equipment> findByType(String type);

    List<Equipment> findByModel(String model);

    List<Equipment> findByBrand(String brand);

    //POST / CREATE
    Equipment saveEquipment(EquipmentForm equipmentForm);

    //UPDATE
    Equipment updateEquipment(Long id, EquipmentForm equipmentForm);

    //DELETE
    void deleteEquipment(Long id);
}
