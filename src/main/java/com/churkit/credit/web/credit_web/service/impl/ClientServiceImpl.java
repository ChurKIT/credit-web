package com.churkit.credit.web.credit_web.service.impl;

import com.churkit.credit.web.credit_web.dao.ClientDAO;
import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    @Transactional
    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    @Override
    @Transactional
    public Client getClient(UUID id) {
        return clientDAO.getClient(id);
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    @Transactional
    public void deleteClient(UUID id) {
        clientDAO.deleteClient(id);
    }
}
