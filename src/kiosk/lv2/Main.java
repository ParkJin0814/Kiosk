package kiosk.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputText;
        List<MenuItem> menuItemList = new ArrayList<>();

        menuItemList.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));


        System.out.println("[ SHAKESHACK MENU ]");
        int menuNumber = 1;
        for(MenuItem m : menuItemList){
            System.out.printf("%d. %s | ￦ %.1f | %s \n", menuNumber, m.getName(), m.getPrice(), m.getDescription());
            menuNumber++;
        }


        System.out.println("0. 종료      | 종료");
        System.out.print("메뉴번호를 입력해주세요 : ");
        inputText = sc.nextLine();
        try {
            int index = Integer.parseInt(inputText) -1;
            System.out.printf("선택된 메뉴는 %s | ￦ %.1f | %s 입니다.\n",
                    menuItemList.get(index).getName(),
                    menuItemList.get(index).getPrice(),
                    menuItemList.get(index).getDescription());
        } catch (Exception e){
            System.out.println("제시된 숫자중에서 입력해주세요");
        }
    }
}