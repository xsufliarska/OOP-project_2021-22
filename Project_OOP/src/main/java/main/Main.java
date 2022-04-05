package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.*;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("BID CHAMBER");
        stage.setScene(scene);
        stage.show();


        /*stage.setOnCloseRequest(event -> {
            try {
                //serialize linked list
                new TxtSerializable().serialization(*//* sem musi ist ten linked list *//*);
                //deserialize
                new SerializeTXT().serializeTXT(*//* sem musi ist ten linked list *//*);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
    }

    public static void main(String[] args) {
        launch();
    }
}