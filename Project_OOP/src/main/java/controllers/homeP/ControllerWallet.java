package controllers.homeP;

import controllers.ControllerHomePageTopBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.model.SingletonUser;
import main.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerWallet extends ControllerHomePageTopBar implements Initializable {

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
    private Button addCashButton;
    @FXML
    private TextField amountField;
    @FXML
    private TextField balance;
    @FXML
    private Button cashOutButton;

    User user = SingletonUser.getInstance().getUser();
    int amount = 0;

    @FXML
    void addCash(ActionEvent event) {
        if(amountField.getText() != "") {
            amount = Integer.parseInt(amountField.getText());
        }

        user.wallet.charge(amount);

        balance.setText(user.wallet.balance + " €");
        amountField.clear();                                // not necessary
    }

    @FXML
    void cashOut(ActionEvent event) {
        if(amountField.getText() != "") {
            amount = Integer.parseInt(amountField.getText());
        }

        user.wallet.withdraw(amount);

        balance.setText(user.wallet.balance + " €");
        amountField.clear();                                // not necessary
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



        balance.setText(user.wallet.balance + " €");

        amountField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    //"\\d{0,7}([\\.]\\d{0,4})?" - desatinne cislo; velkost 0-7 cisel, bodka, 0-4 cisla, bodka moze nemusi byt

                    amountField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

}
