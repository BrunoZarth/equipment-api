package com.brunozarth.equipmentapi.service.impl;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistory;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistoryId;
import com.brunozarth.equipmentapi.entity.form.EquipmentRentHistoryForm;
import com.brunozarth.equipmentapi.exception.BadRequestException;
import com.brunozarth.equipmentapi.repository.EquipmentRentHistoryRepository;
import com.brunozarth.equipmentapi.repository.EquipmentRepository;
import com.brunozarth.equipmentapi.service.IEquipmentRentHistory;
import com.brunozarth.equipmentapi.utils.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentRentHistoryServiceImpl implements IEquipmentRentHistory {

    EquipmentRentHistoryRepository equipmentRHRepository;
    EquipmentServiceImpl equipmentService;
    private final EquipmentRepository equipmentRepository;

    EquipmentRentHistoryServiceImpl(EquipmentRentHistoryRepository equipmentRHRepository, EquipmentServiceImpl equipmentService,
                                    EquipmentRepository equipmentRepository){
        this.equipmentRHRepository = equipmentRHRepository;
        this.equipmentService = equipmentService;
        this.equipmentRepository = equipmentRepository;
    }
    @Override
    public Page<EquipmentRentHistory> findAll(Pageable pageable) {
        return equipmentRHRepository.findAll(pageable);
    }

    @Override
    public EquipmentRentHistory findById(Long equipmentId, String rentDate) {

        EquipmentRentHistory equipmentRentHistory;

        try {
            equipmentRentHistory = this.findByEquipmentRentHistoryIdEquipmentId(equipmentId)
                .stream()
                .filter(e -> e.getEquipmentRentHistoryId().getRentDate().equals(rentDate))
                .collect(Collectors.toList())
                .get(0);
        } catch (IndexOutOfBoundsException e){
            throw new BadRequestException("Equipment Rent History rent date not found");
        }

        return equipmentRentHistory;
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

        DateUtil dateUtil = new DateUtil();

        EquipmentRentHistoryId equipmentRentHistoryId = new EquipmentRentHistoryId();
        equipmentRentHistoryId.setEquipment(equipmentRentHistoryForm.getEquipment());
        equipmentRentHistoryId.setRentDate(dateUtil.extractInt(equipmentRentHistoryForm.getRentDate())); // only numbers

        EquipmentRentHistory equipmentRentHistory = new EquipmentRentHistory();

        equipmentRentHistory.setEquipmentRentHistoryId(equipmentRentHistoryId);
        equipmentRentHistory.setDevolutionPredictedDate(dateUtil.extractInt(equipmentRentHistoryForm.getDevolutionPredictedDate()));
        equipmentRentHistory.setDevolutionDate(dateUtil.extractInt(equipmentRentHistoryForm.getDevolutionDate()));
        equipmentRentHistory.setClient(equipmentRentHistoryForm.getClient());
        equipmentRentHistory.setObservations(equipmentRentHistoryForm.getObservations());



        return equipmentRHRepository.save(equipmentRentHistory);
    }

    @Override //MUST CREATE NEW CLASS EquipmentRentHistoryFormUpdate !!!!
    public EquipmentRentHistory updateEquipmentRentHistory(Long equipmentId, String rentDate, EquipmentRentHistoryForm equipmentRentHistoryForm) {

        DateUtil dateUtil = new DateUtil();

        EquipmentRentHistory equipmentRentHistory = this.findById(equipmentId, rentDate);

        equipmentRentHistory.setDevolutionPredictedDate(dateUtil.extractInt(equipmentRentHistoryForm.getDevolutionPredictedDate()));
        equipmentRentHistory.setDevolutionDate(dateUtil.extractInt(equipmentRentHistoryForm.getDevolutionDate()));
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
