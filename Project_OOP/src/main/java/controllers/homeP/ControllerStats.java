package controllers.homeP;

import controllers.ControllerHomePageTopBar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.model.singleton.SingletonUser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStats extends ControllerHomePageTopBar implements Initializable {

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
    private Button statsButton;
    @FXML
    private Button walletButton;


    @FXML
    private TextField auctionsAttended;
    @FXML
    private TextField auctionsWon;
    @FXML
    private TextField chambersBought;



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



        auctionsAttended.setText(String.valueOf(SingletonUser.getInstance().getUser().auctionsJoined));
        auctionsWon.setText(String.valueOf(SingletonUser.getInstance().getUser().auctionsWon));
        chambersBought.setText(String.valueOf(SingletonUser.getInstance().getUser().chambersBought));
    }
}
