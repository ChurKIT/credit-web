package com.churkit.credit.web.credit_web.controller;

import com.churkit.credit.web.credit_web.entity.Client;
import com.churkit.credit.web.credit_web.entity.Credit;
import com.churkit.credit.web.credit_web.service.CreditService;
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
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    CreditService creditService;

    @GetMapping("/allCredits")
    public String showAllCredits(Model model){
        List<Credit> allCredits = creditService.getAllCredits();
        model.addAttribute("allCredits", allCredits);
        return "all-credits";
    }

    @GetMapping("/creditAddForm")
    public String showAddingForm(Credit credit) {
        return "add-credit";
    }

    @PostMapping("/addCredit")
    public String addCredit(@Valid Credit credit, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-credit";
        }
        creditService.saveCredit(credit);
        return "redirect:/index.html";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") UUID id, Model model) {
        Credit credit = creditService.getCredit(id);
        model.addAttribute("credit", credit);
        return "update-credit";
    }

    @PostMapping("/edit/update/{id}")
    public String updateCredit(@PathVariable("id") UUID id, @Valid Credit credit,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-credit";
        }
        creditService.saveCredit(credit);
        return "redirect:/index.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteCredit(@PathVariable("id") UUID id, Model model) {
        creditService.deleteCredit(id);
        return "redirect:/index.html";
    }
}
