package com.test.MKYKCensusApp.web.restcontroller;

import com.test.MKYKCensusApp.business.domain.MKYKGeoAreaPopulation;
import com.test.MKYKCensusApp.business.service.MKYKPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="census/api")
public class MKYKPopulationServiceRestController {

    @Autowired
    private MKYKPopulationService populationService;

    @RequestMapping(method = RequestMethod.GET, value = "population/level/{level}")
    public List<MKYKGeoAreaPopulation> findPopulationTotalsByLevel(@PathVariable(value="level") int level) {
        return populationService.getGeoAreaPopulationForLevel(level);
    }

    @RequestMapping(method = RequestMethod.GET, value = "population/altCode/{altCode}")
    public MKYKGeoAreaPopulation findPopulationTotalsByAltCode(@PathVariable(value = "altCode") int altCode){
        return populationService.getGeoAreaPopulationForAltCode(altCode);
    }
}
