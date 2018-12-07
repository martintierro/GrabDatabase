//hi


package grab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.sql.*;

public class Main extends Application {
    
 private static Statement stmt;
 public static int riderID = 1;
 public static Connection con;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Grab");
        primaryStage.setScene(new Scene(root, 600, 480));
        primaryStage.show();
    }

    //Main Function
    public static void main(String[] args) { 
        Main pro = new Main();
        pro.createConnection();
        launch(args);
    }
    
    //Connecting MVC to MySQL Database
    void createConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grab_db", "root", "1234");
            System.out.println("Successfully connected to the Database!");
            stmt = con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
    
    //Creating an Account
    public boolean createAccount(){
        
        if(RegisterController.given == "" || RegisterController.last == "" || RegisterController.mobile == "" || RegisterController.card == ""){
            return false;
        } else {

            int riderNo;
            riderNo = getLatestUser();
            String register = "INSERT INTO `grab_db`.`rider` (`riderID`, `givenName`, `lastName`, `mobileNo`, `creditCard`) VALUES ('"+ riderNo +"', '"+RegisterController.given+"', '"+ RegisterController.last +"', '"+ RegisterController.mobile +"', '"+ RegisterController.card +"')";

            try {
                stmt.executeUpdate(register); 
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } 

            return true;
        }
    }
    
    //Get Latest Rider No. from Database 
    public int getLatestUser() {
        String max = "SELECT MAX(riderID) as 'total' FROM rider";
        int n = 0;
        
        try {
            ResultSet rs = stmt.executeQuery(max);
            
            while (rs.next()) {
                n = rs.getInt("total");
                n++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return n;
    }
    
    //Check if User Exists in the Database
    public boolean checkAccount(){
        String cellphoneNo = LoginController.mobile;
        String list = "SELECT mobileNo as 'numbers' FROM rider";
        String n;
        int count = 0;
        boolean status = false;
        
        try {
            ResultSet rs = stmt.executeQuery(list);
            
            while (rs.next()) {
                n = rs.getString("numbers");
                if(n.equals(cellphoneNo)){
                    riderID = count;
                    status =  true;
                }
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return status;
    }
    
    public static int getRiderID(){
        
        return riderID;
    }
    
    //Gets the User Logged In
    public String getLoginUser(){
        String mobile = LoginController.mobile;
        String query = "SELECT CONCAT(givenName, \" \" , lastName) as 'name' FROM rider WHERE mobileNo = "+mobile+"";
        String user = null;
        
        try {
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                user = rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return user;
    }
    
    //Gets the Distance of the Trip
    public float getDistanceTrip(){
        String fromText = MapController.fromText;
        String toText = MapController.toText;
        
        System.out.println(fromText);
        String query = "SELECT distance as 'dist' FROM trip WHERE startPoint = '"+fromText+"' AND endPoint = '"+toText+"'";
        float distance = 0;
        
        try {
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                distance = rs.getFloat("dist");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return distance;
    }
    
    //Gets the Price of the Trip
    
}
