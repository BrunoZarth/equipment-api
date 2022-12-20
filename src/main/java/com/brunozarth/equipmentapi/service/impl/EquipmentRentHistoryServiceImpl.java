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
import java.util.stream.Collectors;

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
    public EquipmentRentHistory findById(Long equipmentId, String rentDate) { 
        
        List<EquipmentRentHistory> equipmentRentHistoryIdList = this.findByEquipmentRentHistoryIdEquipmentId(equipmentId)
                .stream()
                .filter(e -> e.getEquipmentRentHistoryId().getRentDate().equals(rentDate))
                .collect(Collectors.toList());
        
        EquipmentRentHistoryId equipmentRentHistoryId = equipmentRentHistoryIdList.get(0).getEquipmentRentHistoryId();

        return equipmentRentHistoryIdList.get(0);
        // return equipmentRHRepository.findById(equipmentRentHistoryId).orElseThrow(() -> new BadRequestException("Equipment Rent History Id not found"));
    }


    @Override
    public List<EquipmentRentHistory> findByEquipmentRentHistoryIdEquipmentId(Long equipmentId) {
        return equipmentRHRepository.findByEquipmentRentHistoryIdEquipmentId(equipmentId);
    }

    @Override
    public List<EquipmentRentHistory> findByClientId(Long clientId) {
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

    @Override //MUST CREATE NEW CLASS EquipmentRentHistoryFormUpdate !!!!
    public EquipmentRentHistory updateEquipmentRentHistory(Long equipmentId, String rentDate, EquipmentRentHistoryForm equipmentRentHistoryForm) {

        EquipmentRentHistory equipmentRentHistory = this.findById(equipmentId, rentDate);

        equipmentRentHistory.setDevolutionPredictedDate(equipmentRentHistoryForm.getDevolutionPredictedDate());
        equipmentRentHistory.setDevolutionDate(equipmentRentHistoryForm.getDevolutionDate());
        equipmentRentHistory.setClient(equipmentRentHistoryForm.getClient());
        equipmentRentHistory.setObservations(equipmentRentHistoryForm.getObservations());

        return equipmentRHRepository.save(equipmentRentHistory);
    }

    @Override
    public void deleteEquipmentRentHistory(Long equipmentId, String rentDate) {
        EquipmentRentHistory equipmentRentHistory = this.findById(equipmentId, rentDate);
        equipmentRHRepository.delete(equipmentRentHistory);
    }
}
