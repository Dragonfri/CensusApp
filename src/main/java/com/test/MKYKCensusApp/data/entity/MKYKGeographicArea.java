package com.test.MKYKCensusApp.data.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="geographicarea")
public class MKYKGeographicArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "geographicareaid")
    private int geographicAreaID;
    @Column(name = "code")
    private int code;
    @Column(name = "level")
    private int level;
    @Column(name ="name")
    private String name;
    @Column(name = "alternativecode")
    private int alternativeCode;
    @OneToMany(mappedBy="geo", fetch=FetchType.LAZY)
    private List<MKYKAge> ageList;

    public List<MKYKAge> getAgeList() {
        return ageList;
    }

    public int getGeographicAreaId() {return geographicAreaID;}

    public void setGeographicAreaID(int geographicAreaID) {this.geographicAreaID = geographicAreaID;}

    public int getCode() {return code;}

    public void setCode(int code){this.code = code;}

    public int getLevel() {return level;}

    public void setLevel(int level){this.level = level;}

    public String getName() {return name;}

    public void setName(String name){this.name = name;}

    public int getAlternativeCode() {return alternativeCode;}

    public void setAlternativeCode(int alternativeCode){this.alternativeCode = alternativeCode;}

    @Override
    public String toString() {
        return "Area name, alternative code: " + name + ", " + alternativeCode + " ( ID: " + geographicAreaID + " )";
    }
}
