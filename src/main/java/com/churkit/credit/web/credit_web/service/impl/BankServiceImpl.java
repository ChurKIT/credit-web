package com.churkit.credit.web.credit_web.service.impl;

import com.churkit.credit.web.credit_web.entity.Bank;
import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.repo.BankRepository;
import com.churkit.credit.web.credit_web.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankRepository bankRepository;


    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBank(UUID id) {
        Bank bank = null;
        Optional<Bank> optionalBank = bankRepository.findById(id);
        if (optionalBank.isPresent()){
            bank = optionalBank.get();
        }
        //TODO обработать null
        return bank;
    }

    @Override
    public void saveBank(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public void deleteBank(UUID id) {
        bankRepository.deleteById(id);
    }
}
