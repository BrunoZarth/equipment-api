package com.brunozarth.equipmentapi.service.impl;

import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.form.EquipmentForm;
import com.brunozarth.equipmentapi.exception.BadRequestException;
import com.brunozarth.equipmentapi.repository.EquipmentRepository;
import com.brunozarth.equipmentapi.service.IEquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipmentServiceImpl implements IEquipmentService {

    EquipmentRepository equipmentRepository;

    EquipmentServiceImpl(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public List<Equipment> findByName(String name) {
        return equipmentRepository.findByName(name);
    }

    @Override
    public Equipment findById(Long id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new BadRequestException("Equipment ID not found!"));
    }

    @Override
    public List<Equipment> findByType(String type) {
        return equipmentRepository.findByType(type);
    }

    @Override
    public List<Equipment> findByModel(String model) {
        return equipmentRepository.findByModel(model);
    }

    @Override
    public List<Equipment> findByBrand(String brand) {
        return equipmentRepository.findByBrand(brand);
    }

    @Override
    public Equipment saveEquipment(EquipmentForm equipmentForm) {

        Equipment equipment = new Equipment();

        equipment.setBrand(equipmentForm.getBrand());
        equipment.setColor(equipmentForm.getColor());
        equipment.setName(equipmentForm.getName());
        equipment.setModel(equipmentForm.getModel());
        equipment.setObservations(equipmentForm.getObservations());
        equipment.setType(equipmentForm.getType());
        equipment.setImgUrl(equipmentForm.getImgUrl());
        equipment.setSize(equipmentForm.getSize());
        equipment.setRented(false);

        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment updateEquipment(Long id, EquipmentForm equipmentForm) {

        Equipment equipment = this.findById(id);

        equipment.setBrand(equipmentForm.getBrand());
        equipment.setColor(equipmentForm.getColor());
        equipment.setName(equipmentForm.getName());
        equipment.setModel(equipmentForm.getModel());
        equipment.setObservations(equipmentForm.getObservations());
        equipment.setType(equipmentForm.getType());
        equipment.setImgUrl(equipmentForm.getImgUrl());
        equipment.setSize(equipmentForm.getSize());

        return equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(Long id) {
        Equipment equipment = this.findById(id);
        equipmentRepository.delete(equipment);
    }
}
