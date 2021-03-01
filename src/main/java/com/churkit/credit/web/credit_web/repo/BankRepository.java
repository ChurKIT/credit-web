package com.churkit.credit.web.credit_web.repo;

import com.churkit.credit.web.credit_web.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
}
