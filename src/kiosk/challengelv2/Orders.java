package kiosk.challengelv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private List<MenuItem> ordersMenuList = new ArrayList<>();

    public void addOrder(MenuItem menuItem){
        ordersMenuList.add(menuItem);
    }

    public void removeOrders(){
        ordersMenuList.clear();
    }

    public List<MenuItem> getOrdersMenuList() {
        return ordersMenuList;
    }

    public float getTotalPrice(){
        float totalPrice = 0;
        for(MenuItem m : ordersMenuList){
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }

    public void removeOrderMenuItem(String menuItemName){
        ordersMenuList = ordersMenuList.stream()
                .filter((a) -> !a.getName().toLowerCase().contains(menuItemName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
