package controllers;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import main.Entry;

        import java.io.IOException;

public class ControllerLogin {

    @FXML
    private TextField info;
    @FXML
    private Button loginButton;
    @FXML
    private Button mainButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private BorderPane rootPane;
    @FXML
    private TextField usernameField;


    String loginUsername;
    String loginPassword;
    boolean rightUser = false;


    @FXML
    void goToMain(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        loginUsername = usernameField.getText().toString();
        loginPassword = passwordField.getText().toString();

        if (loginUsername == "" || loginPassword == "") {
            info.setText("Please enter username and password");
        }
        else if(loginUsername != null && loginPassword != null) {
            Entry user = new Entry();
            rightUser = user.checkIfCorrect(loginUsername, loginPassword);

            if(rightUser == false) {
                info.setText("Username or password is not right");
            }
            else {
                BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homePage.fxml"));
                rootPane.getChildren().setAll(pane);


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful Log in");
                alert.setHeaderText("I solemnly swear that I am up to no good.");
                alert.setContentText("Log in was successful");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {}
                });
            }
        }
    }

}
