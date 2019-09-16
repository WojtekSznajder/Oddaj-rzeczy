package pl.coderslab.charity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.service.UserServiceImpl;

@Controller
public class AuthenticationController {


    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLogin(  ModelAndView modelAndView, Model model, User user) {
        modelAndView.addObject("login", new User());
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView saveUser(ModelAndView modelAndView, @ModelAttribute("user") User user, Model model) {
        User userExist = userService.findUserByEmail(user.getEmail());
        if (userExist != null) {
            return modelAndView;
        } else {
            userService.saveUser(user);
            model.addAttribute("user", new User());
            return modelAndView;
        }
    }

}
