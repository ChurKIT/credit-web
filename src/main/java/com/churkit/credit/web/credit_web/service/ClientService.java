package com.churkit.credit.web.credit_web.service;

import com.churkit.credit.web.credit_web.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    public List<Client> getAllClients();
    public Client getClient(UUID id);
    public void saveClient(Client client);
    public void deleteClient(UUID id);

}
