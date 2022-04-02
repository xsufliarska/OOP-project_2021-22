package main;

import main.model.User;

import java.io.*;
import java.io.Serializable;
import java.util.LinkedList;

public class txtSerializable {

    public void deserialization(LinkedList <User> userList) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/main/registeredUsers.out"));
        userList = (LinkedList<User>) inputStream.readObject();
        inputStream.close();
    }

    public void serialization(User user) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("/main/registeredUsers.out");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);

        outputStream.writeObject(user); /* v () - koho tam chcem supnut - asi toho noveho usera */
        outputStream.close();
    }

}
