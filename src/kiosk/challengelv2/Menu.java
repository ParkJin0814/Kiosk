package kiosk.challengelv2;

import java.util.List;

public class Menu {
    private final String titleName;
    private final List<MenuItem> menuItemList;

    Menu(String titleName, List<MenuItem> menuItemList){
        this.titleName = titleName;
        this.menuItemList = menuItemList;
    }

    // 선택된 메뉴 인덱스 받아 정보 출력
    public MenuItem selectMenu(int index){
        System.out.println("-----------------------------------------");
        System.out.printf("%s | ￦ %.1f | %s \n",
                menuItemList.get(index).getName(),
                menuItemList.get(index).getPrice(),
                menuItemList.get(index).getDescription());
        System.out.println("-----------------------------------------");
        return menuItemList.get(index);
    }

    public List<MenuItem> getMenuItemList(){
        return menuItemList;
    }

    @Override
    public String toString() {
        return titleName;
    }
}
