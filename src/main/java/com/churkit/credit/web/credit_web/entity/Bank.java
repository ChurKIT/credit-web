package com.churkit.credit.web.credit_web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "banks")
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "bank")
    private transient List<Credit> creditList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "bank")
    private transient List<Client> clientList;


    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public void addClientToBank(Client client){
        if ( clientList == null){
            clientList = new ArrayList<>();
        }
        clientList.add(client);
        client.setBank(this);
    }

    public void addCreditToBank(Credit credit){
        if (creditList == null){
            creditList = new ArrayList<>();
        }
        creditList.add(credit);
        credit.setBank(this);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
