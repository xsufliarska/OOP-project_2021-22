package controllers.homeP.auction;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.Auction;
import main.model.singleton.SingletonItem;
import main.model.auction.AuctionedItem;
import main.serialize.ItemsSerializeTXT;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ControllerItemAuction extends ControllerObjectAuction implements Initializable {

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


    /*ObservableList<String> auctionList = FXCollections.observableArrayList("English Auction",
            "Japanese Auction", "First-Price Sealed-Bid Auction", "");*/

    AuctionedItem chosen = null;
    ObservableList<AuctionedItem> auctionItems = null;


    @FXML
    void joinAuctionClicked(ActionEvent event) throws IOException {
        if(typeOfAuction.getValue() == "Japanese Auction") {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please choose other type of auction");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {}
            });
        }
        else if(typeOfAuction.getValue() != "" && chosen != null) {

            SingletonItem.getInstance().setAuctionedItem(chosen);
            SingletonItem.getInstance().setTypeOfAuction(typeOfAuction.getValue());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/homeP/auction/auction.fxml"));
            Parent root = (Parent) loader.load();

            Stage stage = new Stage();
            stage.setOnCloseRequest(windowEvent -> {
                listViewLoad();
            });
            stage.setScene(new Scene(root));
            stage.show();
        }
        else if(typeOfAuction.getValue() == "") {
            info.setAlignment(Pos.CENTER_LEFT);
            info.setText("Choose type of auction");
        }
        else {
            info.setAlignment(Pos.CENTER_LEFT);
            info.setText("Choose auction");
        }
    }

    public void listViewLoad() {
        // load file
        File file = new File("itemsAuction.txt");
        Scanner fr;

        try {
            auctionItems = new ItemsSerializeTXT().deserializeAuctions();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        listAuction.getItems().clear();
        listAuction.setItems(auctionItems);


        listAuction.getSelectionModel().selectedItemProperty().addListener((observableValue, auctionedItem, t1) -> {

            if (t1 != null) {
                chosen = t1;

                try {
                    imageItem.setImage(new Image(new FileInputStream(chosen.imagePath)));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

   /* @FXML
    void auctionInfoButtonClicked(ActionEvent event) throws IOException {
        Popup infoPopup = new Popup();
        infoPopup.initialize();
    }*/


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


        super.observableListLoad();
        listViewLoad();
    }
}
