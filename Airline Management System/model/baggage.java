/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Baggage class represents a baggage entity.
 * Each baggage has a BaggageId, weight, and PassportNumber.
 */
public class baggage {
    private int baggageId; // Primary key
    private double weight;
    private int passportNumber; // Foreign key 

    public baggage() {
    }

    public baggage(int baggageId, double weight, int passportNumber) {
        this.baggageId = baggageId;
        this.weight = weight;
        this.passportNumber = passportNumber;
    }

    public int getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(int baggageId) {
        this.baggageId = baggageId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
