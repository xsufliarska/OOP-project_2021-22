package main.model.auction;

public class ItemChamber {
    public String name= "";
    public int value = 0;

    public ItemChamber(String name, String value) {
        this.name = name;
        this.value = Integer.parseInt(value);
    }
}
