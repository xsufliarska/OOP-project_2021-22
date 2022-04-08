package controllers.homeP.auction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAuction implements Initializable {

    @FXML
    private Button bidButton;
    @FXML
    private TextField bidField;
    @FXML
    private Button leaveButton;
    @FXML
    private Text nameOfObject;
    @FXML
    private BorderPane rootPane;
    @FXML
    private Text valueOfObject;
    @FXML
    private Text valueOfObject1;

    @FXML
    void bid(ActionEvent event) {

    }

    @FXML
    void leave(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
