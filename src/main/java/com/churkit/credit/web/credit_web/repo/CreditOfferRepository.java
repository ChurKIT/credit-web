package com.churkit.credit.web.credit_web.repo;

import com.churkit.credit.web.credit_web.entity.CreditOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditOfferRepository extends JpaRepository<CreditOffer, UUID> {
}
