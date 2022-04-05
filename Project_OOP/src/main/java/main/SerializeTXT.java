package main;

import main.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SerializeTXT {
    // load file
    File file = new File("registeredUsers.txt");
    Scanner fr;
    LinkedList<User> usersTXT;

    public void deserializeTXT() throws IOException {
        usersTXT = new LinkedList<User>();
        fr = new Scanner(file);

        while (fr.hasNextLine()) {
            String[] lineSplit;
            String line = fr.nextLine();
            lineSplit = line.split(", ");
            User actual = new User(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6]);
            usersTXT.add(actual);
        }

        new TxtSerializable().serialization(usersTXT);
    }

    public void serializeTXT(LinkedList<User> usersTXT) throws IOException {

    }
}
