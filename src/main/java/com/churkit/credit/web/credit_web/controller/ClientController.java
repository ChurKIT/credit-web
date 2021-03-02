package com.churkit.credit.web.credit_web.controller;

import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/allClients")
    public String showAllClients(Model model){
        List<Client> allClients = clientService.getAllClients();
        model.addAttribute("allClients", allClients);
        return "all-clients";
    }

    @GetMapping("/clientAddForm")
    public String showAddingForm(Client client) {
        return "add-client";
    }

    @PostMapping("/addClient")
    public String addUser(@Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-client";
        }
        clientService.saveClient(client);
        return "redirect:/index.html";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") UUID id, Model model) {
        Client client = clientService.getClient(id);
        model.addAttribute("client", client);
        return "update-client";
    }

    @PostMapping("/edit/update/{id}")
    public String updateClient(@PathVariable("id") UUID id, @Valid Client client,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-client";
        }
        clientService.saveClient(client);
        return "redirect:/index.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") UUID id, Model model) {
        clientService.deleteClient(id);
        return "redirect:/index.html";
    }

//    @GetMapping("/client/{id}")
//    public Client showClientByUUID(@PathVariable UUID id){
//        Client client = clientService.getClient(id);
//        return client;
//    }
//
//    @PostMapping("/saveClient")
//    public void addNewClient(@RequestBody Client client){
//        clientService.saveClient(client);
//    }
//    @DeleteMapping("/deletecClient/{id}")
//    public void deleteClient(@PathVariable UUID id){
//        clientService.deleteClient(id);
//    }

}
