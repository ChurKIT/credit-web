package com.churkit.credit.web.credit_web.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "schedule_of_payments")
public class ScheduleOfPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private UUID id;

    @Column(name = "date_of_payment")
    private Date dateOfPayment;

    @Column(name = "payment_sum")
    private int paymentSum;

    @Column(name = "sum_damping_credit")
    private int sumDampingCredit;

    @Column(name = "sum_damping_percents")
    private int sumDampingPercents;

    public ScheduleOfPayments() {
    }

    public ScheduleOfPayments(Date dateOfPayment, int paymentSum, int sumDampingCredit, int sumDampingPercents) {
        this.dateOfPayment = dateOfPayment;
        this.paymentSum = paymentSum;
        this.sumDampingCredit = sumDampingCredit;
        this.sumDampingPercents = sumDampingPercents;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(int paymentSum) {
        this.paymentSum = paymentSum;
    }

    public int getSumDampingCredit() {
        return sumDampingCredit;
    }

    public void setSumDampingCredit(int sumDampingCredit) {
        this.sumDampingCredit = sumDampingCredit;
    }

    public int getSumDampingPercents() {
        return sumDampingPercents;
    }

    public void setSumDampingPercents(int sumDampingPercents) {
        this.sumDampingPercents = sumDampingPercents;
    }
}
