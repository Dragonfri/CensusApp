package com.test.MKYKCensusApp.controllers;

import com.test.MKYKCensusApp.data.entity.MKYKAge;
import com.test.MKYKCensusApp.data.entity.MKYKGeographicArea;
import com.test.MKYKCensusApp.data.entity.MKYKLogin;
import com.test.MKYKCensusApp.data.entity.MKYKUser;
import com.test.MKYKCensusApp.data.repository.MKYKGeographicAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MKYKHomeController {

    @GetMapping("/home")
    public String goHome() {
        System.out.println("In goHome");
        return "MKYKIndex";
    }

    @GetMapping("/goToLogin")
    public String goToLogin(Model model){
        System.out.println("In goToLogin");
        return "MKYKLogin";
    }

    @GetMapping("/goToRegister")
    public String goToRegister(){
        System.out.println("In goToRegister");
        return "MKYKRegister";
    }

    @GetMapping("/goToLevel")
    public String goToLevel(HttpSession session, Model model){
        if (session.getAttribute("user") == null) {
            model.addAttribute("error", "Sign in required");
            return "MKYKLogin";
        }
        System.out.println("In getLevel");
        return "MKYKFindGeoAreaByLevel";
    }

    @GetMapping("/goToKeyword")
    public String goToKeyword(HttpSession session, Model model){
        if (session.getAttribute("user") == null) {
            model.addAttribute("error", "Sign in required");
            return "MKYKLogin";
        }
        System.out.println("In getKeyword");
        return "MKYKFindGeoAreaByKeyword";
    }

    @ModelAttribute("newuser")
    public MKYKUser getDefaultUser() {
        return new MKYKUser();
    }

    @ModelAttribute("login")
    public MKYKLogin getDefaultLogin() {
        return new MKYKLogin();
    }
}
