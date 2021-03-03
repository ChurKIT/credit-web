package com.churkit.credit.web.credit_web.controller;

import com.churkit.credit.web.credit_web.entity.Credit;
import com.churkit.credit.web.credit_web.entity.CreditOffer;
import com.churkit.credit.web.credit_web.service.CreditOfferService;
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
@RequestMapping("/creditOffers")
public class CreditOfferController {

    @Autowired
    CreditOfferService creditOfferService;

    @GetMapping("/allCreditOffers")
    public String showAllCreditOffers(Model model){
        List<CreditOffer> allCreditOffers = creditOfferService.getAllCreditOffers();
        model.addAttribute("allCreditOffers", allCreditOffers);
        return "all-creditOffers";
    }

    @GetMapping("/creditOfferAddForm")
    public String showAddingForm(Credit credit) {
        return "add-creditOffer";
    }

    @PostMapping("/addCredit")
    public String addCreditOffer(@Valid CreditOffer creditOffer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-creditOffer";
        }
        creditOfferService.saveCreditOffer(creditOffer);
        return "redirect:/index.html";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") UUID id, Model model) {
        CreditOffer creditOffer = creditOfferService.getCreditOffer(id);
        model.addAttribute("creditOffer", creditOffer);
        return "update-creditOffer";
    }

    @PostMapping("/edit/update/{id}")
    public String updateCreditOffer(@PathVariable("id") UUID id, @Valid CreditOffer creditOffer,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-creditOffer";
        }
        creditOfferService.saveCreditOffer(creditOffer);
        return "redirect:/index.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteCreditOffer(@PathVariable("id") UUID id, Model model) {
        creditOfferService.deleteCreditOffer(id);
        return "redirect:/index.html";
    }
}
