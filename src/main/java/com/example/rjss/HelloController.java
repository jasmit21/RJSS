package com.example.rjss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.lang.Math;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class HelloController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
        public void onpassbookButtonClick(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("passbook.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }



    public void onHomeButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void onFAQsButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FAQs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onCcButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cctypes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void onLoanButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EMI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

 @FXML
    private TextField principalAmt, tenure, result;
    NumberFormat formatter = new DecimalFormat("#0.00");

@FXML
    protected void onCalculateButtonClick(){
    double amt = Double.parseDouble(principalAmt.getText());
    double years = Double.parseDouble(tenure.getText());
    double emi = ((amt*(7.0/1200)*Math.pow(1+(7.0/1200) , years*12))/(Math.pow(1+(7.0/1200) ,years*12)-1));
//    double payableInterest = amt*years*12*
    result.setText(String.valueOf(formatter.format(emi)));

}

}

