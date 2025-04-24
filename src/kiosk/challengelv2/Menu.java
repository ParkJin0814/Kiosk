package kiosk.challengelv2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    private String titleName;
    private List<MenuItem> menuItemList;

    Menu(String titleName, List<MenuItem> menuItemList){
        this.titleName = titleName;
        this.menuItemList = menuItemList;
    }

    public MenuItem selectMenu(int index){
        System.out.println("-----------------------------------------");
        System.out.printf("%s | ￦ %.1f | %s \n",
                menuItemList.get(index).getName(),
                menuItemList.get(index).getPrice(),
                menuItemList.get(index).getDescription());
        System.out.println("-----------------------------------------");
        return menuItemList.get(index);
    }

    public String getTitleName(){
        return titleName;
    }
    public void setTitleName(String titleName){
        this.titleName = titleName;
    }

    public List<MenuItem> getMenuItemList(){
        return menuItemList;
    }
    public void setMenuItemList(List<MenuItem> menuItemList){
        this.menuItemList = menuItemList;
    }
}
