package grab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MapController {

    @FXML Button acctButton;
    @FXML Button historyButton;
    @FXML Button mapButton;
    @FXML Button logOutButton;

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
}
