package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;

public class ControllerHomePageTopBar {

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


    public void addItemsClicked() throws IOException {
        addItemButton.setOnAction(actionEvent -> {
            BorderPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/addItem.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(pane);
        });
    }

    public void auctionsClicked() throws IOException {
        auctionsButton.setOnAction(actionEvent -> {
            BorderPane pane = null;
            try {
                //pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auctionsItemChoose.fxml"));
                pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auctionType.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(pane);
        });
    }

    public void logoutClicked() throws IOException {
        logoutButton.setOnAction(actionEvent -> {
            BorderPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(pane);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful Log out");
            alert.setHeaderText("Mischief managed.");
            alert.setContentText("Log out was successful, see you later");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                }
            });
        });
    }

    public void profileClicked() throws IOException {
        profileButton.setOnAction(actionEvent -> {
            BorderPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/profile.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(pane);
        });
    }

    public void statsClicked() throws IOException {
        statsButton.setOnAction(actionEvent -> {
            BorderPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/stats.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(pane);
        });
    }

    public void walletClicked() throws IOException {
        walletButton.setOnAction(actionEvent -> {
            BorderPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/wallet.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(pane);
        });
    }

}
