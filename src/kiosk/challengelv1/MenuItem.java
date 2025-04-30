package kiosk.challengelv1;

public class MenuItem {
    private final String name;
    private final float price;
    private final String description;

    MenuItem(String name, float price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public float getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-15s | ￦ %-5.1f | %s", name, price, description);
    }
}
