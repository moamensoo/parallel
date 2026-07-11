/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NAJI
 */
public class maintenance {
    private int M_Number;
    private String M_date;
    private String Type;
    private int aircraftId; // Foreign key for Aircraft class

    public maintenance() {
    }

    public maintenance(int M_Number, String M_date, String Type, int aircraftId) {
        this.M_Number = M_Number;
        this.M_date = M_date;
        this.Type = Type;
        this.aircraftId = aircraftId;
    }

    public int getM_Number() {
        return M_Number;
    }

    public void setM_Number(int M_Number) {
        this.M_Number = M_Number;
    }

    public String getM_date() {
        return M_date;
    }

    public void setM_date(String M_date) {
        this.M_date = M_date;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }
}
