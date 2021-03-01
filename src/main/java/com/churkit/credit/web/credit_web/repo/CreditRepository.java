package com.churkit.credit.web.credit_web.repo;

import com.churkit.credit.web.credit_web.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditRepository extends JpaRepository<Credit, UUID> {
}
