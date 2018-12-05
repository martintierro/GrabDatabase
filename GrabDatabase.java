package grabdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabDatabase {

    public static void main(String[] args) {
          GrabDatabase pro = new GrabDatabase();
          pro.createConnection();
    }
    
    void createConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grab_db", "root", "1234");
            System.out.println("Success!!!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrabDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GrabDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
}
