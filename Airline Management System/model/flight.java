/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Flight class represents a flight entity.
 * Each flight has a FlightNumber, Date, DepartureTime, ArrivalTime, AirportCode, and AircraftId.
 */
public class flight {
    private int flightNumber;
    private String date;
    private String departureTime;
    private String arrivalTime;
    private String airportCode; // Foreign key for Airport class
    private int aircraftId; // Foreign key for Aircraft class

    public flight() {
    }

    public flight(int flightNumber, String date, String departureTime, String arrivalTime, String airportCode, int aircraftId) {
        this.flightNumber = flightNumber;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airportCode = airportCode;
        this.aircraftId = aircraftId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }
}
