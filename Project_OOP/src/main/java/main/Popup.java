package main;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Popup {
    private Button ok = new Button("OK");
    private Text eAuction = new Text();
    private Text englishAuction = new Text();
    private Text jAuction = new Text();
    private Text japaneseAuction = new Text();
    private Text fAuction = new Text();
    private Text fpsbAuction = new Text();

    public void initialize() {

        Stage stage = new Stage();
        stage.setTitle("Info PopUp");
        stage.show();

        stage.setX(450);
        stage.setY(250);

        AnchorPane pane = new AnchorPane();

        Scene scene = new Scene(pane, 600, 235);
        stage.setScene(scene);

        Text eAuction = new Text(10, 20,"English Auction");
        Text englishAuction = new Text(10, 40, "Auctioneer opens the auction by announcing the starting price. Place higher bids than other interested buyers on the item. Hopefully your bid will be the highest and accepted by the auctioneer.");
        Text jAuction = new Text(10, 80, "Japanese Auction");
        Text japaneseAuction = new Text(10, 100, "An initial price is displayed. If you are interested in buying the item for this price, you will enter the auction arena. The displayed price increases. You may leave whenever you want. The last buyer remained in arena wins and auction is stopped.");
        Text fAuction = new Text(10, 160, "First-Price Sealed-Bid Auction / Blind Auction");
        Text fpsbAuction = new Text(10, 180, "Offer the highest bid you are willing to pay to the auctioneer. If your bid was the highest, the item is yours.");



        englishAuction.setWrappingWidth(575);
        englishAuction.setTextAlignment(TextAlignment.JUSTIFY);
        japaneseAuction.setWrappingWidth(575);
        japaneseAuction.setTextAlignment(TextAlignment.JUSTIFY);
        fpsbAuction.setWrappingWidth(575);
        fpsbAuction.setTextAlignment(TextAlignment.JUSTIFY);

        ok.setLayoutX(300);
        ok.setLayoutY(200);

        pane.getChildren().add(eAuction);
        pane.getChildren().add(englishAuction);
        pane.getChildren().add(jAuction);
        pane.getChildren().add(japaneseAuction);
        pane.getChildren().add(fAuction);
        pane.getChildren().add(fpsbAuction);

        pane.getChildren().add(ok);

        //TODO handler
        ok.setOnAction(actionEvent -> {
            //Platform.exit();        //closes everything
            stage.close();
        });
    }
}
