package com.test.MKYKCensusApp.data.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class MKYKUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable= false, unique = true)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "lastgeographicarea")
    private int lastGeographicArea;

    public int getUserID() {
        return id;
    }

    public void setUserID(int id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLastGeographicArea() {
        return lastGeographicArea;
    }

    public void setLastGeographicArea(int lastGeographicArea) {
        this.lastGeographicArea = lastGeographicArea;
    }

    @Override
    public String toString() {
        return "MKYKUser{" +
                "userID=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastGeographicArea=" + lastGeographicArea +
                '}';
    }


}
