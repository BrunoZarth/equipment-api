package com.brunozarth.equipmentapi.repository;

import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistory;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRentHistoryRepository extends JpaRepository<EquipmentRentHistory, EquipmentRentHistoryId> {
}
