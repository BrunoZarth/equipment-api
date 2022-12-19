package com.brunozarth.equipmentapi.service.impl;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistory;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistoryId;
import com.brunozarth.equipmentapi.entity.form.EquipmentRentHistoryForm;
import com.brunozarth.equipmentapi.exception.BadRequestException;
import com.brunozarth.equipmentapi.repository.EquipmentRentHistoryRepository;
import com.brunozarth.equipmentapi.service.IEquipmentRentHistory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EquipmentRentHistoryServiceImpl implements IEquipmentRentHistory {

    EquipmentRentHistoryRepository equipmentRHRepository;
    EquipmentServiceImpl equipmentService;

    EquipmentRentHistoryServiceImpl(EquipmentRentHistoryRepository equipmentRHRepository, EquipmentServiceImpl equipmentService){
        this.equipmentRHRepository = equipmentRHRepository;
        this.equipmentService = equipmentService;
    }
    @Override
    public List<EquipmentRentHistory> findAll() {
        return equipmentRHRepository.findAll();
    }

    @Override
    public EquipmentRentHistory findById(EquipmentRentHistoryId equipmentRentHistoryId) {
        return equipmentRHRepository.findById(equipmentRentHistoryId).orElseThrow(() -> new BadRequestException("Equipment Rent History Id not found"));
    }


    @Override
    public List<EquipmentRentHistory> findByEquipmentRentHistoryIdEquipment(Equipment equipment) {
        //Long equipmentId = equipment.getId();
        return equipmentRHRepository.findByEquipmentRentHistoryIdEquipment(equipment);
    }

    @Override
    public List<EquipmentRentHistory> findByClient(Client client) {
        Long clientId = client.getId();
        return equipmentRHRepository.findByClientId(clientId);
    }

    @Override
    public List<EquipmentRentHistory> findByEquipmentRentHistoryIdRentDate(String rentDate) {
        return equipmentRHRepository.findByEquipmentRentHistoryIdRentDate(rentDate);
    }

    @Override
    public List<EquipmentRentHistory> findByDevolutionPredictedDate(String devolutionPredictedDate) {
        return equipmentRHRepository.findByDevolutionPredictedDate(devolutionPredictedDate);
    }

    @Override
    public List<EquipmentRentHistory> findByDevolutionDate(String devolutionDate) {
        return equipmentRHRepository.findByDevolutionDate(devolutionDate);
    }

    @Override
    public EquipmentRentHistory saveEquipmentRentHistory(EquipmentRentHistoryForm equipmentRentHistoryForm) {

        EquipmentRentHistoryId equipmentRentHistoryId = new EquipmentRentHistoryId();
        equipmentRentHistoryId.setEquipment(equipmentRentHistoryForm.getEquipment());
        equipmentRentHistoryId.setRentDate(equipmentRentHistoryForm.getRentDate());

        EquipmentRentHistory equipmentRentHistory = new EquipmentRentHistory();

        equipmentRentHistory.setEquipmentRentHistoryId(equipmentRentHistoryId);
        equipmentRentHistory.setDevolutionPredictedDate(equipmentRentHistoryForm.getDevolutionPredictedDate());
        equipmentRentHistory.setDevolutionDate(equipmentRentHistoryForm.getDevolutionDate());
        equipmentRentHistory.setClient(equipmentRentHistoryForm.getClient());
        equipmentRentHistory.setObservations(equipmentRentHistoryForm.getObservations());

        return equipmentRHRepository.save(equipmentRentHistory);
    }

    @Override
    public EquipmentRentHistory updateEquipmentRentHistory(Long equipmentId, String rentDate, EquipmentRentHistoryForm equipmentRentHistoryForm) {
        EquipmentRentHistoryId equipmentRentHistoryId = new EquipmentRentHistoryId();
        equipmentRentHistoryId.setEquipment(equipmentService.findById(equipmentId));
        equipmentRentHistoryId.setRentDate(rentDate);
        EquipmentRentHistory equipmentRentHistory = this.findById(equipmentRentHistoryId);

        equipmentRentHistory.setDevolutionPredictedDate(equipmentRentHistoryForm.getDevolutionPredictedDate());
        equipmentRentHistory.setDevolutionDate(equipmentRentHistoryForm.getDevolutionDate());
        equipmentRentHistory.setClient(equipmentRentHistoryForm.getClient());
        equipmentRentHistory.setObservations(equipmentRentHistoryForm.getObservations());

        return equipmentRHRepository.save(equipmentRentHistory);
    }

    @Override
    public void deleteEquipmentRentHistory(Long equipmentId, String rentDate) {
        EquipmentRentHistoryId equipmentRentHistoryId = new EquipmentRentHistoryId();
        equipmentRentHistoryId.setEquipment(equipmentService.findById(equipmentId));
        equipmentRentHistoryId.setRentDate(rentDate);

        EquipmentRentHistory equipmentRentHistory = this.findById(equipmentRentHistoryId);
        equipmentRHRepository.delete(equipmentRentHistory);
    }
}
