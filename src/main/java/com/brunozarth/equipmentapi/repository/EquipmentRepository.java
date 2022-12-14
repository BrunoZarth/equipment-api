package com.brunozarth.equipmentapi.repository;

import com.brunozarth.equipmentapi.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByName(String name);

    List<Equipment> findByType(String type);

    List<Equipment> findByModel(String model);

    List<Equipment> findByBrand(String brand);
}
