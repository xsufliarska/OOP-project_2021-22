package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;

import java.io.IOException;

public class Controller {

    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private BorderPane rootPane;

    @FXML
    void loginScreen(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void registerScreen(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
