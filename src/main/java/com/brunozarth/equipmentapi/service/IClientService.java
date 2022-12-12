package com.brunozarth.equipmentapi.service;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.form.ClientForm;

import java.util.List;

public interface IClientService {

    //GET / READ
    List<Client> findAll();

    List<Client> findByName(String name);

    Client findById(Long id);

    //POST / CREATE
    Client saveClient(ClientForm clientForm);

    //UPDATE
    Client updateClient(Long id, ClientForm clientForm);

    //DELETE
    void deleteClient(Long id);
}
