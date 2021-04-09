package com.test.MKYKCensusApp.data.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="age")
public class MKYKAge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ageid")
    private int ageId;
    @Column(name = "agegroup")
    private int ageGroup;
    @Column(name="censusyear")
    private int censusYear;
    @Column(name="combined")
    private int combined;
    @Column(name="male")
    private int male;
    @Column(name="female")
    private int female;
    @ManyToOne
    @JoinColumn(name="geographicarea")
    private MKYKGeographicArea geo;


    public MKYKGeographicArea getGeo() {
        return geo;
    }

    public int getAgeID() {
        return ageId;
    }

    public void setAgeID(int ageId) { this.ageId = ageId; }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    public int getCombined() {
        return combined;
    }

    public void setCombined(int combined) {
        this.combined = combined;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    @Override
    public String toString() {
        return "Age group, year, Geographic Area ID: " + ageGroup + ", " + censusYear + ", " +
                geo.getGeographicAreaId() + " ( Age ID: " + ageId + " )\n" +
                "> Population: combined, male, female: " + combined + ", " + male + ", " + female;
    }
}
