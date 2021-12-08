package com.example.rjss;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Passbook implements Initializable {

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private TableView<table> table;

    @FXML
    private TableColumn<table, String> date;

    @FXML
    private TableColumn<table, String > details;

    @FXML
    private TableColumn<table, String> amount;

//    @FXML
//    private Button gotohome;

    @FXML
    public void onHomeButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    ObservableList<table> list = FXCollections.observableArrayList(

            new table("2021-01-01","48102659","10000"),
            new table("2021-02-14","14526987","5000"),
            new table("2021-02-28","24578102","8000"),
            new table("2021-03-04","34851568","1000"),
            new table("2021-04-21","49203568","50000"),
            new table("2021-08-21","54201036","20000"),
            new table("2021-09-08","61204878","1500"),
            new table("2021-10-15","62114578","50300"),
            new table("2021-10-25","72114578","2000"),
            new table("2021-11-02","82143578","500"),
            new table("2021-11-12","92654578","3500"),
            new table("2021-12-12","92994578","100000")
    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      date.setCellValueFactory(new PropertyValueFactory<table, String>("date"));
      details.setCellValueFactory(new PropertyValueFactory<table, String>("details"));
      amount.setCellValueFactory(new PropertyValueFactory<table, String>("amount"));
    table.setItems(list);
    }

}
