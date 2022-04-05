package controllers.homeP;

import controllers.ControllerHomePageTopBar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import main.model.SingletonUser;

public class ControllerProfile extends ControllerHomePageTopBar implements Initializable {

    @FXML
    private Button addItemButton;
    @FXML
    private Button auctionsButton;
    @FXML
    private HBox buttonBar;
    @FXML
    private Button logoutButton;
    @FXML
    private Button profileButton;
    @FXML
    private BorderPane rootPane;
    @FXML
    private Button settingsIcon;
    @FXML
    private Button statsButton;
    @FXML
    private Button walletButton;

    @FXML
    private TextField balance;
    @FXML
    private TextField name;
    @FXML
    private TextField username;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addItemsClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            auctionsClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            logoutClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            profileClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            statsClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            walletClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }


        name.setText(SingletonUser.getInstance().getUser().getName());
        username.setText(SingletonUser.getInstance().getUser().getUsername());
        balance.setText(SingletonUser.getInstance().getUser().wallet.balance + "€");
    }
}
