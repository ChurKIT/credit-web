package com.churkit.credit.web.credit_web.service;

import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.entity.Credit;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    public List<Credit> getAllCredits();
    public Credit getCredit(UUID id);
    public void saveCredit(Credit credit);
    public void deleteCredit(UUID id);

}
