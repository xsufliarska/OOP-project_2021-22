package controllers.homeP.auction;

import controllers.ControllerHomePageTopBar;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import main.Auction;
import main.Popup;
import main.model.auction.AuctionedItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

abstract class ControllerObjectAuction extends ControllerHomePageTopBar implements Initializable {

    //TODO polymorphism
    //TODO inheritance

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
    private ImageView imageItem;
    @FXML
    private TextField info;
    @FXML
    private Button auctionInfoButton;

    @FXML
    private Button joinAuctionButton;
    @FXML
    private ComboBox<String> typeOfAuction;
    @FXML
    private ListView<AuctionedItem> listAuction;


    ObservableList<String> auctionList = FXCollections.observableArrayList("English Auction",
            "Japanese Auction", "First-Price Sealed-Bid Auction", "");

    AuctionedItem chosen = null;
    ObservableList<AuctionedItem> auctionItems = null;


    @FXML
    abstract void joinAuctionClicked(ActionEvent event) throws IOException;

    abstract void listViewLoad();

    public void observableListLoad() {
        typeOfAuction.setValue("");
        typeOfAuction.setItems(auctionList);

        /*typeOfAuction.setOnAction(actionEvent -> {
            new Auction(typeOfAuction.getValue());
        });*/
    }

    @FXML
    void auctionInfoButtonClicked(ActionEvent event) throws IOException {
        Popup infoPopup = new Popup();
        infoPopup.initialize();
    }


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
