package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.*;
import main.serialize.SerializeTXT;
import main.serialize.TxtSerializable;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("BID CHAMBER");
        stage.setScene(scene);
        stage.show();


        stage.setOnCloseRequest(windowEvent -> {
            try {
                //serialize linked list
                new TxtSerializable().serialization(SingletonDatabase.getInstance().getUserList());
                //serialize to txt
                new SerializeTXT().serializeTXT(SingletonDatabase.getInstance().getUserList());

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}