package com.test.MKYKCensusApp;

import com.test.MKYKCensusApp.business.domain.MKYKGeoAreaPopulation;
import com.test.MKYKCensusApp.business.service.MKYKPopulationService;
import com.test.MKYKCensusApp.data.entity.MKYKAge;
import com.test.MKYKCensusApp.data.entity.MKYKGeographicArea;
import com.test.MKYKCensusApp.data.repository.MKYKAgeRepository;
import com.test.MKYKCensusApp.data.repository.MKYKGeographicAreaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MKYKPopulationServiceDemo {


    @Autowired
    private MKYKGeoAreaPopulation geoAreaPopulation;

    @Autowired
    MKYKPopulationService service;


    @Test
    public void MkykGetGeoAreaPopulationForAltCode1(){
        geoAreaPopulation = service.getGeoAreaPopulationForAltCode(1);
        System.out.println("*****************************");
        System.out.println("In MKYKGetPopulationForAltCode1(): Alt Code 1 " + geoAreaPopulation.getGeoAreaName());
        System.out.println("Geographic Area ID, Name, Alt Code: " + geoAreaPopulation.getGeoAreaId() + ", "
        + geoAreaPopulation.getGeoAreaName() + ", " + geoAreaPopulation.getGeoAreaAltCode()
        + " ( Population -- Total, Male, Female: " + geoAreaPopulation.getGeoAreaCombined()
        + ", " + geoAreaPopulation.getGeoAreaMale() + ", " + geoAreaPopulation.getGeoAreaFemale() + " )");
    }

    @Test
    public void MkykGetGeoAreaPopulationForAltCode35(){
        geoAreaPopulation = service.getGeoAreaPopulationForAltCode(35);
        System.out.println("*****************************");
        System.out.println("In MKYKGetPopulationForAltCode1(): Alt Code 35 " + geoAreaPopulation.getGeoAreaName());
        System.out.println("Geographic Area ID, Name, Alt Code: " + geoAreaPopulation.getGeoAreaId() + ", "
        + geoAreaPopulation.getGeoAreaName() + ", " + geoAreaPopulation.getGeoAreaAltCode()
        + " ( Population -- Total, Male, Female: " + geoAreaPopulation.getGeoAreaCombined()
        + ", " + geoAreaPopulation.getGeoAreaMale() + ", " + geoAreaPopulation.getGeoAreaFemale() + " )");
    }

    @Test
    public void MkykGetGeoAreaPopulationForAltCode35541(){
        geoAreaPopulation = service.getGeoAreaPopulationForAltCode(35541);
        System.out.println("*****************************");
        System.out.println("In MKYKGetPopulationForAltCode1(): Alt Code 35541 " + geoAreaPopulation.getGeoAreaName());
        System.out.println("Geographic Area ID, Name, Alt Code: " + geoAreaPopulation.getGeoAreaId() + ", "
        + geoAreaPopulation.getGeoAreaName() + ", " + geoAreaPopulation.getGeoAreaAltCode()
        + " ( Population -- Total, Male, Female: " + geoAreaPopulation.getGeoAreaCombined()
        + ", " + geoAreaPopulation.getGeoAreaMale() + ", " + geoAreaPopulation.getGeoAreaFemale() + " )");
    }

    @Test
    public void MkykGetGeoAreaPopulationForLevelZero() {
        List<MKYKGeoAreaPopulation> list = service.getGeoAreaPopulationForLevel(0);
        System.out.println("In MkykGetGeoAreaPopulationForLevelZero: Level 0 (" + list.get(0).getGeoAreaName() + " )");
        System.out.println("Number of elements to display: " + list.size());
        list.forEach(area -> {
            System.out.println("Geographic Area ID, Name, Alt code: " + area.getGeoAreaId()
                    + ", " + area.getGeoAreaName() + ", " + area.getGeoAreaAltCode()
                    + " (Population -- Total, Male, Female: " + area.getGeoAreaCombined()
                    + "," + area.getGeoAreaMale() + ", " + area.getGeoAreaFemale() + " )");
        });
    }

    @Test
    public void MkykGetGeoAreaPopulationForLevelOne(){
        List<MKYKGeoAreaPopulation> list = service.getGeoAreaPopulationForLevel(1);
        System.out.println("In MkykGetGeoAreaPopulationForLevelZero: Level 1 (" + list.get(0).getGeoAreaName() + " )"  );
        System.out.println("Number of elements to display: " + list.size() );
        list.forEach(area -> {
            System.out.println("Geographic Area ID, Name, Alt code: " + area.getGeoAreaId()
            + ", " + area.getGeoAreaName() + ", " + area.getGeoAreaAltCode()
            + " (Population -- Total, Male, Female: " + area.getGeoAreaCombined()
            + "," + area.getGeoAreaMale() + ", " + area.getGeoAreaFemale() + " )");
        });
    }

    @Test
    public void MkykGetGeoAreaPopulationForLevelTwo(){
        List<MKYKGeoAreaPopulation> list = service.getGeoAreaPopulationForLevel(2);
        System.out.println("In MkykGetGeoAreaPopulationForLevelZero: Level 2 (" + list.get(0).getGeoAreaName() + " )"  );
        System.out.println("Number of elements to display: " + list.size() );
        list.forEach(area -> {
            System.out.println("Geographic Area ID, Name, Alt code: " + area.getGeoAreaId()
            + ", " + area.getGeoAreaName() + ", " + area.getGeoAreaAltCode()
            + " (Population -- Total, Male, Female: " + area.getGeoAreaCombined()
            + "," + area.getGeoAreaMale() + ", " + area.getGeoAreaFemale() + " )");
        });
    }

    @Test
    public void MkykGetGeoAreaPopulationForLevelThree(){
        List<MKYKGeoAreaPopulation> list = service.getGeoAreaPopulationForLevel(3);
        System.out.println("In MkykGetGeoAreaPopulationForLevelZero: Level 3 (" + list.get(0).getGeoAreaName() + " )"  );
        System.out.println("Number of elements to display: " + list.size() );
        list.forEach(area -> {
            System.out.println("Geographic Area ID, Name, Alt code: " + area.getGeoAreaId()
            + ", " + area.getGeoAreaName() + ", " + area.getGeoAreaAltCode()
            + " (Population -- Total, Male, Female: " + area.getGeoAreaCombined()
            + "," + area.getGeoAreaMale() + ", " + area.getGeoAreaFemale() + " )");
        });
    }
}
