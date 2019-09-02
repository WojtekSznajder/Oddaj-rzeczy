package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;


@Controller
public class HomeController {


    private DonationRepository donationRepository;

    public HomeController(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", donationRepository.quantityOfDonatedInstitutions());

        model.addAttribute("bags", donationRepository.sumOfBags());


        model.addAttribute("listInstitutions", donationRepository.allInstitutions());
        return "index";
    }
}
