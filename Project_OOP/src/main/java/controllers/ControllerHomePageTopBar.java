package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.serialize.SerializeTXT;
import main.model.singleton.SingletonDatabase;
import main.model.singleton.SingletonUser;
import main.model.User;

import java.io.IOException;
import java.util.LinkedList;

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
    private Button statsButton;
    @FXML
    private Button walletButton;


    User user = SingletonUser.getInstance().getUser();
    LinkedList<User> userListFORNOW = SingletonDatabase.getInstance().getUserList();

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
                pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/auctionsChoose.fxml"));
                //pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/NOT_USEDauctionType.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(pane);
        });
    }

    public void logoutClicked() throws IOException {
        logoutButton.setOnAction(actionEvent -> {
            try {
                //serialize linked list
                //new TxtSerializable__NOT_USED().serialization(SingletonDatabase.getInstance().getUserList());
                //serialize to txt
                new SerializeTXT().serializeTXT(SingletonDatabase.getInstance().getUserList());

            } catch (Exception e) {
                e.printStackTrace();
            }

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
