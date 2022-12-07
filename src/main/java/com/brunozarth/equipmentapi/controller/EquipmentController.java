package com.brunozarth.equipmentapi.controller;

import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository er;

    @GetMapping
    public List<Equipment> findAll(){
        return er.findAll();
    }

    @PostMapping
    public Equipment newEquipment(@RequestBody Equipment equipment){
        return er.save(equipment);
    }
}
