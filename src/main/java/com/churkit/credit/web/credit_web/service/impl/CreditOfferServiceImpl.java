package com.churkit.credit.web.credit_web.service.impl;

import com.churkit.credit.web.credit_web.entity.CreditOffer;
import com.churkit.credit.web.credit_web.repo.CreditOfferRepository;
import com.churkit.credit.web.credit_web.service.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreditOfferServiceImpl implements CreditOfferService {

    @Autowired
    private CreditOfferRepository creditOfferRepository;

    @Override
    public List<CreditOffer> getAllCreditOffers() {
        return creditOfferRepository.findAll();
    }

    @Override
    public CreditOffer getCreditOffer(UUID id) {
        CreditOffer creditOffer = null;
        Optional<CreditOffer> optionalCreditOffer = creditOfferRepository.findById(id);
        if (optionalCreditOffer.isPresent()){
            creditOffer = optionalCreditOffer.get();
        }
        //TODO обработать null
        return creditOffer;
    }

    @Override
    public void saveCreditOffer(CreditOffer creditOffer) {
        creditOfferRepository.save(creditOffer);
    }

    @Override
    public void deleteCreditOffer(UUID id) {
        creditOfferRepository.deleteById(id);
    }
}
