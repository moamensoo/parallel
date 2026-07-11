/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.passenger;
import model.aircraft;
import model.airport;
import model.baggage;
import model.account;
import model.flight;
import model.maintenance;
import model.booking;
import model.complaintTicket;
import model.employee;

/**
 *
 * @author Ibrahim BITAR
 */
public class DBAccess {
    private Connection con;
    private Statement stm;
    
    private Connection connect() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
        stm=con.createStatement();
        return con;
    }
    
    private void close() throws SQLException{
        stm.close();
        con.close();
    }
    
    public void addPassenger(passenger p){
        String query1="Insert into passenger values('"+p.getpassport_num()+"','"+p.getPname()+"','"+p.getage()+"','"+p.getphone_num()+"')";
        //System.out.println(query1);
        
        try{
            connect();
            stm.executeUpdate(query1);
            close();
        }
        catch (SQLException e){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    public ArrayList<Integer> getAllpassport_num() throws SQLException{
     String query2="Select PassportNumber from passenger";
     ArrayList<Integer> passport_numList = new ArrayList();
     
     try{
         connect();
         ResultSet rs= stm.executeQuery(query2);
         while(rs.next())
         {
             passport_numList.add(rs.getInt("PassportNumber"));
         }
     }
     catch (SQLException ex)
     {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
     return passport_numList;
    }
    
    public passenger getPassengerBypassport_num(int passport_num)
    {
        String query=" SELECT * FROM passenger where PassportNumber="+passport_num;
        passenger p=null;
        try{
         connect();
         ResultSet rs= stm.executeQuery(query);
         if(rs.next())
         {
             p=new passenger();
             p.setpassport_num(rs.getInt("PassportNumber"));
             p.setPname(rs.getString("Name"));
             p.setphone_num(rs.getString("PhoneNumber"));
             p.setage(rs.getInt("Age"));
         }
         close();
     }
     catch (SQLException ex)
     {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    return p;
    }
    
    public void deletePassengerByPassportNum(int passport_num)
    {
        String query="DELETE FROM passenger where PassportNumber="+ passport_num;
        try{
         connect();
         stm.executeUpdate(query);
         close();
        }
        catch (SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    }
    
    public void UpdatePassengerByPassport_num(int passport_num, String pname, String phone_num, int age)
    {
        //String query="UPDATE `passngers` SET `pname` ="+pname +"`status` ="+status +"`salary` ="+salary+" WHERE `passenger`.`ssn` ="+ssn;
        String query="UPDATE passenger SET Name='"+pname+"', PhoneNumber ='"+phone_num+"',Age='"+age+"' WHERE PassportNumber='"+passport_num+"'";
        try{
         connect();
         stm.executeUpdate(query);
         close();
        }
        catch (SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    }
//TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST

        public void addaircraft(aircraft p){
        String query1="Insert into aircraft values('"+p.getAircraftId()+"','"+p.getModel()+"','"+p.getManufacturer()+"','"+p.getCapacity()+"')";
        //System.out.println(query1);
        
        try{
            connect();
            stm.executeUpdate(query1);
            close();
        }
        catch (SQLException e){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
    public ArrayList<Integer> getAllAircraftId() throws SQLException{
     String query2="Select AircraftId from aircraft";
     ArrayList<Integer> AircraftIdList = new ArrayList();
     
     try{
         connect();
         ResultSet rs= stm.executeQuery(query2);
         while(rs.next())
         {
             AircraftIdList.add(rs.getInt("AircraftId"));
         }
     }
     catch (SQLException ex)
     {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
     return AircraftIdList;
    }
    
    public aircraft getAircraftByAircraftId(int AircraftId)
    {
        String query=" SELECT * FROM aircraft where AircraftId="+AircraftId;
        aircraft p=null;
        try{
         connect();
         ResultSet rs= stm.executeQuery(query);
         if(rs.next())
         {
             p=new aircraft();
             p.setAircraftId(rs.getInt("AircraftId"));
             p.setModel(rs.getString("Model"));
             p.setManufacturer(rs.getString("Manufacturer"));
             p.setCapacity(rs.getInt("Capacity"));
         }
         close();
     }
     catch (SQLException ex)
     {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    return p;
    }
    
    public void deleteAircraftByAircraftId(int AircraftId)
    {
        String query="DELETE FROM aircraft where AircraftId="+ AircraftId;
        try{
         connect();
         stm.executeUpdate(query);
         close();
        }
        catch (SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    }
    
    public void UpdateAircraftByAircraftId(int AircraftId, String Model, String Manufacturer, int Capacity)
    {
        //String query="UPDATE `passngers` SET `pname` ="+pname +"`status` ="+status +"`salary` ="+salary+" WHERE `passenger`.`ssn` ="+ssn;
        String query="UPDATE aircraft SET Model='"+Model+"', Manufacturer ='"+Manufacturer+"',Capacity='"+Capacity+"' WHERE AircraftId='"+AircraftId+"'";
        try{
         connect();
         stm.executeUpdate(query);
         close();
        }
        catch (SQLException ex){
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
    }
    
//2TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST

 public void addAirport(airport p) {
        String query1="Insert into airport values('"+p.getAirportCode()+"','"+p.getCity()+"','"+p.getAirportName()+"','"+p.getCountry()+"')";
        //System.out.println(query1);
        
        try{
            connect();
            stm.executeUpdate(query1);
            close();
        }
        catch (SQLException e){
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, e);
        }
    }

    public ArrayList<String> getAllAirportCodes() throws SQLException {
        String query = "SELECT AirportCode FROM airport";
        ArrayList<String> airportCodes = new ArrayList<>();

        try {
            connect();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                airportCodes.add(rs.getString("AirportCode"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return airportCodes;
    }

    public airport getAirportByAirportCode(String airportCode) {
    String query = "SELECT * FROM airport WHERE AirportCode = ?";
    airport airport = null;
    
    try {
        connect(); 
        
       
        PreparedStatement stm = con.prepareStatement(query);
        stm.setString(1, airportCode); 
        
        
        ResultSet rs = stm.executeQuery();
        
        
        if (rs.next()) {
            airport = new airport();
            airport.setAirportCode(rs.getString("AirportCode"));
            airport.setCity(rs.getString("City"));
            airport.setAirportName(rs.getString("AirportName"));
            airport.setCountry(rs.getString("Country"));
        }
        
        rs.close();
        stm.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return airport;
}

    public void deleteAirportByAirportCode(String airportCode) {
    String query = "DELETE FROM airport WHERE AirportCode = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); 
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, airportCode); 
        
       
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    public void updateAirportByAirportCode(String airportCode, String city, String airportName, String country) {
    String query = "UPDATE airport SET City = ?, AirportName = ?, Country = ? WHERE AirportCode = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); 
           
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, city); 
        pstmt.setString(2, airportName); 
        pstmt.setString(3, country); 
        pstmt.setString(4, airportCode); 
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); 
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 
    
// 3 TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST  
    
public void addBaggage(baggage baggage) {
    String query = "INSERT INTO baggage (BaggageId, Weight, PassportNumber) VALUES (?, ?, ?)";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        // Create PreparedStatement with parameterized query
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, baggage.getBaggageId());
        pstmt.setDouble(2, baggage.getWeight());
        pstmt.setInt(3, baggage.getPassportNumber()); // Assuming PassportNumber is an integer
        
        // Execute the insertion query
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close PreparedStatement and database connection
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public baggage getBaggageByBaggageId(int baggageId) {
    String query = "SELECT * FROM baggage WHERE BaggageId = ?";
    baggage baggage = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        // Create PreparedStatement with parameterized query
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, baggageId); // Set the BaggageId parameter
        
        // Execute the retrieval query
        rs = pstmt.executeQuery();
        
        // Check if a row was returned
        if (rs.next()) {
            // Initialize Baggage object with retrieved data
            baggage = new baggage();
            baggage.setBaggageId(rs.getInt("BaggageId"));
            baggage.setWeight(rs.getDouble("Weight"));
            baggage.setPassportNumber(rs.getInt("PassportNumber"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close ResultSet, PreparedStatement, and database connection
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return baggage;
}
public void updateBaggageByBaggageId(int baggageId, double weight) {
    String query = "UPDATE baggage SET Weight = ? WHERE BaggageId = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        // Create PreparedStatement with parameterized query
        pstmt = con.prepareStatement(query);
        pstmt.setDouble(1, weight); // Set Weight parameter
        pstmt.setInt(2, baggageId); // Set BaggageId parameter
        
        // Execute the update query
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close PreparedStatement and database connection
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void deleteBaggageByBaggageId(int baggageId) {
    String query = "DELETE FROM baggage WHERE BaggageId = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        // Create PreparedStatement with parameterized query
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, baggageId); // Set the BaggageId parameter
        
        // Execute the deletion query
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close PreparedStatement and database connection
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public ArrayList<Integer> getAllBaggageId() throws SQLException {
    String query = "SELECT BaggageId FROM baggage";
    ArrayList<Integer> baggageIdList = new ArrayList<>();
    ResultSet rs = null;
    
    try {
        connect();         
        rs = stm.executeQuery(query);        
        while (rs.next()) {
            int baggageId = rs.getInt("BaggageId");
            baggageIdList.add(baggageId);
        }       
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    return baggageIdList;
}
//4TTTTTTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESTT

public void addAccount(account account) {
    String query = "INSERT INTO account (Username, Password, Email, Permissions, PassportNumber) VALUES (?, ?, ?, ?, ?)";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, account.getUsername());
        pstmt.setString(2, account.getPassword());
        pstmt.setString(3, account.getEmail());
        pstmt.setString(4, account.getPermissions());
        pstmt.setInt(5, account.getPassportNumber());
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public account getAccountByUsername(String username) {
    String query = "SELECT * FROM account WHERE Username = ?";
    account account = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        connect(); 
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, username);
        
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            account = new account();
            account.setUsername(rs.getString("Username"));
            account.setPassword(rs.getString("Password"));
            account.setEmail(rs.getString("Email"));
            account.setPermissions(rs.getString("Permissions"));
            account.setPassportNumber(rs.getInt("PassportNumber"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return account;
}
public void updateAccountByUsername(String username, String permissions) {
    String query = "UPDATE account SET Permissions = ? WHERE Username = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, permissions);
        pstmt.setString(2, username);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void deleteAccountByUsername(String username) {
    String query = "DELETE FROM account WHERE Username = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, username);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public ArrayList<String> getAllUsernames() throws SQLException {
    String query = "SELECT Username FROM account";
    ArrayList<String> usernameList = new ArrayList<>();
    ResultSet rs = null;
    
    try {
        connect();         
        Statement stm = con.createStatement(); // Use Statement to execute query
        rs = stm.executeQuery(query);        
        while (rs.next()) {
            String username = rs.getString("Username");
            usernameList.add(username);
        }       
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    return usernameList;
}

//5 TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST

public void addFlight(flight flight) {
    String query = "INSERT INTO flight (FlightNumber, Date, DepartureTime, ArrivalTime, AirportCode, AircraftId) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, flight.getFlightNumber());
        pstmt.setString(2, flight.getDate());
        pstmt.setString(3, flight.getDepartureTime());
        pstmt.setString(4, flight.getArrivalTime());
        pstmt.setString(5, flight.getAirportCode());
        pstmt.setInt(6, flight.getAircraftId());
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public flight getFlightByFlightNumberAndDate(int flightNumber, String date) {
    String query = "SELECT * FROM flight WHERE FlightNumber = ? AND Date = ?";
    flight flight = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, flightNumber);
        pstmt.setString(2, date);
        
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            flight = new flight();
            flight.setFlightNumber(rs.getInt("FlightNumber"));
            flight.setDate(rs.getString("Date"));
            flight.setDepartureTime(rs.getString("DepartureTime"));
            flight.setArrivalTime(rs.getString("ArrivalTime"));
            flight.setAirportCode(rs.getString("AirportCode"));
            flight.setAircraftId(rs.getInt("AircraftId"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return flight;
}
public void updateFlightByFlightNumberAndDate(int flightNumber, String date, String newDepartureTime, String newArrivalTime) {
    String query = "UPDATE flight SET DepartureTime = ?, ArrivalTime = ? WHERE FlightNumber = ? AND Date = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, newDepartureTime);
        pstmt.setString(2, newArrivalTime);
        pstmt.setInt(3, flightNumber);
        pstmt.setString(4, date);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void deleteFlightByFlightNumberAndDate(int flightNumber, String date) {
    String query = "DELETE FROM flight WHERE FlightNumber = ? AND Date = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, flightNumber);
        pstmt.setString(2, date);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public ArrayList<Integer> getAllFlightNumbers() throws SQLException{
     String query2="Select FlightNumber from flight";
     ArrayList<Integer> AircraftIdList = new ArrayList();
     
     try{
         connect();
         ResultSet rs= stm.executeQuery(query2);
         while(rs.next())
         {
             AircraftIdList.add(rs.getInt("FlightNumber"));
         }
     }
     catch (SQLException ex)
     {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
     return AircraftIdList;
    }
public ArrayList<String> getAllDates() throws SQLException {
    String query = "SELECT Date FROM flight";
    ArrayList<String> usernameList = new ArrayList<>();
    ResultSet rs = null;
    
    try {
        connect();         
        Statement stm = con.createStatement(); // Use Statement to execute query
        rs = stm.executeQuery(query);        
        while (rs.next()) {
            String username = rs.getString("Date");
            usernameList.add(username);
        }       
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    return usernameList;
}
//6 TESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSST

public void addMaintenance(maintenance maintenance) {
    String query = "INSERT INTO maintenance (M_Number, M_date, Type, AircraftId) VALUES (?, ?, ?, ?)";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, maintenance.getM_Number());
        pstmt.setString(2, maintenance.getM_date());
        pstmt.setString(3, maintenance.getType());
        pstmt.setInt(4, maintenance.getAircraftId());
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public maintenance getMaintenanceByM_Number(int mNumber) {
    String query = "SELECT * FROM maintenance WHERE M_Number = ?";
    maintenance maintenance = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, mNumber);
        
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            maintenance = new maintenance();
            maintenance.setM_Number(rs.getInt("M_Number"));
            maintenance.setM_date(rs.getString("M_date"));
            maintenance.setType(rs.getString("Type"));
            maintenance.setAircraftId(rs.getInt("AircraftId"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return maintenance;
}
public void updateMaintenanceByM_Number(int mNumber, String newM_date, String newType) {
    String query = "UPDATE maintenance SET M_date = ?, Type = ? WHERE M_Number = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, newM_date);
        pstmt.setString(2, newType);
        pstmt.setInt(3, mNumber);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void deleteMaintenanceByM_Number(int mNumber) {
    String query = "DELETE FROM maintenance WHERE M_Number = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, mNumber);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public ArrayList<Integer> getAllM_Number() throws SQLException{
    String query2="Select M_Number from maintenance";
     ArrayList<Integer> maintenanceList = new ArrayList();
     
     try{
         connect();
         ResultSet rs= stm.executeQuery(query2);
         while(rs.next())
         {
             maintenanceList.add(rs.getInt("M_Number"));
         }
     }
     catch (SQLException ex)
     {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE,null, ex);
     }
     return maintenanceList;
}
//BOOKING
public void addBooking(booking booking) {
    String query = "INSERT INTO booking (BookingId, SeatNo, BookingDate, Class, FlightNumber, PassportNumber) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, booking.getBookingId());
        pstmt.setInt(2, booking.getSeatNo());
        pstmt.setString(3, booking.getBookingDate());
        pstmt.setString(4, booking.getclass());
        pstmt.setInt(5, booking.getFlight_Number());
        pstmt.setInt(6, booking.getPassportNumber());
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public booking getBookingByBookingId(int bookingId) {
    String query = "SELECT * FROM booking WHERE BookingId = ?";
    booking booking = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, bookingId);
        
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            booking = new booking();
            booking.setBookingId(rs.getInt("BookingId"));
            booking.setSeatNo(rs.getInt("SeatNo"));
            booking.setBookingDate(rs.getString("BookingDate"));
            booking.setClass(rs.getString("Class"));
            booking.setFlight_Number(rs.getInt("FlightNumber"));
            booking.setPassportNumber(rs.getInt("PassportNumber"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return booking;
}
public void updateBookingByBookingId(int bookingId, int newSeatNo, String newBookingDate, String newClass) {
    String query = "UPDATE booking SET SeatNo = ?, BookingDate = ?, Class = ? WHERE BookingId = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, newSeatNo);
        pstmt.setString(2, newBookingDate);
        pstmt.setString(3, newClass);
        pstmt.setInt(4, bookingId);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void deleteBookingByBookingId(int bookingId) {
    String query = "DELETE FROM booking WHERE BookingId = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect();
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, bookingId);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public ArrayList<Integer> getAllBookingIds() throws SQLException{
    String query = "SELECT BookingId FROM booking";
    ArrayList<Integer> bookingIds = new ArrayList<>();
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            int bookingId = rs.getInt("BookingId");
            bookingIds.add(bookingId);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return bookingIds;
}

//complaint ticket

public void addComplaintTicket(complaintTicket complaintTicket) {
    String query = "INSERT INTO complaintticket (TicketNumber, Date, Content, BookingId) VALUES (?, ?, ?, ?)";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, complaintTicket.getTicketNumber());
        pstmt.setString(2, complaintTicket.getDate());
        pstmt.setString(3, complaintTicket.getContent());
        pstmt.setInt(4, complaintTicket.getBookingId());
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public complaintTicket getComplaintTicketByTicketNumber(int ticketNumber) {
    String query = "SELECT * FROM complaintticket WHERE TicketNumber = ?";
    complaintTicket complaintTicket = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, ticketNumber);
        
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            complaintTicket = new complaintTicket();
            complaintTicket.setTicketNumber(rs.getInt("TicketNumber"));
            complaintTicket.setDate(rs.getString("Date"));
            complaintTicket.setContent(rs.getString("Content"));
            complaintTicket.setBookingId(rs.getInt("BookingId"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return complaintTicket;
}
public void updateComplaintTicketByTicketNumber(int ticketNumber, String newDate, String newContent) {
    String query = "UPDATE complaintticket SET Date = ?, Content = ? WHERE TicketNumber = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, newDate);
        pstmt.setString(2, newContent);
        pstmt.setInt(3, ticketNumber);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void deleteComplaintTicketByTicketNumber(int ticketNumber) {
    String query = "DELETE FROM complaintticket WHERE TicketNumber = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect();
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, ticketNumber);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public ArrayList<Integer> getAllTicketNumber() throws SQLException{
    String query = "SELECT TicketNumber FROM complaintticket";
    ArrayList<Integer> TicketNumbers = new ArrayList<>();
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            int TicketNumber = rs.getInt("TicketNumber");
            TicketNumbers.add(TicketNumber);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return TicketNumbers;
}

//Employee
public void addEmployee(employee employee) {
    String query = "INSERT INTO employee (E_Id, Department, E_name, Role, Salary, Username, Date, FlightNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, employee.getE_id());
        pstmt.setString(2, employee.getDepartment());
        pstmt.setString(3, employee.getE_name());
        pstmt.setString(4, employee.getRole());
        pstmt.setInt(5, employee.getsalary());
        pstmt.setString(6, employee.getUsername());
        pstmt.setString(7, employee.getDate());
        pstmt.setInt(8, employee.getflightNumber());
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public employee getEmployeeByE_Id(int E_Id) {
    String query = "SELECT * FROM employee WHERE E_Id = ?";
    employee employee = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, E_Id);
        
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            employee = new employee();
            employee.setE_id(rs.getInt("E_Id"));
            employee.setDepartment(rs.getString("Department"));
            employee.setE_name(rs.getString("E_name"));
            employee.setRole(rs.getString("Role"));
            employee.setsalary(rs.getInt("Salary"));
            employee.setUsername(rs.getString("Username"));
            employee.setDate(rs.getString("Date"));
            employee.setflightNumber(rs.getInt("FlightNumber"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return employee;
}
public void updateEmployeeByE_Id(int E_Id, String newDepartment, String newE_name, String newRole, int newSalary) {
    String query = "UPDATE employee SET Department = ?, E_name = ?, Role = ?, Salary = ? WHERE E_Id = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, newDepartment);
        pstmt.setString(2, newE_name);
        pstmt.setString(3, newRole);
        pstmt.setInt(4, newSalary);
        pstmt.setInt(5, E_Id);        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public void deleteEmployeeByE_Id(int E_Id) {
    String query = "DELETE FROM employee WHERE E_Id = ?";
    PreparedStatement pstmt = null;
    
    try {
        connect(); // Establish database connection
        
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, E_Id);
        
        pstmt.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
public ArrayList<Integer> getAllE_Id() throws SQLException{
    String query = "SELECT E_Id FROM employee";
    ArrayList<Integer> E_Ids = new ArrayList<>();
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        connect(); 
        
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            int TicketNumber = rs.getInt("E_Id");
            E_Ids.add(TicketNumber);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            close(); // Close database connection
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return E_Ids;
}
public List<booking> getBookingsByPassportNumber(int passportNumber) {
    List<booking> bookings = new ArrayList<>();
    String sql = "SELECT * FROM Booking WHERE PassportNumber = ?";
    try (Connection con = connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setInt(1, passportNumber);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                booking b = new booking();
                b.setBookingId(rs.getInt("BookingId"));
                b.setSeatNo(rs.getInt("SeatNo"));
                b.setBookingDate(rs.getString("BookingDate"));
                b.setClass(rs.getString("class"));
                b.setFlight_Number(rs.getInt("FlightNumber"));
                b.setPassportNumber(rs.getInt("PassportNumber"));
                bookings.add(b);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, e);
    }
    return bookings;
}

public List<complaintTicket> getComplaintTicketsByBookingId(int bookingId) {
    List<complaintTicket> tickets = new ArrayList<>();
    String sql = "SELECT * FROM complaintticket WHERE BookingId = ?";
    try (Connection con = this.connect(); PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setInt(1, bookingId);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                complaintTicket ticket = new complaintTicket();
                ticket.setTicketNumber(rs.getInt("TicketNumber"));
                ticket.setDate(rs.getString("Date"));
                ticket.setContent(rs.getString("Content"));
                ticket.setBookingId(rs.getInt("BookingId"));
                tickets.add(ticket);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, e);
    }
    return tickets;
}


}
