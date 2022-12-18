package com.brunozarth.equipmentapi.repository;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistory;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRentHistoryRepository extends JpaRepository<EquipmentRentHistory, EquipmentRentHistoryId> {
    List<EquipmentRentHistory> findByEquipmentId(Long equipmentId);

    List<EquipmentRentHistory> findByClientId(Long clientId);

    List<EquipmentRentHistory> findByRentDate(String rentDate);

    List<EquipmentRentHistory> findByDevolutionPredictedDate(String devolutionPredictedDate);

    List<EquipmentRentHistory> findByDevolutionDate(String devolutionDate);
}
