package com.example.rjss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class LoginController extends NullPointerException{
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField u_id;

    @FXML
     private PasswordField u_pass;

    @FXML
    private Label LoginMessage;

    @FXML
    public void onLoginButtonClick(ActionEvent event){
        if (!u_id.getText().isBlank() && !u_pass.getText().isBlank() ){
            validatelogin(event);

        } else {
            LoginMessage.setText("Invalid Username Or Password");
        }
    }



    public void validatelogin(ActionEvent event) {
        DatabaseConnector connectnow = new DatabaseConnector();
        Connection connectdb = connectnow.getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String verifylogin = "select count(1) from UserDetails where Username = '"+u_id.getText()+"' and Password  = '"+u_pass.getText()+"'";
        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.setResizable(false);
                        stage.show();

                    } catch (Exception ep) {
                        ep.printStackTrace();
                    }
                } else {
                    LoginMessage.setText("Invalid Login!");
                }
            }
        } catch (Exception ep) {
            ep.printStackTrace();
        }
    }

//     This is for create account scene

        @FXML
    public void onCreateAccountClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("createacc.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



//    @FXML
//    public void onpassbookButtonClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("passbook.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }



//    public void onHomeButtonClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }


//    public void onFAQsButtonClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("FAQs.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

//    public void onCcButtonClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("cctypes.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }


//    public void onLoanButtonClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("EMI.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

//    @FXML
//    private TextField principalAmt, tenure, result;
//    NumberFormat formatter = new DecimalFormat("#0.00");
//
//    @FXML
//    protected void onCalculateButtonClick(){
//        double amt = Double.parseDouble(principalAmt.getText());
//        double years = Double.parseDouble(tenure.getText());
//        double emi = ((amt*(7.0/1200)*Math.pow(1+(7.0/1200) , years*12))/(Math.pow(1+(7.0/1200) ,years*12)-1));
////    double payableInterest = amt*years*12*
//        result.setText(String.valueOf(formatter.format(emi)));

//    }
//    @FXML
//    public void onApplyButtonClick(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Loan.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    @FXML
//    public void onBackButtonClick(ActionEvent event) throws IOException {          //this is for going back to emi page from apply loan page
//        Parent root = FXMLLoader.load(getClass().getResource("EMI.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }




}

