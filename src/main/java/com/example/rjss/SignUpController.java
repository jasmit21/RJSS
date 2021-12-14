package com.example.rjss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Optional;


public class SignUpController {

    private Parent root;
    private Stage stage;
    private Scene scene;


    @FXML
        private Pane creditpage;

        @FXML
        private Pane border;

        @FXML
        private Label heading;

        @FXML
        private TextField u_name;

        @FXML
        private TextField first_name;

        @FXML
        private TextField last_name;

        @FXML
        private TextField phone;

        @FXML
        private TextField email_id;

        @FXML
        private TextField aadhar;

        @FXML
        private TextField pan;

        @FXML
        private PasswordField password;

        @FXML
        private TextField state;

        @FXML
        private TextField dist;

        @FXML
        private TextField city;

        @FXML
        private TextField pin_code;



    @FXML
    private void Register(ActionEvent mouseEvent) throws SQLException, IOException{
        if (!u_name.getText().isBlank()  && !password.getText().isBlank() && !first_name.getText().isBlank() && !last_name.getText().isBlank() && !phone.getText().isBlank() && !email_id.getText().isBlank() && !aadhar.getText().isBlank() &&  !pan.getText().isBlank() &&!state.getText().isBlank() && !city.getText().isBlank() && !dist.getText().isBlank() && !pin_code.getText().isBlank()) {
            if (createAccount()) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setContentText("Congratulations!!.\nYou have now successfully created account in RJSS Bank. You will receive an E-mail acknowledging your successful account creation, and the E-mail will include the Username that you selected which will be required for Login your account.\n\n");
                alert.showAndWait();


                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));
                stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
                stage.setTitle("RJSS");
                stage.setScene(new Scene(root));
                stage.show();
            }
        } else if(u_name.getText().isBlank()  || password.getText().isBlank() || first_name.getText().isBlank() || last_name.getText().isBlank() || phone.getText().isBlank() || email_id.getText().isBlank() || aadhar.getText().isBlank()  || pan.getText().isBlank() || state.getText().isBlank() || city.getText().isBlank() || dist.getText().isBlank() || pin_code.getText().isBlank()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert Dialog");
            alert.setContentText("Please fill in all the Fields.");
            alert.showAndWait();

        }

    }

    private boolean createAccount() throws SQLException{
        DatabaseConnector connector = new DatabaseConnector();
        Connection connectDB = connector.getConnection();

        String insertDetails = "insert into UserDetails values('"+u_name.getText()+"', '"+first_name.getText()+"', '"+last_name.getText()+"' , "+password.getText()+" ,'"+email_id.getText()+"', "+phone.getText()+" , "+aadhar.getText()+",'"+pan.getText()+"', '"+city.getText()+"' , '"+dist.getText()+"' ,'"+state.getText()+"' , "+pin_code.getText()+")";

        try {
            Statement statement = connectDB.createStatement();
            int a = statement.executeUpdate(insertDetails);
            if (a == 1) {

                return true;
            }


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }

    @FXML
    public void backBtn(ActionEvent mouseEvent) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));
            stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("RJSS");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

