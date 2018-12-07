package grab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AdminController {
    @FXML Button riderButton;
    @FXML Button driverButton;
    @FXML Button carButton;
    @FXML Button tripButton;
    @FXML Button bookingButton;
    @FXML Button reportButton;
    @FXML TableView adminTable;

    private static int count = 1;

    public void viewRiderTable (javafx.event.ActionEvent actionEvent) throws IOException, SQLException {
        try{
            String query = "SELECT * FROM rider";
            Statement st = Main.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            TableColumn<List<Integer>, String> RiderID = new TableColumn<> ("riderID");
            TableColumn<List<String>, String> GivenName = new TableColumn<> ("givenName");
            TableColumn<List<String>, String> LastName = new TableColumn<> ("lastName");
            TableColumn<List<String>, String> MobileNo = new TableColumn<> ("mobileNo");
            TableColumn<List<String>, String> CreditCard = new TableColumn<> ("creditCard");

            while (rs.next())
            {
                int riderID = rs.getInt("riderID");
                String givenName = rs.getString("givenName");
                String lastName = rs.getString("lastName");
                String mobileNo = rs.getString("mobileNo");
                String creditCard = rs.getString("creditCard");

                System.out.format("%d, %s, %s, %s, %s\n", riderID, givenName, lastName, mobileNo, creditCard);
                count++;

                RiderID.setCellValueFactory(new PropertyValueFactory<>("riderID"));

             /*   ObservableList<Integer> row1 = FXCollections.observableArrayList();
                ObservableList<String> row2 = FXCollections.observableArrayList();
                ObservableList<String> row3 = FXCollections.observableArrayList();
                ObservableList<String> row4 = FXCollections.observableArrayList();
                ObservableList<String> row5 = FXCollections.observableArrayList();
                row1.add(rs.getInt("riderID"));
                row2.add(rs.getString("givenName"));
                row3.add(rs.getString("lastName"));
                row4.add(rs.getString("mobileNo"));
                row5.add(rs.getString("creditCard"));*/
            }
            adminTable.getColumns().add(RiderID);
            adminTable.getColumns().add(GivenName);
            adminTable.getColumns().add(LastName);
            adminTable.getColumns().add(MobileNo);
            adminTable.getColumns().add(CreditCard);

            st.close();
        } catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
    }
}
