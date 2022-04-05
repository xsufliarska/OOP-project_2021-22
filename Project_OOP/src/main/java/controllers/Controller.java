package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.SerializeTXT;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*try {
            new SerializeTXT().deserializeTXT();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
