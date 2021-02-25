package com.churkit.credit.web.credit_web.dao.impl;

import com.churkit.credit.web.credit_web.dao.ClientDAO;
import com.churkit.credit.web.credit_web.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> getAllClients() {
        Query query = entityManager.createQuery("from Client");
        List<Client> allClients = query.getResultList();
        return allClients;
    }
}
