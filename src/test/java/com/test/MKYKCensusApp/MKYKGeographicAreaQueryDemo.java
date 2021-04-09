package com.test.MKYKCensusApp;
import com.test.MKYKCensusApp.data.entity.MKYKGeographicArea;
import com.test.MKYKCensusApp.data.repository.MKYKGeographicAreaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MKYKGeographicAreaQueryDemo {

    @Autowired
    public MKYKGeographicAreaRepository geographicAreaRepository;


    @Test
    public void MKYKQueryByLevelZero(){
        System.out.println("MKYKQueryByLevelZero() : Find areas with level 0");
        geographicAreaRepository.findByLevel(0).forEach( geoArea -> {
            System.out.println("Area name, alternative code: " + geoArea.getName() +
                    ", " + geoArea.getAlternativeCode() +
                    ", " + "( " + geoArea.getGeographicAreaId() + " ) ");
        });
    }

    @Test
    public void MKYKQueryByLevelOne(){
        System.out.println("MKYKQueryByLevelOne() : Find areas with level 1");
        geographicAreaRepository.findByLevel(1).forEach( geoArea -> {
            System.out.println("Area name, alternative code: " + geoArea.getName() +
                    ", " + geoArea.getAlternativeCode() +
                    ", " + "(ID:  " + geoArea.getGeographicAreaId() + " ) ");
        });
    }

    @Test
    public void MKYKQueryByNameOntario(){
        System.out.println("MKYKQueryByNameOntario() : Find areas with name: Ontario");
        geographicAreaRepository.findByName("Ontario").forEach( geoArea -> {
            System.out.println("Area name, alternative code: " + geoArea.getName() +
                    ", " + geoArea.getAlternativeCode() +
                    ", " + "(ID:  " + geoArea.getGeographicAreaId() + " ) ");
        });
    }

    @Test
    public void MKYKQueryByNameLikeLoo(){
        System.out.println("MKYKQueryByNameLikeLoo() : Find areas with name like %Loo%");
        geographicAreaRepository.findByNameLike("%Loo%").forEach( geoArea -> {
            System.out.println("Area name, alternative code: " + geoArea.getName() +
                    ", " + geoArea.getAlternativeCode() +
                    ", " + "(ID: " + geoArea.getGeographicAreaId() + " ) ");
        });
    }

    @Before
    @After
    public  void banner(){
        System.out.println("\n\n-------------------------------------------------" +
                "-------------------------------------\n");
    }
}
