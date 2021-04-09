package com.test.MKYKCensusApp.controllers;

import com.test.MKYKCensusApp.data.entity.MKYKLogin;
import com.test.MKYKCensusApp.data.entity.MKYKUser;
import com.test.MKYKCensusApp.data.repository.MKYKUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MKYKUserController {

    @Autowired
    private MKYKUserRepository userRepo;

    @PostMapping("/register")
    public String register(@ModelAttribute("newuser") MKYKUser user, Model model){
        System.out.println("in registration controller");
        model.addAttribute("user", user);
        List<String> errors = new ArrayList<>();
        if (user.getUsername() == null || user.getUsername().equals("")) {
            errors.add("Username is required");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            errors.add("Password is required");
        }
        if (user.getEmail() == null || user.getEmail().equals("")) {
            errors.add("Email is required");
        }
        if (errors.size() > 0) {
            model.addAttribute("error", errors);
            return "MKYKRegister";
        }
        userRepo.save(user);
        MKYKLogin login = new MKYKLogin();
        login.setUsername(user.getUsername());
        login.setPassword(user.getPassword());
        model.addAttribute("login", login);
        return "MKYKLogin";
    }

    @PostMapping("/userprofile")
    public String getProfile(@SessionAttribute("login")MKYKLogin login, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            model.addAttribute("error", "Sign in required");
            return "MKYKLogin";
        }
        MKYKUser user = userRepo.searchByName(login.getUsername());
        model.addAttribute("user", user);
        return "MKYKWelcome";
    }
}
