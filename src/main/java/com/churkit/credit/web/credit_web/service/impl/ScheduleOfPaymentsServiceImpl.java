package com.churkit.credit.web.credit_web.service.impl;

import com.churkit.credit.web.credit_web.entity.ScheduleOfPayments;
import com.churkit.credit.web.credit_web.repo.ScheduleOfPaymentsRepository;
import com.churkit.credit.web.credit_web.service.ScheduleOfPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleOfPaymentsServiceImpl implements ScheduleOfPaymentsService {

    @Autowired
    private ScheduleOfPaymentsRepository scheduleOfPaymentsRepository;

    @Override
    public List<ScheduleOfPayments> getAllSchedules() {
        return scheduleOfPaymentsRepository.findAll();
    }

    @Override
    public ScheduleOfPayments getSchedule(UUID id) {
        ScheduleOfPayments scheduleOfPayments = null;
        Optional<ScheduleOfPayments> optionalScheduleOfPayments = scheduleOfPaymentsRepository.findById(id);
        if(optionalScheduleOfPayments.isPresent()){
            scheduleOfPayments = optionalScheduleOfPayments.get();
        }
        //TODO обработать null
        return scheduleOfPayments;
    }

    @Override
    public void saveSchedule(ScheduleOfPayments scheduleOfPayments) {
        scheduleOfPaymentsRepository.save(scheduleOfPayments);
    }

    @Override
    public void deleteSchedule(UUID id) {
        scheduleOfPaymentsRepository.deleteById(id);
    }
}
