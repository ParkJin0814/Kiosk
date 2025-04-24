package kiosk.challengelv2;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuList;
    private final Scanner sc = new Scanner(System.in);
    private final Orders orders;

    Kiosk(List<Menu> menuList, Orders orders){
        this.menuList = menuList;
        this.orders = orders;
    }

    public void start(){
        selectMainMenu();
    }

    private void selectMainMenu(){
        printMainMenuList();

        boolean ordersIsEmpty = orders.getOrdersMenuList().isEmpty();
        int menuListLength = menuList.size();
        int inputLength = ordersIsEmpty? menuListLength : menuListLength+2;
        int index = inputNumber(inputLength, 0);
        if(index != -1) {
            if(index < menuListLength) {
                selectItem(menuList.get(index));
            } else {
                boolean cancel = inputLength -1 == index;
                selectOrders(cancel);
            }
        }
    }

    private void selectOrders(boolean cancel){
        if(cancel){
            orders.removeOrders();
            selectMainMenu();
        } else  {
            orders.printOrderList();
            int index = inputNumber(3, 1);
            switch (index){
                case 0:
                    selectDisCountType();
                    break;
                case 1:
                    selectMainMenu();
                    break;
                case 2:
                    inputRemoveOrderMenuItem();
                    selectOrders(false);
                    break;
            }
        }
    }

    private void selectItem(Menu menu){
        printMenuItemList(menu);

        int index = inputNumber(menu.getMenuItemList().size(), 0);
        // 선택된 메뉴 출력
        if(index != -1) {
            MenuItem selected = menu.selectMenu(index);
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n 1. 확인 \n 2. 취소");
            index = inputNumber(2, 1);
            if(index == 0) {
                orders.addOrder(selected);
            }
        }
        selectMainMenu();
    }

    private void selectDisCountType(){
        System.out.println("할인 정보를 입력해주세요.");
        int number = 1;

        for(DisCountType disCountType : DisCountType.values()){
            System.out.printf("%d. %s : %d%%\n", number++, disCountType.type, disCountType.disCountRate);
        }
        int index = inputNumber(DisCountType.values().length, 1);

        DisCountType disCountType = DisCountType.values()[index];

        float totalPrice = disCountType.calculate.apply(orders.getTotalPrice());
        System.out.printf("주문이 완료되었습니다. 금액은 %.1f 입니다 \n", totalPrice);
    }

    private void inputRemoveOrderMenuItem(){
        System.out.print("제거할 음식명을 입력해주세요(입력하는 단어와 겹치는 음식전부 제거) : ");
        String inputText = sc.nextLine();
        orders.removeOrderMenuItem(inputText);
    }

    private int inputNumber(int length, int startInt){
        while (true){
            try {
                System.out.println("-----------------------------------------");
                System.out.print("번호를 입력해주세요 : ");
                String inputText = sc.nextLine();
                int index = Integer.parseInt(inputText) -1;
                // 메뉴아이템으로 넘어가기
                if(index < startInt - 1 || index > length - 1){
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
            System.out.printf("%d. %s\n", menuNumber++, m.getTitleName());
        }
        System.out.println("0. 종료      | 종료");

        if(orders.getOrdersMenuList().isEmpty()){
            return;
        }

        System.out.println("\n[ Order MENU ]");
        System.out.printf("%d. %s\n", menuNumber++, "Orders    | 장바구니를 확인 후 주문합니다.");
        System.out.printf("%d. %s\n", menuNumber, "Cancel    | 진행중인 주문을 취소합니다.");
    }

    public void printMenuItemList(Menu menu){
        System.out.printf("[ %s ]\n", menu.getTitleName());
        menu.getMenuItemList()
                .stream()
                .forEach((m)-> System.out.printf("%d. %s | ￦ %.1f | %s \n", menu.getMenuItemList().indexOf(m) + 1, m.getName(), m.getPrice(), m.getDescription()));
        System.out.println("0. 뒤로가기");
    }
}
