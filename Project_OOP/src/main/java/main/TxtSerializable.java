package main;

import main.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class TxtSerializable {

    public LinkedList<User> deserialization() throws IOException, ClassNotFoundException {
        File file = new File("registeredUsers.out");
        if (file.exists()) {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            LinkedList<User> userList = (LinkedList<User>) inputStream.readObject();
            inputStream.close();
            return userList;
        }
        return new LinkedList<>();
    }

    public void serialization(LinkedList<User> users) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("registeredUsers.out");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);

        outputStream.writeObject(users);
        outputStream.close();
    }

}
