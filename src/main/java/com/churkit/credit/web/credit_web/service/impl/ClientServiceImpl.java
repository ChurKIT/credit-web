package com.churkit.credit.web.credit_web.service.impl;

import com.churkit.credit.web.credit_web.repo.ClientRepository;
import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(UUID id) {
        Client client = null;
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            client = optionalClient.get();
        }
        //TODO обработать null
        return client;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }
}
