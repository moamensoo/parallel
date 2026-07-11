/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NAJI
 */
public class passenger {
    private int passport_num;
    private String pname;
    private String phone_num;
    private int age;

    public passenger() {
    }

    public passenger(int pass, String pname, String phone_num, int age) {
        this.passport_num = pass;
        this.pname = pname;
        this.phone_num = phone_num;
        this.age = age;
    }

    public int getpassport_num() {
        return passport_num;
    }

    public void setpassport_num(int passport_num) {
        this.passport_num = passport_num;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getphone_num() {
        return phone_num;
    }

    public void setphone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }
    
    
    
    
}

