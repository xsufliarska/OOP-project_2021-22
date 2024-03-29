package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.model.singleton.SingletonDatabase;
import main.serialize.SerializeTXT;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        //not working
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/pictures/logos/logo.png")));

        stage.setTitle("BID CHAMBER");
        stage.setScene(scene);
        stage.show();


        stage.setOnCloseRequest(windowEvent -> {
            try {
                //serialize linked list
                //new TxtSerializable__NOT_USED().serialization(SingletonDatabase.getInstance().getUserList());
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