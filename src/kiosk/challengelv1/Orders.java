package kiosk.challengelv1;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<MenuItem> ordersMenuList;

    Orders(){
        ordersMenuList = new ArrayList<>();
    }

    // 장바구니 추가
    public void addOrder(MenuItem menuItem){
        ordersMenuList.add(menuItem);
    }

    // 장바구니 비우기
    public void removeOrders(){
        ordersMenuList.clear();
    }

    public List<MenuItem> getOrdersMenuList() {
        return ordersMenuList;
    }

    // 장바구니 토탈금액 메서드
    public float getTotalPrice(){
        float totalPrice = 0;
        for(MenuItem m : ordersMenuList){
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }
}
