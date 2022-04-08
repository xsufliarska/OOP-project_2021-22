package controllers.homeP.auction;

import controllers.ControllerHomePageTopBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NOT_USEDControllerAuctionType extends ControllerHomePageTopBar implements Initializable {

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
    private Button FPSB_AuctionButton;
    @FXML
    private Button FPSB_AuctionInfoButton;
    @FXML
    private Button englishAuctionButton;
    @FXML
    private Button englishAuctionInfoButton;
    @FXML
    private Button japaneseAuctionButton;
    @FXML
    private Button japaneseAuctionInfoButton;

    @FXML
    void FPSB_AuctionInfoButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("First-Price Sealed-Bid Auction / Blind Auction");
        alert.setHeaderText(
                "Offer the highest bid you are willing to pay to the auctioneer.\n" +
                "If your bid was the highest, the item is yours."
        );
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }

    @FXML
    void englishAuctionInfoButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("English Auction");
        alert.setHeaderText(
                "Auctioneer opens the auction by announcing the starting\n" +
                "price. Place higher bids than other interested buyers on the\n" +
                "item. Hopefully your bid will be the highest and accepted\n" +
                "by the auctioneer.");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }

    @FXML
    void japaneseAuctionInfoButtonClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Japanese Auction");
        alert.setHeaderText(
                "An initial price is displayed. If you are interested in\n" +
                "buying the item for this price, you will enter the auction\n" +
                "arena. The displayed price  increases. You may leave whenever\n" +
                "you want. You can also re-enter arena. (rather not - nechce sa mi...)\n" +
                "The last buyer remained in arena wins and auction is stopped."
        );
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }

    @FXML
    void FPSB_Auction_START(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/auctionsChoose.fxml"));
        rootPane.getChildren().setAll(pane);
        //supni niekam ze sa jedna o fpsb
        //ak nie je stlaceny item or chamber tak to nesetni ofc

    }

    @FXML
    void englishAuction_START(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/auctionsChoose.fxml"));
        rootPane.getChildren().setAll(pane);
        //supni niekam ze sa jedna o english auction
        //ak nie je stlaceny item or chamber tak to nesetni ofc
    }

    @FXML
    void japaneseAuction_START(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/homeP/auction/auctionsChoose.fxml"));
        rootPane.getChildren().setAll(pane);
        //supni niekam ze sa jedna o japanese auction
        //ak nie je stlaceny item or chamber tak to nesetni ofc
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

    public void joinAuctionClicked(ActionEvent actionEvent) {
    }
}
