package com.churkit.credit.web.credit_web.dao;

import com.churkit.credit.web.credit_web.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
