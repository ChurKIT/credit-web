package com.churkit.credit.web.credit_web.controller;


import com.churkit.credit.web.credit_web.entity.Bank;
import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.service.BankService;
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
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/allBanks")
    public String showAllBanks(Model model){
        List<Bank> allBanks = bankService.getAllBanks();
        model.addAttribute("allBanks", allBanks);
        return "all-banks";
    }

    @GetMapping("/bankAddForm")
    public String showAddingForm(Bank bank) {
        return "add-bank";
    }


    @PostMapping("/addBank")
    public String addBank(@Valid Bank bank, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-bank";
        }

        bankService.saveBank(bank);
        return "redirect:/index.html";
    }


    @GetMapping("/delete/{id}")
    public String deleteBank(@PathVariable("id") UUID id, Model model) {
        bankService.deleteBank(id);
        return "redirect:/index.html";
    }


}
