/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NAJI
 */
public class booking {
    private int BookingId;
    private String BookingDate;
    private String Class;
    private int SeatNo;
    private int Flight_Number;
    private int PassportNumber;
    
    public booking() {
    }

    public booking(int BookingId,int SeatNo, String BookingDate, String Class, int Flight_Number, int PassportNumber) {
        this.BookingId = BookingId;
        this.BookingDate = BookingDate;
        this.Class = Class;
        this.SeatNo = SeatNo;
        this.Flight_Number=Flight_Number;
        this.PassportNumber= PassportNumber;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int BookingId) {
        this.BookingId = BookingId;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String BookingDate) {
        this.BookingDate = BookingDate;
    }

    public String getclass() {
        return Class;
    }

    public void setClass(String Class) {
        this.Class = Class;
    }

    public int getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(int SeatNo) {
        this.SeatNo = SeatNo;
    }
    public int getFlight_Number() {
        return Flight_Number;
    }

    public void setFlight_Number(int Flight_Number) {
        this.Flight_Number = Flight_Number;
    }
    
    public int getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(int PassportNumber) {
        this.PassportNumber = PassportNumber;
    }
    
}


