package com.brunozarth.equipmentapi.service.impl;

import com.brunozarth.equipmentapi.entity.Client;
import com.brunozarth.equipmentapi.entity.form.ClientForm;
import com.brunozarth.equipmentapi.exception.BadRequestException;
import com.brunozarth.equipmentapi.repository.ClientRepository;
import com.brunozarth.equipmentapi.service.IClientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements IClientService {

    ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public List<Client> findByName(String name) {
        return null;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BadRequestException("Equipment id not found!"));
    }

    @Override
    public Client saveClient(ClientForm clientForm) {
        return null;
    }

    @Override
    public Client updateClient(Long id, ClientForm clientForm) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }
}
