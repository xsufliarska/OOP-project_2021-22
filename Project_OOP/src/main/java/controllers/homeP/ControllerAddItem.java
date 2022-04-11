package controllers.homeP;

import controllers.ControllerHomePageTopBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import main.model.auction.AuctionedItem;
import main.model.singleton.SingletonUser;
import main.serialize.ItemsSerializeTXT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAddItem extends ControllerHomePageTopBar implements Initializable {
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
    private Button addItemConfirmButton;
    @FXML
    private Button chooseImageButton;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField nameField;
    @FXML
    private TextField valueField;


    AuctionedItem newItem = new AuctionedItem();

    @FXML
    void addItemsConfirmClicked(ActionEvent event) throws IOException {
        ObservableList<AuctionedItem> auctionsList;
        auctionsList = new ItemsSerializeTXT().deserializeAuctions();
        new ItemsSerializeTXT().serializeAuctions(auctionsList);

        newItem.name = nameField.getText().toString();
        newItem.startingPrice = Integer.parseInt(valueField.getText().toString());
        newItem.usersName = SingletonUser.getInstance().getUser().getUsername();
        newItem.currentBid = 0;

        auctionsList.add(newItem);

        new ItemsSerializeTXT().serializeAuctions(auctionsList);
        new ItemsSerializeTXT().deserializeAuctions();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Item was added successfully");
        alert.setHeaderText("10 point for Gryffindor for adding new item to auction");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }

    @FXML
    void chooseImageButtonClicked(ActionEvent event) throws FileNotFoundException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Images", "*.png", "*.jpeg", "*.jpg");
        chooser.getExtensionFilters().add(filter);
        chooser.setSelectedExtensionFilter(filter);

        File file = chooser.showOpenDialog(chooseImageButton.getScene().getWindow());

        if(file != null) {
            imageView.setImage(new Image(new FileInputStream(file.getPath())));
        }

        newItem.imagePath = file.getPath();
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


        valueField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    valueField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
