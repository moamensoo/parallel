/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Airport class represents an airport entity.
 * Each airport has an AirportCode, City, AirportName, and Country.
 */
public class airport {
    private String airportCode; // Primary key
    private String city;
    private String airportName;
    private String country;

    public airport() {
    }

    public airport(String airportCode, String city, String airportName, String country) {
        this.airportCode = airportCode;
        this.city = city;
        this.airportName = airportName;
        this.country = country;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
