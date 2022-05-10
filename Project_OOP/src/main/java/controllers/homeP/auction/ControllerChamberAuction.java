package controllers.homeP.auction;

import javafx.collections.FXCollections;
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
import main.model.auction.Chamber;
import main.model.singleton.SingletonChamber;
import main.model.singleton.SingletonItem;
import main.serialize.ChambersSerializeTXT;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ControllerChamberAuction extends ControllerObjectAuction implements Initializable {

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
    private ListView<Chamber> listAuction;



    ObservableList<String> auctionList = FXCollections.observableArrayList("English Auction", "");

    Chamber chosen = null;
    ObservableList<Chamber> auctionChambers = null;

    @FXML
    void joinAuctionClicked(ActionEvent event) throws IOException {
        if(typeOfAuction.getValue() != "" && chosen != null) {

            //new Auction(chosen, typeOfAuction.getValue());
            SingletonChamber.getInstance().setChamber(chosen);
            SingletonItem.getInstance().setTypeOfAuction(typeOfAuction.getValue());

//            BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/auction.fxml"));
//            rootPane.getChildren().setAll(pane);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/homeP/auction/auction.fxml"));
            Parent root = (Parent) loader.load();

            Stage stage = new Stage();
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
        File file = new File("chambersAuction.txt");
        Scanner fr;

        ChambersSerializeTXT items = new ChambersSerializeTXT();
        try {
            auctionChambers = items.deserializeAuctions(auctionChambers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        listAuction.getItems().clear();
        listAuction.setItems(auctionChambers);


        //TODO handler
        //TODO lambda
        listAuction.getSelectionModel().selectedItemProperty().addListener((observableValue, auctionedItem, t1) -> {

            int index = 0;
            index = listAuction.getSelectionModel().getSelectedIndex();
            chosen = auctionChambers.get(index);

            try {
                imageItem.setImage(new Image(new FileInputStream(chosen.imagePath)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void observableListLoad() {
        typeOfAuction.setValue("");
        typeOfAuction.setItems(auctionList);
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


        observableListLoad();
        listViewLoad();
    }
}
