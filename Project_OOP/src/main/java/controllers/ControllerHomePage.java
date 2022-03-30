package controllers;

import controllers.homeP.ControllerHomePageTopBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;

public class ControllerHomePage extends ControllerHomePageTopBar {

    @FXML
    private Button addItemButton;
    @FXML
    private Button auctionsButton;
    @FXML
    private HBox buttonBar;
    @FXML
    private ImageView logoutIcon;
    @FXML
    private Button menuButton;
    @FXML
    private Button profileButton;
    @FXML
    private BorderPane rootPane;
    @FXML
    private ImageView settingsIcon;
    @FXML
    private Button statsButton;
    @FXML
    private Button walletButton;


    @FXML
    void addItemsClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/addItem.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void auctionsClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auctions.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void logoutIconClicked(MouseEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        rootPane.getChildren().setAll(pane);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successful Log out");
        alert.setHeaderText("Mischief managed.");
        alert.setContentText("Log out was successful, see you later");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }

    @FXML
    void menuClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void profileClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/profile.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void statsClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/stats.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void walletClicked(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/wallet.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
