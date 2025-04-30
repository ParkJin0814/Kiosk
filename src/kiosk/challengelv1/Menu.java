package kiosk.challengelv1;

import java.util.List;

public class Menu {
    private final String titleName;
    private final List<MenuItem> menuItemList;

    Menu(String titleName, List<MenuItem> menuItemList){
        this.titleName = titleName;
        this.menuItemList = menuItemList;
    }

    // 선택된 메뉴
    public MenuItem selectedMenuItem(int index){
        System.out.println("-----------------------------------------");
        System.out.println(menuItemList.get(index));
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
