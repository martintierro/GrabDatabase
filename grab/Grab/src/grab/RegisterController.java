package grab;

import java.awt.event.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.*;
import java.sql.*;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class RegisterController implements Initializable {
    
    @FXML Button createAccountButton;
    @FXML TextField givenNameTextField;
    @FXML TextField lastNameTextField;
    @FXML TextField mobileNoTextField;
    @FXML TextField creditCardTextField;
    @FXML Label invalidityLabel;
    
    private static Main user;
    
    public static String given;
    public static String last;
    public static String mobile;
    public static String card;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = new Main();
        givenNameTextField.setText("");
        lastNameTextField.setText("");
        mobileNoTextField.setText("");
        creditCardTextField.setText("");
        
    }
    
    public void createAccount(ActionEvent event) throws IOException{
        
        given = givenNameTextField.getText();
        last = lastNameTextField.getText();
        mobile = mobileNoTextField.getText();
        card = creditCardTextField.getText();
        
        if(user.createAccount()){
            System.out.println("Account Created!");
            
            FXMLLoader load = new FXMLLoader (getClass().getResource("Login.fxml"));
            Parent fieldParent = load.load();
            Scene scene = new Scene(fieldParent);
            LoginController controller = load.getController();
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            
        } else {
            System.out.println("Account Creation Failed!");
            if("".equals(given) || "".equals(last) || "".equals(mobile) || "".equals(card)){
                invalidityLabel.setText("Fill In the Textfields");
                invalidityLabel.setVisible(true);
            } else {
                invalidityLabel.setText("Number is Used Already");
                invalidityLabel.setVisible(true);
                givenNameTextField.setText("");
                lastNameTextField.setText("");
                mobileNoTextField.setText("");
                creditCardTextField.setText("");
            }
        }
        
    }
    
}
