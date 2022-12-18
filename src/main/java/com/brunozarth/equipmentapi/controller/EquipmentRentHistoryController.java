package com.brunozarth.equipmentapi.controller;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistory;
import com.brunozarth.equipmentapi.entity.EquipmentRentHistoryId;
import com.brunozarth.equipmentapi.entity.form.EquipmentRentHistoryForm;
import com.brunozarth.equipmentapi.repository.ClientRepository;
import com.brunozarth.equipmentapi.repository.EquipmentRentHistoryRepository;
import com.brunozarth.equipmentapi.service.impl.EquipmentRentHistoryServiceImpl;
import com.brunozarth.equipmentapi.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/equipmentRentHistory")
public class EquipmentRentHistoryController {

    private final EquipmentRentHistoryServiceImpl equipmentRHService;

    public EquipmentRentHistoryController(EquipmentRentHistoryServiceImpl equipmentRHService) {
        this.equipmentRHService = equipmentRHService;
    }

    //GET / READ

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<List<EquipmentRentHistory>> findAll(){
        return new ResponseEntity<>(equipmentRHService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/findById")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<EquipmentRentHistory> findById(@RequestBody EquipmentRentHistoryId equipmentRentHistoryId){
        return new ResponseEntity<>(equipmentRHService.findById(equipmentRentHistoryId), HttpStatus.FOUND);
    };

    @GetMapping("/findByEquipment")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<List<EquipmentRentHistory>> findByEquipment(@RequestBody Equipment equipment){
        return new ResponseEntity<>(equipmentRHService.findByEquipment(equipment), HttpStatus.FOUND);
    };

    @GetMapping("/findByClient")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<List<EquipmentRentHistory>> findByClient(@RequestBody Client client){
        return new ResponseEntity<>(equipmentRHService.findByClient(client), HttpStatus.FOUND);
    };

    @GetMapping("/findByRentDate/{rentDate}")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<List<EquipmentRentHistory>> findByRentDate(@PathVariable String rentDate){
        return new ResponseEntity<>(equipmentRHService.findByRentDate(rentDate), HttpStatus.FOUND);
    };

    @GetMapping("/findByDevolutionPredictedDate/{devolutionPredictedDate}")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<List<EquipmentRentHistory>> findByDevolutionPredictedDate(@PathVariable String devolutionPredictedDate){
        return new ResponseEntity<>(equipmentRHService.findByDevolutionPredictedDate(devolutionPredictedDate), HttpStatus.FOUND);
    };

    @GetMapping("/findByDevolutionDate/{devolutionDate}")
    @ResponseStatus(HttpStatus.FOUND)
    ResponseEntity<List<EquipmentRentHistory>> findByDevolutionDate(@PathVariable String devolutionDate){
        return new ResponseEntity<>(equipmentRHService.findByDevolutionDate(devolutionDate), HttpStatus.FOUND);
    };

    //POST / CREATE
    @PostMapping("/saveEquipmentRentHistory")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EquipmentRentHistory> saveEquipmentRentHistory(@RequestBody EquipmentRentHistoryForm equipmentRentHistoryForm){
        return new ResponseEntity<>(equipmentRHService.saveEquipmentRentHistory(equipmentRentHistoryForm), HttpStatus.CREATED);
    };

    //UPDATE
    @PostMapping("/updateEquipmentRentHistory/{equipmentId}/{rentDate}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EquipmentRentHistory> updateEquipmentRentHistory(@PathVariable Long equipmentId, @PathVariable String rentDate, @RequestBody EquipmentRentHistoryForm equipmentRentHistoryForm){
        return new ResponseEntity<>(equipmentRHService.updateEquipmentRentHistory(equipmentId, rentDate, equipmentRentHistoryForm), HttpStatus.CREATED);
    };

    //DELETE
    @DeleteMapping("/deleteEquipmentRentHistory/{equipmentId}/{rentDate}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deleteEquipmentRentHistory(@PathVariable Long equipmentId, @PathVariable String rentDate){
        equipmentRHService.deleteEquipmentRentHistory(equipmentId, rentDate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    };
}
