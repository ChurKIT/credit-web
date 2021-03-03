package com.churkit.credit.web.credit_web.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "limit")
    private int limit;

    @Column(name = "percent")
    private double percent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Credit() {
    }

    public Credit(int limit, double percent) {
        this.limit = limit;
        this.percent = percent;
    }

    public Credit(int limit, double percent, Bank bank) {
        this.limit = limit;
        this.percent = percent;
        this.bank = bank;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
