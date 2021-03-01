package com.churkit.credit.web.credit_web.service;

import com.churkit.credit.web.credit_web.entity.Credit;
import com.churkit.credit.web.credit_web.entity.CreditOffer;

import java.util.List;
import java.util.UUID;

public interface CreditOfferService {

    public List<CreditOffer> getAllCreditOffers();
    public CreditOffer getCreditOffer(UUID id);
    public void saveCreditOffer(CreditOffer creditOffer);
    public void deleteCreditOffer(UUID id);
}
