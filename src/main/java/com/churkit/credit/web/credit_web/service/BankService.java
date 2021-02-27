package com.churkit.credit.web.credit_web.service;

import com.churkit.credit.web.credit_web.entity.Bank;
import com.churkit.credit.web.credit_web.entity.Client;

import java.util.List;
import java.util.UUID;

public interface BankService {

    public List<Bank> getAllBanks();
    public Bank getBank(UUID id);
    public void saveBank(Bank bank);
    public void deleteBank(UUID id);
}
