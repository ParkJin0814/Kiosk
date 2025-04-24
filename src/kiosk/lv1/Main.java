package kiosk.lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputText = "";
        String[] menus = new String[4];
        menus[0] = "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거";
        menus[1] = "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
        menus[2] = "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
        menus[3] = "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거";

        while (!inputText.equals("0")){
            System.out.println("[ SHAKESHACK MENU ]");
            for(String s : menus){
                System.out.println(s);
            }

            System.out.println("0. 종료      | 종료");

            inputText = sc.nextLine();
        }
    }
}