package grab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LoginController implements Initializable{

    @FXML Button loginButton;
    @FXML Button registerButton;
    @FXML TextField mobileTextField;
    @FXML TextField passwordTextField;
    @FXML Label invalidityLabel;
    
    private static Main user;
    
    public static String mobile;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user = new Main();
    }
    
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
        String admin = "00000000000";
        mobile = mobileTextField.getText();

        if (mobile.equals(admin)) {
            System.out.println("Admin Account.");
            FXMLLoader load = new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent fieldParent = load.load();
            Scene scene = new Scene(fieldParent);
            AdminController controller = load.getController();
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } else if(user.checkAccount()){
            System.out.println("Valid Account!");
            FXMLLoader load = new FXMLLoader (getClass().getResource("Map.fxml"));
            Parent fieldParent = load.load();
            Scene scene = new Scene(fieldParent);
            MapController controller = load.getController();
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } else {
            System.out.println("Invalid Account!");
            invalidityLabel.setVisible(true);
            mobileTextField.setText("");
        }
    }
}

