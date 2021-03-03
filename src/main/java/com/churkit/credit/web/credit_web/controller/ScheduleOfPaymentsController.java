package com.churkit.credit.web.credit_web.controller;

import com.churkit.credit.web.credit_web.entity.Credit;
import com.churkit.credit.web.credit_web.entity.ScheduleOfPayments;
import com.churkit.credit.web.credit_web.service.ScheduleOfPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/schedules")
public class ScheduleOfPaymentsController {

    @Autowired
    private ScheduleOfPaymentsService scheduleOfPaymentsService;

    @GetMapping("/allSchedules")
    public String showAllSchedules(Model model){
        List<ScheduleOfPayments> scheduleOfPaymentsList = scheduleOfPaymentsService.getAllSchedules();
        model.addAttribute("allSchedules", scheduleOfPaymentsList);
        return "all-schedules";
    }

    @GetMapping("/scheduleAddForm")
    public String showAddingForm(ScheduleOfPayments scheduleOfPayments){
        return "add-schedule";
    }

    @GetMapping("/addSchedule")
    public String addSchedule(@Valid ScheduleOfPayments scheduleOfPayments, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-schedule";
        }
        scheduleOfPaymentsService.saveSchedule(scheduleOfPayments);
        return "redirect:/index.html";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id")UUID id, Model model){
        ScheduleOfPayments scheduleOfPayments = scheduleOfPaymentsService.getSchedule(id);
        model.addAttribute("schedule", scheduleOfPayments);
        return "update-schedule";
    }

    @PostMapping("/edit/update/{id}")
    public String updateSchedule(@PathVariable("id") UUID id, @Valid ScheduleOfPayments scheduleOfPayments,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-schedule";
        }
        scheduleOfPaymentsService.saveSchedule(scheduleOfPayments);
        return "redirect:/index.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable("id") UUID id, Model model) {
        scheduleOfPaymentsService.deleteSchedule(id);
        return "redirect:/index.html";
    }
}


