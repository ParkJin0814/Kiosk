package kiosk.challengelv1;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList;
    private Scanner sc = new Scanner(System.in);

    Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }

    public void start(){
        selectMainMenu();
    }

    private int inputNumber(int length){
        while (true){
            try {
                System.out.println("-----------------------------------------");
                System.out.print("번호를 입력해주세요 : ");
                String inputText = sc.nextLine();
                int index = Integer.parseInt(inputText) -1;
                // 메뉴아이템으로 넘어가기
                if(index < -1 || index > length - 1){
                    throw new Exception();
                }
                System.out.println("-----------------------------------------");
                return index;
            } catch (Exception e){
                System.out.println("제시된 숫자중에서 입력해주세요");
            }
        }
    }

    private void printMainMenuList(){
        System.out.println("[ Main MENU ]");
        int menuNumber = 1;
        for(Menu m : menuList){
            System.out.printf("%d. %s\n", menuNumber, m.getTitleName());
            menuNumber++;
        }
        System.out.println("0. 종료      | 종료");
    }

    private void selectMainMenu(){
        printMainMenuList();

        int index = inputNumber(menuList.size());
        if(index != -1) {
            selectItem(menuList.get(index));
        }
    }

    private void selectItem(Menu menu){
        menu.printMenuItemList();

        int index = inputNumber(menu.getMenuItemList().size());
        // 선택된 메뉴 출력
        if(index != -1) {
            menu.printSelectMenu(index);
        }
        selectMainMenu();
    }
}
