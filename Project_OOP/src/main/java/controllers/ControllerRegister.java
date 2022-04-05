package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.Authentication;

import java.io.IOException;

public class ControllerRegister {

    @FXML
    private Button mainButton;
    @FXML
    private TextField info;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private PasswordField passwordField2;
    @FXML
    private Button registerButton;
    @FXML
    private BorderPane rootPane;
    @FXML
    private TextField usernameField;


    String registerUsername;
    String registerName;
    String registerPassword1;
    String registerPassword2;

    boolean isRegistered = false;


    @FXML
    void goToMain(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void register(ActionEvent event) throws IOException {

        registerUsername = usernameField.getText().toString();
        registerName = nameField.getText().toString();
        registerPassword1 = passwordField1.getText().toString();
        registerPassword2 = passwordField2.getText().toString();


        if (registerUsername == "" || registerName == "" || registerPassword1 == "" || registerPassword2 == "") {
            info.setText("Please enter username and password");
        }
        else if(!(registerPassword2.equals(registerPassword1))) {
            info.setText("You entered wrong password. Please try again");
        }
        else if(registerPassword2.equals(registerPassword1) && registerUsername != null && registerPassword1 != null) {
            Authentication database = new Authentication();
            isRegistered = database.register(registerUsername, registerName, registerPassword1);

            if(isRegistered == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful Registration");
                alert.setHeaderText("Your registration was successful, please log in");
                //alert.setContentText("I have a great message for you!");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        //System.out.println("Log in");
                    }
                });

                BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
                rootPane.getChildren().setAll(pane);
            }
            else {
                info.setText("Username is already used");
            }
        }
    }
}
