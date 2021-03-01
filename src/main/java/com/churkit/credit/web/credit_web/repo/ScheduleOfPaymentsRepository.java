package com.churkit.credit.web.credit_web.repo;

import com.churkit.credit.web.credit_web.entity.ScheduleOfPayments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduleOfPaymentsRepository extends JpaRepository<ScheduleOfPayments, UUID> {
}
