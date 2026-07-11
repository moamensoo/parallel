/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Aircraft class represents an aircraft entity.
 * Each aircraft has an aircraftId, model, manufacturer, and capacity.
 */
public class aircraft {
    private int aircraftId;
    private String model;
    private String manufacturer;
    private int capacity;

    public aircraft() {
    }

    public aircraft(int aircraftId, String model, String manufacturer, int capacity) {
        this.aircraftId = aircraftId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
