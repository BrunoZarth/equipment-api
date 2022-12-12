package com.brunozarth.equipmentapi.controller;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistory;
import com.brunozarth.equipmentapi.repository.ClientRepository;
import com.brunozarth.equipmentapi.repository.EquipmentRentHistoryRepository;
import com.brunozarth.equipmentapi.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/equipmentRentHistory")
public class EquipmentRentHistoryController {

    private final EquipmentRentHistoryRepository erhr;

    public EquipmentRentHistoryController(EquipmentRentHistoryRepository erhr) {
        this.erhr = erhr;
    }

    @GetMapping
    public List<EquipmentRentHistory> findAll(){
        return erhr.findAll();
    }

    @PostMapping
    public EquipmentRentHistory newClient(@RequestBody EquipmentRentHistory equipmentRentHistory){
        DateUtil dateUtil = new DateUtil();
        equipmentRentHistory.getEquipmentRentHistoryId().setRentDate(dateUtil.FormatDateTimeToDatabaseStyle(LocalDateTime.now()));

        return erhr.save(equipmentRentHistory);
    }
}
