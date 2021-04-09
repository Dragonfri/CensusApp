package com.test.MKYKCensusApp.controllers;

import com.test.MKYKCensusApp.data.entity.MKYKLogin;
import com.test.MKYKCensusApp.data.entity.MKYKUser;
import com.test.MKYKCensusApp.data.repository.MKYKUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MKYLoginController {

    @Autowired
    private MKYKUserRepository userRepo;

    @PostMapping("/login")
    public String login(@ModelAttribute("login") MKYKLogin login, HttpSession session, Model model){
        System.out.println("In MKYKLoginController");
        if (login==null) {
            model.addAttribute("error", "Please enter username and password");
            return "MKYKLogin";
        }
        MKYKUser user  = userRepo.searchByName(login.getUsername());
        System.out.println(user);
        System.out.println(login);
        if(user==null){
            model.addAttribute("error", "User not found");
            return "MKYKLogin";
        } else if(!user.getPassword().equals(login.getPassword())){
            model.addAttribute("error", "Invalid credentials");
            return "MKYKLogin";
        } else {
            session.setAttribute("login", login);
            session.setAttribute("user", user);
        }
        return "forward:/userprofile";
    }

    @GetMapping("/logout")
    public String signOut(HttpSession session, Model model){
        if (session.getAttribute("user") == null) {
            model.addAttribute("error", "Sign in required");
            return "MKYKLogin";
        }
        session.invalidate();
        return "MKYKIndex";
    }
}
