package com.CGIEXAM.cgiexam.controller;

import com.CGIEXAM.cgiexam.model.UsersModel;
import com.CGIEXAM.cgiexam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UsersModel());
        return "register_page";
    }

    @GetMapping("/Home")
    public String home(Model model){
        return "Home";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel){
    UsersModel registeredUser = usersService.registerUser(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
    return registeredUser == null ? "error_message" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model){
        UsersModel authenticated = usersService.authenticate(usersModel.getEmail(), usersModel.getPassword());

        if(authenticated != null){
            model.addAttribute("userLogin", authenticated.getLogin());
            return "Home";
        }else{
            return "error_page";
        }
    }
}
