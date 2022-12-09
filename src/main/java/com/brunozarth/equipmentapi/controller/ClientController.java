package com.brunozarth.equipmentapi.controller;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.repository.ClientRepository;
import com.brunozarth.equipmentapi.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository cr;

    @GetMapping
    public List<Client> findAll(){
        return cr.findAll();
    }

    @PostMapping
    public Client newClient(@RequestBody Client client){
        return cr.save(client);
    }
}
