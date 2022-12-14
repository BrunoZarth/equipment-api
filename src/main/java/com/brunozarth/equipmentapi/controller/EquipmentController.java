package com.brunozarth.equipmentapi.controller;

import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.form.EquipmentForm;
import com.brunozarth.equipmentapi.repository.EquipmentRepository;
import com.brunozarth.equipmentapi.service.impl.EquipmentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentServiceImpl equipmentService;

    public EquipmentController(EquipmentServiceImpl equipmentService) {
        this.equipmentService = equipmentService;
    }

    // GET
    @GetMapping("/findAll")
    ResponseEntity<List<Equipment>> findAll(){
        return ResponseEntity.ok(equipmentService.findAll());
    };

    @GetMapping("findByName/{name}")
    ResponseEntity<List<Equipment>> findByName(@PathVariable String name){
        return ResponseEntity.ok(equipmentService.findByName(name));
    };

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<Equipment> findById(@PathVariable Long id){
        return new ResponseEntity<>(equipmentService.findById(id), HttpStatus.FOUND);
    };

    @GetMapping("/findByType/{type}")
    ResponseEntity<List<Equipment>> findByType(@PathVariable String type){
        return ResponseEntity.ok(equipmentService.findByType(type));
    };

    @GetMapping("/findByModel/{model}")
    ResponseEntity<List<Equipment>> findByModel(@PathVariable String model){
        return ResponseEntity.ok(equipmentService.findByModel(model));
    };

    @GetMapping("/findByBrand/{brand}")
    ResponseEntity<List<Equipment>> findByBrand(@PathVariable String brand){
        return ResponseEntity.ok(equipmentService.findByBrand(brand));
    };

    //POST / CREATE
    @PostMapping("/saveEquipment")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Equipment> saveEquipment(@RequestBody EquipmentForm equipmentForm){
        return new ResponseEntity<>(equipmentService.saveEquipment(equipmentForm), HttpStatus.CREATED);
    };

    //UPDATE
    @PostMapping("/updateEquipment/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Equipment> updateEquipment(@PathVariable Long id, @RequestBody EquipmentForm equipmentForm){
        return new ResponseEntity<>(equipmentService.updateEquipment(id, equipmentForm), HttpStatus.CREATED);
    };

    //DELETE
    @DeleteMapping("/deleteEquipment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deleteEquipment(@PathVariable Long id){
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    };
}
