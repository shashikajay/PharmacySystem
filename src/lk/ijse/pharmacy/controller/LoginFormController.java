package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginFormController {
    public AnchorPane loginpane;
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    public TextField txtUname;
    public PasswordField txtPw;

    public void btnExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {

        if(txtUname.getText().equals("admin") && txtPw.getText().equals("12345")){
            setUi("AdminConrollerForm");
        } else if (txtUname.getText().equals("user") && txtPw.getText().equals("12345")) {
            setUi("SearchRoomForm");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Password");
            alert.setHeaderText("Invalid User Name or Password!");
            alert.setContentText("Please, check your User Name and Password, and try again!");
            alert.showAndWait();
        }


    }
    private void setUi(String ui) throws IOException {
        Stage stage = (Stage) loginpane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource( "/lk/ijse/pharmacy/view/AddMedicinesForm.fxml"))));
        stage.show();
    }


}
