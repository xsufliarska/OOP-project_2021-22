package main.serialize;

import main.model.SingletonDatabase;
import main.model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class SerializeTXT {
    // load file
    File file = new File("registeredUsers.txt");
    Scanner fr;
    LinkedList<User> userListTXT;


    // ----- S E R I A L I Z A T I O N  T O  T X T -----

    public void deserializeTXT() throws IOException {
        userListTXT = new LinkedList<User>();
        fr = new Scanner(file);

        while (fr.hasNextLine()) {
            String[] lineSplit;
            String line = fr.nextLine();
            lineSplit = line.split(", ");
            User actual = new User(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6]);
            userListTXT.add(actual);
        }

        SingletonDatabase.getInstance().setUserList(userListTXT);
        // after creating "database" in txt i am going to serialize linked list
        new TxtSerializable().serialization(userListTXT);
    }

    public void serializeTXT(LinkedList<User> userListTXT) throws IOException {
        File file = new File("registeredUsers.txt");
        FileWriter fr = new FileWriter(file, false);            //true - append, false - overwrite

        for (User atIndex: userListTXT) {
            fr.write(atIndex.getUsername() + ", " + atIndex.getPassword() + ", " + atIndex.getName() + ", " +
                    atIndex.wallet.balance + ", " + atIndex.auctionsJoined + ", " + atIndex.auctionsWon + ", " +
                    atIndex.chambersBought + "\n");
        }

        fr.close();
    }
}
