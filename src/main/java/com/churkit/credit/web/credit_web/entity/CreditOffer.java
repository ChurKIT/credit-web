package com.churkit.credit.web.credit_web.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "creditoffers")
public class CreditOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_id")
    private Credit credit;

    @Column(name = "credit_sum")
    private int creditSum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_of_payments")
    private ScheduleOfPayments scheduleOfPayments;

    public CreditOffer() {
    }

    public CreditOffer(Client client, Credit credit, int creditSum, ScheduleOfPayments scheduleOfPayments) {
        this.client = client;
        this.credit = credit;
        this.creditSum = creditSum;
        this.scheduleOfPayments = scheduleOfPayments;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int creditSum) {
        this.creditSum = creditSum;
    }

    public ScheduleOfPayments getScheduleOfPayments() {
        return scheduleOfPayments;
    }

    public void setScheduleOfPayments(ScheduleOfPayments scheduleOfPayments) {
        this.scheduleOfPayments = scheduleOfPayments;
    }
}
