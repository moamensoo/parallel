/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * ComplaintTicket class represents a complaint ticket entity.
 * Each complaint ticket has a TicketNumber, Date, Content, and BookingId.
 */
public class complaintTicket {
    private int ticketNumber; // Primary key
    private String date;
    private String content;
    private int bookingId; // Foreign key for Booking class

    public complaintTicket() {
    }

    public complaintTicket(int ticketNumber, String date, String content, int bookingId) {
        this.ticketNumber = ticketNumber;
        this.date = date;
        this.content = content;
        this.bookingId = bookingId;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
