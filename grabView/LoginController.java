package grabView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML Button loginButton;
    @FXML Button registerButton;
    @FXML TextField mobileTextField;
    @FXML TextField passwordTextField;



    public void moveToRegister (javafx.event.ActionEvent actionEvent) throws IOException {

            FXMLLoader load = new FXMLLoader (getClass().getResource("Register.fxml"));
            Parent fieldParent = load.load();
            Scene scene = new Scene(fieldParent);
            RegisterController controller = load.getController();
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

    public void loggingIn (javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader load = new FXMLLoader (getClass().getResource("Map.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        RegisterController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    }

