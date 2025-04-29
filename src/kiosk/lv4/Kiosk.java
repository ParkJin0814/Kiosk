package kiosk.lv4;

import java.util.List;

public class Kiosk {
    List<Menu> menuList;

    Kiosk(List<Menu> menuList){
        this.menuList = menuList;
    }

    public void start(){
        selectMainMenu();
    }

    private void selectMainMenu(){
        printMainMenuList();

        int index = InputHandler.inputNumber(menuList.size());
        if(index != -1) {
            selectItem(menuList.get(index));
        }
    }

    private void selectItem(Menu menu){
        menu.printMenuItemList();

        int index = InputHandler.inputNumber(menu.getMenuItemList().size());
        // 선택된 메뉴 출력
        if(index != -1) {
            menu.printSelectMenu(index);
        }
        selectMainMenu();
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
}
