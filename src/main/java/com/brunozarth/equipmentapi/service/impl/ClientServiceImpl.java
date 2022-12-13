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
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new BadRequestException("Equipment id not found!"));
    }

    @Override
    public Client saveClient(ClientForm clientForm) {
        Client client = new Client();

        if(clientForm.getAdress() == null) clientForm.setAdress("not informed"); else client.setAdress(clientForm.getAdress());
        if(clientForm.getEmail() == null) clientForm.setEmail("not informed"); else client.setEmail(clientForm.getEmail());
        if(clientForm.getPhone() == null) clientForm.setPhone("not informed"); else client.setPhone(clientForm.getPhone());

        client.setName(clientForm.getName());

        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, ClientForm clientForm) {

        Client client = this.findById(id);

        if(clientForm.getAdress() == null) clientForm.setAdress("not informed"); else client.setAdress(clientForm.getAdress());
        if(clientForm.getEmail() == null) clientForm.setEmail("not informed"); else client.setEmail(clientForm.getEmail());
        if(clientForm.getPhone() == null) clientForm.setPhone("not informed"); else client.setPhone(clientForm.getPhone());

        client.setName(clientForm.getName());

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = this.findById(id);
        clientRepository.delete(client);
    }
}
