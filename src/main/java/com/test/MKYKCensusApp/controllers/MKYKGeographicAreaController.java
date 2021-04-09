package com.test.MKYKCensusApp.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.test.MKYKCensusApp.data.entity.MKYKAge;
import com.test.MKYKCensusApp.data.entity.MKYKGeographicArea;
import com.test.MKYKCensusApp.data.entity.MKYKUser;
import com.test.MKYKCensusApp.data.repository.MKYKAgeRepository;
import com.test.MKYKCensusApp.data.repository.MKYKGeographicAreaRepository;
import com.test.MKYKCensusApp.data.repository.MKYKUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MKYKGeographicAreaController {
    @Autowired
    private MKYKGeographicAreaRepository geoRepo;

    @Autowired
    private MKYKAgeRepository ageRpo;

    @Autowired
    private MKYKUserRepository userRepo;

    @GetMapping("/searchByLevel")
    public String findGeoByLevel(@RequestParam("mkyk_level") String level, Model model, HttpSession session){

        System.out.println("In MKYKGeographicAreaController");
        if (session.getAttribute("user")==null){
            model.addAttribute("error", "Sign in required");
            return "MKYKLogin";
        }
        System.out.println(("Search by ") + level);

        List<MKYKGeographicArea> geoList = new ArrayList<>();
        geoList = geoRepo.findByLevel(Integer.parseInt(level));
        model.addAttribute("mkyk_geoList", geoList);
        model.addAttribute("currentLevel", level);

        return "MKYKFindGeoAreaByLevel";
    }

    @GetMapping("/searchByKeyword")
    public String findGeoByKeyword(@RequestParam("mkyk_keyword") String keyword, Model model, HttpSession session){

        System.out.println("In DKJWGeographicAreaController");
        if (session.getAttribute("user") == null) {
            model.addAttribute("error", "Sign in required");
            return "MKYKLogin";
        }
        System.out.println("Search by " + keyword);

        List<MKYKGeographicArea> geoList = new ArrayList<>();
        geoList = geoRepo.findByNameLike("%" + keyword + "%");
        model.addAttribute("mkyk_geoList", geoList);
        model.addAttribute("currentKeyword", keyword);

        return "MKYKFindGeoAreaByKeyword";
    }

    @GetMapping("/details")
    public String findGeoDetails(@RequestParam("mkyk_altcode") int id, Model model, HttpServletRequest request){
        System.out.println("In findGeoDetails");
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            MKYKUser user = (MKYKUser)session.getAttribute("user");
            System.out.println("User in sesson: " + user.getUsername());
            user.setLastGeographicArea(id);
            userRepo.save(user);
        }
        else{
            model.addAttribute("error", "Sign in required");
            return "MKYKLogin";
        }
        Iterable<MKYKGeographicArea> geoList = geoRepo.findAll();
        for (MKYKGeographicArea geo : geoList){
            if (geo.getAlternativeCode() == id){
                model.addAttribute("geo", geo);
                List<MKYKAge> ageList = ageRpo.findByGeographicAreaAltCode(geo.getAlternativeCode());
                for (MKYKAge age : ageList){
                    if (age.getAgeGroup() != 1 && age.getCensusYear() == 1){
                        model.addAttribute("combined", String.format("%,d", age.getCombined()));
                        model.addAttribute("male", String.format("%,d", age.getMale()));
                        model.addAttribute("female", String.format("%,d", age.getFemale()));
                    }
                }
            }
        }
        return "MKYKGeoAreaDetails";
    }
}
