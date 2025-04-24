package kiosk.challengelv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private List<MenuItem> ordersMenuList;

    Orders(){
        ordersMenuList = new ArrayList<>();
    }

    public void addOrder(MenuItem menuItem){
        ordersMenuList.add(menuItem);
    }

    public void removeOrders(){
        ordersMenuList.clear();
    }

    public void printOrderList(){
        System.out.println("-----------------------------------------");
        System.out.println("[ ORDER MENU ]");
        ordersMenuList.stream()
                .forEach((m)->System.out.printf("%s | ￦ %.1f | %s \n",
                        m.getName(),
                        m.getPrice(),
                        m.getDescription()));
        System.out.println("\n[ Total ]");
        System.out.printf("￦ %.1f \n", getTotalPrice());
        System.out.println("\n 1. 주문 2. 메뉴판  3. 메뉴취소 ");
        System.out.println("-----------------------------------------");
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
