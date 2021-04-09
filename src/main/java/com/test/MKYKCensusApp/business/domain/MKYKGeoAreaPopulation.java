package com.test.MKYKCensusApp.business.domain;

import org.springframework.stereotype.Repository;

@Repository
public class MKYKGeoAreaPopulation {

    private Integer geoAreaId;
    private String geoAreaName;
    private Integer geoAreaCode;
    private Integer geoAreaLevel;
    private Integer geoAreaAltCode;
    private Integer geoAreaCombined;
    private Integer geoAreaMale;
    private Integer geoAreaFemale;

    public MKYKGeoAreaPopulation(){

    }

    public MKYKGeoAreaPopulation(Integer geoAreaId, String geoAreaName, Integer geoAreaCode,
                                 Integer geoAreaLevel, Integer geoAreaAltCode, Integer geoAreaCombined,
                                 Integer geoAreaMale, Integer geoAreaFemale){
        this.geoAreaId = geoAreaId;
        this.geoAreaName = geoAreaName;
        this.geoAreaCode = geoAreaCode;
        this.geoAreaLevel = geoAreaLevel;
        this.geoAreaAltCode = geoAreaAltCode;
        this.geoAreaCombined = geoAreaCombined;
        this.geoAreaMale = geoAreaMale;
        this.geoAreaFemale = geoAreaFemale;
    }

    public Integer getGeoAreaId() {return geoAreaId;}

    public void setGeoAreaId(Integer geoAreaId) {this.geoAreaId = geoAreaId;}


    public String getGeoAreaName() {
        return geoAreaName;
    }

    public void setGeoAreaName(String geoAreaName) {
        this.geoAreaName = geoAreaName;
    }

    public Integer getGeoAreaCode() {
        return geoAreaCode;
    }

    public void setGeoAreaCode(Integer geoAreaCode) {
        this.geoAreaCode = geoAreaCode;
    }

    public Integer getGeoAreaLevel() {
        return geoAreaLevel;
    }

    public void setGeoAreaLevel(Integer geoAreaLevel) {
        this.geoAreaLevel = geoAreaLevel;
    }

    public Integer getGeoAreaAltCode() {
        return geoAreaAltCode;
    }

    public void setGeoAreaAltCode(Integer geoAreaAltCode) {
        this.geoAreaAltCode = geoAreaAltCode;
    }

    public Integer getGeoAreaCombined() {
        return geoAreaCombined;
    }

    public void setGeoAreaCombined(Integer geoAreaCombined) {
        this.geoAreaCombined = geoAreaCombined;
    }

    public Integer getGeoAreaMale() {
        return geoAreaMale;
    }

    public void setGeoAreaMale(Integer geoAreaMale) {
        this.geoAreaMale = geoAreaMale;
    }

    public Integer getGeoAreaFemale() {
        return geoAreaFemale;
    }

    public void setGeoAreaFemale(Integer geoAreaFemale) {
        this.geoAreaFemale = geoAreaFemale;
    }
}
