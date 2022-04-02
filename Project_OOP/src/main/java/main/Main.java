package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.model.*;

import java.io.IOException;
import java.util.LinkedList;

public class Main extends Application {

//-------------------------------------------------------------------
    /*User user = null;
    LinkedList<User> userList = null;*/

    SingletonUser user = SingletonUser.getInstance();
    // SingletonUser.setUser(new User());
//-------------------------------------------------------------------

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/main.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("ONLINE AUCTION SYSTEM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}