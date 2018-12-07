package grab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MapController implements Initializable{

    @FXML Button acctButton;
    @FXML Button historyButton;
    @FXML Button mapButton;
    @FXML Button logOutButton;
    @FXML Button grabCarButton;
    @FXML Button grabShareButton;
    @FXML Button grabTaxiButton;
    @FXML Button grabCarSixButton;
    @FXML Button grabPremiumButton;
    
    @FXML Label nameLabel;
    @FXML Label tripTypeLabel;
    @FXML Label distanceLabel;
    @FXML Label priceLabel;
    
    @FXML TextField fromTextField;
    @FXML TextField toTextField;
    
    private static Main user;
    
    public static String fromText;
    public static String toText;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = new Main();

        fromTextField.setText("");
        toTextField.setText("");
        
        nameLabel.setText(user.getLoginUser());
        nameLabel.setVisible(true);
        
        tripTypeLabel.setVisible(false);
        distanceLabel.setVisible(false);
        priceLabel.setVisible(false);
    }

    public void moveToAccount (javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader load = new FXMLLoader (getClass().getResource("Account.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        AccountController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void moveToHistory (javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader load = new FXMLLoader (getClass().getResource("History.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        HistoryController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void moveToMap (javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader load = new FXMLLoader (getClass().getResource("Map.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        MapController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    public void moveToLogIn (javafx.event.ActionEvent actionEvent) throws IOException {
        
        //Sets the Number Logged In to NULL
        LoginController.mobile = null;
        
        FXMLLoader load = new FXMLLoader (getClass().getResource("Login.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        LoginController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    public void useGrabCar (javafx.event.ActionEvent actionEvent) throws IOException{
        
        fromText = fromTextField.getText();
        toText = toTextField.getText();
        
        tripTypeLabel.setText("GrabCar");
        tripTypeLabel.setVisible(true);
        
        distanceLabel.setText("Distance: " + Float.toString(user.getDistanceTrip()) + " km");
        distanceLabel.setVisible(true);
    }
    
    public void useGrabShare (javafx.event.ActionEvent actionEvent) throws IOException{
        
        fromText = fromTextField.getText();
        toText = toTextField.getText();
        
        tripTypeLabel.setText("GrabShare");
        tripTypeLabel.setVisible(true);
        
        distanceLabel.setText("Distance: " + Float.toString(user.getDistanceTrip()) + " km");
        distanceLabel.setVisible(true);
    }
    
    public void useGrabTaxi (javafx.event.ActionEvent actionEvent) throws IOException{
        
        fromText = fromTextField.getText();
        toText = toTextField.getText();
        
        tripTypeLabel.setText("GrabTaxi");
        tripTypeLabel.setVisible(true);
        
        distanceLabel.setText("Distance: " + Float.toString(user.getDistanceTrip()) + " km");
        distanceLabel.setVisible(true);
    }
    
    public void useGrabCarSix (javafx.event.ActionEvent actionEvent) throws IOException{
        
        fromText = fromTextField.getText();
        toText = toTextField.getText();
        
        tripTypeLabel.setText("GrabCar (6 seater)");
        tripTypeLabel.setVisible(true);
        
        distanceLabel.setText("Distance: " + Float.toString(user.getDistanceTrip()) + " km");
        distanceLabel.setVisible(true);
    }
    
    public void useGrabPremium (javafx.event.ActionEvent actionEvent) throws IOException{
        
        fromText = fromTextField.getText();
        toText = toTextField.getText();
        
        tripTypeLabel.setText("GrabCar+ (Premium)");
        tripTypeLabel.setVisible(true);
        
        distanceLabel.setText("Distance: " + Float.toString(user.getDistanceTrip()) + " km");
        distanceLabel.setVisible(true);
    }
}
