package com.churkit.credit.web.credit_web.dao.impl;

import com.churkit.credit.web.credit_web.dao.ClientDAO;
import com.churkit.credit.web.credit_web.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> getAllClients() {
        Query query = entityManager.createQuery("select c from Client c");
        List<Client> allClients = query.getResultList();
        return allClients;
    }

    @Override
    public Client getClient(UUID id){
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    @Override
    public void saveClient(Client client){
        entityManager.merge(client);
    }

    @Override
    public void deleteClient(UUID id){
        Query query = entityManager.createQuery("delete from Client where id =:clientId");
        query.setParameter("clientId", id);
        query.executeUpdate();
    }
}
