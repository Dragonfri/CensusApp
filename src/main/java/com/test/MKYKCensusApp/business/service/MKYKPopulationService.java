package com.test.MKYKCensusApp.business.service;

import com.test.MKYKCensusApp.business.domain.MKYKGeoAreaPopulation;
import com.test.MKYKCensusApp.data.entity.MKYKAge;
import com.test.MKYKCensusApp.data.entity.MKYKGeographicArea;
import com.test.MKYKCensusApp.data.repository.MKYKAgeRepository;
import com.test.MKYKCensusApp.data.repository.MKYKGeographicAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MKYKPopulationService {

    @Autowired
    MKYKGeographicAreaRepository geoRepo;

    @Autowired
    MKYKAgeRepository ageRepo;

    public MKYKGeoAreaPopulation getGeoAreaPopulationForAltCode(int altCode){

//        Integer geoAreaId, String geoAreaName, Integer geoAreaCode,
//                Integer geoAreaLevel, Integer geoAreaAltCode, Integer geoAreaCombined,
//                Integer geoAreaMale, Integer geoAreaFemale
        List<MKYKAge> ageList = ageRepo.findByGeographicAreaAltCode(altCode);
        MKYKAge o = ageList.get(0);
        MKYKGeoAreaPopulation x = new MKYKGeoAreaPopulation (o.getGeo().getGeographicAreaId(),
                o.getGeo().getName(), o.getGeo().getCode(), o.getGeo().getLevel(),
                o.getGeo().getAlternativeCode(), o.getCombined(), o.getMale(), o.getFemale());
        return x;
    }

    public List<MKYKGeoAreaPopulation> getGeoAreaPopulationForLevel(int level){
        List<MKYKGeographicArea> areas = this.geoRepo.findByLevel(level);
        List<MKYKGeoAreaPopulation> list = new ArrayList<>();
        for (MKYKGeographicArea area : areas) {
            List<MKYKAge> ageList = ageRepo.findByGeographicAreaAltCode(area.getAlternativeCode());
            MKYKAge o = ageList.get(0);
            MKYKGeoAreaPopulation g = new MKYKGeoAreaPopulation(area.getGeographicAreaId(),
                    area.getName(), area.getCode(), area.getLevel(), area.getAlternativeCode(),
                    o.getCombined(), o.getMale(), o.getFemale());
            list.add(g);
        }
        return list;
    }
}
