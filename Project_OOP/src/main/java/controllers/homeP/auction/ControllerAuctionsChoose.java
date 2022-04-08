package controllers.homeP.auction;

import controllers.ControllerHomePageTopBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAuctionsChoose extends ControllerHomePageTopBar implements Initializable {

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
    private Button chamberButton;
    @FXML
    private Button itemButton;


    @FXML
    void itemClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/itemAuction.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void chamberClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/chamberAuction.fxml"));
        rootPane.getChildren().setAll(pane);
    }



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
    }
}
