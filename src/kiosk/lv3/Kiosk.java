package kiosk.lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItemList;
    Scanner sc = new Scanner(System.in);

    Kiosk(List<MenuItem> menuItemList){
        this.menuItemList = menuItemList;
    }

    public void start(){
        printMenu();
        selectMenu();
    }

    private void printMenu(){
        System.out.println("[ SHAKESHACK MENU ]");
        int menuNumber = 1;
        for(MenuItem m : menuItemList){
            System.out.printf("%d. %s | ￦ %.1f | %s \n", menuNumber, m.getName(), m.getPrice(), m.getDescription());
            menuNumber++;
        }
        System.out.println("0. 종료      | 종료");
    }


    private void selectMenu(){
        System.out.print("메뉴번호를 입력해주세요 : ");
        String inputText = sc.nextLine();
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
