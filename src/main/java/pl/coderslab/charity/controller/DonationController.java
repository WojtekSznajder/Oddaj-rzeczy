package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {


    private CategoryRepository categoryRepository;
    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;


    public DonationController(CategoryRepository categoryRepository,DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }


    @GetMapping("")
    public String form(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);
        model.addAttribute("donation", new Donation());
        return "donation";
    }


    @PostMapping("")
    public void postForm(@ModelAttribute Donation donation, Model model){
        donationRepository.save(donation);
    }


//    @ModelAttribute("categories")
//    public Collection<Category> categories() {
//        List<Category> categories = categoryRepository.findAll();
//        return categories;
//    }
//
//
//    @ModelAttribute("institutions")
//    public  Collection<Institution> institutions(){
//        List<Institution> institutions = institutionRepository.findAll();
//        return institutions;
//    }

}
