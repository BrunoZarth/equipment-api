package com.brunozarth.equipmentapi.controller;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.Equipment;
import com.brunozarth.equipmentapi.entity.form.ClientForm;
import com.brunozarth.equipmentapi.repository.ClientRepository;
import com.brunozarth.equipmentapi.repository.EquipmentRepository;
import com.brunozarth.equipmentapi.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }



    @GetMapping("/findAll")
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Client>> findByName(@PathVariable String name){
        return ResponseEntity.ok(clientService.findByName(name));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Client> findByEmail(@PathVariable String email){
        return ResponseEntity.ok(clientService.findByEmail(email));
    }

    @PostMapping("/newClient")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> newClient(@RequestBody @Valid ClientForm clientForm){
        return new ResponseEntity<>(clientService.saveClient(clientForm), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody @Valid ClientForm clientForm){
        return new ResponseEntity<>(clientService.updateClient(id, clientForm), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteClientById(@PathVariable Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
