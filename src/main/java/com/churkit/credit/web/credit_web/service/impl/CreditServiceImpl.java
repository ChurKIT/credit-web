package com.churkit.credit.web.credit_web.service.impl;

import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.entity.Credit;
import com.churkit.credit.web.credit_web.repo.CreditRepository;
import com.churkit.credit.web.credit_web.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Credit getCredit(UUID id) {
        Credit credit = null;
        Optional<Credit> optionalCredit = creditRepository.findById(id);
        if (optionalCredit.isPresent()){
            credit = optionalCredit.get();
        }
        //TODO обработать null
        return credit;
    }

    @Override
    public void saveCredit(Credit credit) {
        creditRepository.save(credit);
    }

    @Override
    public void deleteCredit(UUID id) {
        creditRepository.deleteById(id);
    }
}
