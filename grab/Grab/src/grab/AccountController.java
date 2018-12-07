package grab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountController {

    @FXML Button acctButton;
    @FXML Button historyButton;
    @FXML Button mapButton;
    @FXML Button Update;

    @FXML TextField givenNameTextField;
    @FXML TextField lastNameTextField;
    @FXML TextField mobileNoTextField;
    @FXML TextField creditCardTextField;

    public void moveToAccount (javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader load = new FXMLLoader (getClass().getResource("View/Account.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        AccountController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void moveToHistory (javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader load = new FXMLLoader (getClass().getResource("View/History.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        HistoryController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void moveToMap (javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader load = new FXMLLoader (getClass().getResource("View/Map.fxml"));
        Parent fieldParent = load.load();
        Scene scene = new Scene(fieldParent);
        MapController controller = load.getController();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void updateAccount (javafx.event.ActionEvent actionEvent) throws IOException, SQLException {
        try{
            String query = "UPDATE rider SET givenName = ?, lastName = ?, mobileNo = ?, creditCard = ? WHERE riderID = ?";
            PreparedStatement p = Main.con.prepareStatement(query);
            p.setString(1, givenNameTextField.getText());
            p.setString(2, lastNameTextField.getText());
            p.setString(3, mobileNoTextField.getText());
            p.setString(4, creditCardTextField.getText());
            p.setInt(5, Main.getRiderID());
            p.executeUpdate();
            p.close();
            System.out.println ("Update Successful!");
        } catch (SQLException se){
            se.printStackTrace();
            System.out.println ("Update Unsuccessful.");
        }
    }
}