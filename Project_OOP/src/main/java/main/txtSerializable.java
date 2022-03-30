package main;

import java.io.*;

public class txtSerializable {

    public void deserialization() throws IOException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/main/registeredUsers.out"));
        //List<User/*typ veci v linked liste*/> users = (List<User/*typ veci v linked liste*/>) inputStream.readObject/*trieda na vytvorenie objektu asi*/();
        inputStream.close();
    }

    public void serialization() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("/main/registeredUsers.out");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);

        //outputStream.writeObject(/* koho tam chcem supnut - asi toho noveho usera */);
        outputStream.close();
    }

}
