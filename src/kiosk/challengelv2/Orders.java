package kiosk.challengelv2;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<MenuItem> ordersMenuList;
    private float totalPrice;

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
        for(MenuItem m : ordersMenuList){
            System.out.printf("%s | ￦ %.1f | %s \n",
                    m.getName(),
                    m.getPrice(),
                    m.getDescription());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("￦ %.1f \n", getTotalPrice());
        System.out.println("\n 1. 주문 \n 2. 메뉴판");
        System.out.println("-----------------------------------------");
    }


    public List<MenuItem> getOrdersMenuList() {
        return ordersMenuList;
    }

    public float getTotalPrice(){
        totalPrice = 0;
        for(MenuItem m : ordersMenuList){
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }
}
