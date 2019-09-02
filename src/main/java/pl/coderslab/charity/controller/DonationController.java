package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {


    private CategoryRepository categoryRepository;

    public DonationController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("")
    public String form(Model model) {
//        model.addAttribute("categories", categoryRepository.findAll());
//        model.addAttribute("donation", new Donation());
        return "donation";
    }
//
//    @ModelAttribute("donation")
//    public List<Category> categories() {
//        return categoryRepository.findAll();
//    }
}
