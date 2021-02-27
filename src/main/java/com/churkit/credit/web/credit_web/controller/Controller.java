package com.churkit.credit.web.credit_web.controller;

import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ClientService clientService;

    @GetMapping("/allClients")
    public List<Client> showAllClients(){
        List<Client> allClients = clientService.getAllClients();
        return allClients;
    }

    @GetMapping("/getClient/{id}")
    public Client showClientByUUID(@PathVariable UUID id){
        Client client = clientService.getClient(id);
        return client;
    }
}
