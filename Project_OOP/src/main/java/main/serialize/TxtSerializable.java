package main.serialize;

import main.model.SingletonDatabase;
import main.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class TxtSerializable {

    // ----- S E R I A L I Z A T I O N  O F  L I N K E D  L I S T -----

    public LinkedList<User> deserialization() throws IOException, ClassNotFoundException {
        File file = new File("registeredUsers.out");
        if (file.exists()) {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            LinkedList<User> userList = (LinkedList<User>) inputStream.readObject();
            inputStream.close();

            SingletonDatabase.getInstance().setUserList(userList);

            return userList;
        }
        return new LinkedList<>();
    }

    public void serialization(LinkedList<User> userList) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("registeredUsers.out");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);

        outputStream.writeObject(userList);
        outputStream.close();
    }

}
