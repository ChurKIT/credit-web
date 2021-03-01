package com.churkit.credit.web.credit_web.service;

import com.churkit.credit.web.credit_web.entity.Credit;
import com.churkit.credit.web.credit_web.entity.ScheduleOfPayments;

import java.util.List;
import java.util.UUID;

public interface ScheduleOfPaymentsService {

    public List<ScheduleOfPayments> getAllSchedules();
    public ScheduleOfPayments getSchedule(UUID id);
    public void saveSchedule(ScheduleOfPayments scheduleOfPayments);
    public void deleteSchedule(UUID id);
}
