package com.example.rjss;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Optional;


public class LoanController  extends NullPointerException{



    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField pno;

    @FXML
    private TextField dob;

    @FXML
    private TextField mail;

    @FXML
    private TextField pin;

    @FXML
    private TextField phone;

    @FXML
    private TextArea add;

    @FXML
    private Label createMessage;


    public void onBackClick(ActionEvent event) throws IOException {          //this is for going back to emi page from apply loan page
        Parent root = FXMLLoader.load(getClass().getResource("EMI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void LoanDetails(ActionEvent mouseEvent) throws SQLException, IOException {
        if (!fname.getText().isBlank() && !lname.getText().isBlank() && !pno.getText().isBlank() && !dob.getText().isBlank() && !mail.getText().isBlank() && !add.getText().isBlank() && !phone.getText().isBlank() && !pin.getText().isBlank()) {
            if (createAccount()) {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Successfully.fxml")));
                stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setTitle("RJSS");
                stage.setScene(new Scene(root));
                stage.show();
            }
        } else {
//            createMessage.setText("Please fill all the details.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Alert Dialog");
            alert.setContentText("Please fill in all the Fields.");
            alert.showAndWait();

        }
    }

    private boolean createAccount() throws SQLException{
        DatabaseConnector connector = new DatabaseConnector();
        Connection connectDB = connector.getConnection();

        String insertDetails = "insert into personal_loan values('"+fname.getText()+"','"+lname.getText()+"','"+pno.getText()+"',"+dob.getText()+" ,'"+mail.getText()+"','"+add.getText()+"',"+pin.getText()+","+phone.getText()+"\n)";

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
}