package kiosk.lv5;

import java.util.List;

public class Menu {
    private String titleName;
    private List<MenuItem> menuItemList;

    Menu(String titleName, List<MenuItem> menuItemList){
        this.titleName = titleName;
        this.menuItemList = menuItemList;
    }

    public void printMenuItemList(){
        System.out.printf("[ %s ]\n", titleName);
        int menuNumber = 1;
        for(MenuItem m : menuItemList){
            System.out.printf("%d. %s | ￦ %.1f | %s \n", menuNumber, m.getName(), m.getPrice(), m.getDescription());
            menuNumber++;
        }
        System.out.println("0. 뒤로가기");
    }

    public void printSelectMenu(int index){
        System.out.println("-----------------------------------------");
        System.out.printf("%s | ￦ %.1f | %s \n",
                menuItemList.get(index).getName(),
                menuItemList.get(index).getPrice(),
                menuItemList.get(index).getDescription());
        System.out.println("-----------------------------------------");
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
