/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NAJI
 */
public class employee {
    private int E_id;
    private String Department;
    private String E_name;
    private String Role;
    private int salary;
    private String Username; // Foreign key for Account class
    private String Date; // Foreign key for Flight class
    private int flightNumber; // Foreign key for Flight class

    public employee() {
    }

    public employee(int pass, String Department,String E_name, String Role, int salary, String Username, String Date, int flightNumber) {
        this.E_id = pass;
        this.Department= Department;
        this.E_name = E_name;
        this.Role = Role;
        this.salary = salary;
        this.Username = Username;
        this.Date = Date;
        this.flightNumber= flightNumber;
    }

    public int getE_id() {
        return E_id;
    }

    public void setE_id(int E_id) {
        this.E_id = E_id;
    }
    
    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }
    
    public String getE_name() {
        return E_name;
    }

    public void setE_name(String E_name) {
        this.E_name = E_name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getsalary() {
        return salary;
    }

    public void setsalary(int salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getflightNumber() {
        return flightNumber;
    }

    public void setflightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
}
