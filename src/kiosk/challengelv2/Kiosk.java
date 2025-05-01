package kiosk.challengelv2;


import java.util.Arrays;
import java.util.List;

public class Kiosk {
    private final List<Menu> menuList;
    private final Orders orders;

    Kiosk(List<Menu> menuList, Orders orders){
        this.menuList = menuList;
        this.orders = orders;
    }

    public void start(){
        handleMainMenuSelection();
    }

    private void handleMainMenuSelection(){
        printList("Main MENU", menuList);
        System.out.println("0. 종료");

        // 장바구니 목록이 비어있는지 확인
        boolean isOrderEmpty = orders.getOrdersMenuList().isEmpty();

        // 장비구니 목록이 있으면
        if(!isOrderEmpty){
            System.out.println("\n[ Order MENU ]");
            System.out.printf("%d. %s\n", menuList.size() + 1, "Orders    | 장바구니를 확인 후 주문합니다.");
            System.out.printf("%d. %s\n", menuList.size() + 2, "Cancel    | 진행중인 주문을 취소합니다.");
        }

        // 장바구니 목록이 없으면 장바구니 선택지는 주면 안된다
        int menuLength = isOrderEmpty ? menuList.size() : menuList.size() + 2;

        int selectedIndex = kiosk.challengelv1.InputHandler.inputNumber(menuLength, 0);

        if (selectedIndex <= 0) {
            // 키오스크 종료
            return;
        }

        if (selectedIndex < menuList.size()) {
            // 입력된 값이 메뉴리스트 범위내라면
            handleMenuSelection(menuList.get(selectedIndex-1));
        } else {
            // 그외에는 장바구니 관련 메서드 실행
            handleOrderSelection(selectedIndex == menuLength);
        }
    }

    private void handleOrderSelection(boolean cancel){
        if(cancel){
            orders.removeOrders();
            handleMainMenuSelection();
        } else  {
            printList("ORDER MENU", orders.getOrdersMenuList());
            System.out.println("[ Total ]");
            System.out.printf("￦ %.1f \n", orders.getTotalPrice());
            System.out.println("1. 주문  2. 메뉴판 3. 메뉴취소");
            // 1. 주문 2. 메뉴판
            int selection = InputHandler.inputNumber(3, 1);
            switch (selection){
                case 1:
                    handleDisCountTypeSelection();
                    break;
                case 2:
                    handleMainMenuSelection();
                    break;
                case 3:
                    inputRemoveOrderMenuItem();
                    handleOrderSelection(false);
                    break;
            }
        }
    }

    private void handleMenuSelection(Menu menu){
        printList(menu.toString(), menu.getMenuItemList());
        System.out.println("0. 뒤로가기");

        int selectedIndex = InputHandler.inputNumber(menu.getMenuItemList().size(), 0);
        // 선택된 메뉴 출력
        if(selectedIndex != 0) {
            MenuItem selected = menu.selectMenu(selectedIndex - 1);
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까? \n 1. 확인 \n 2. 취소");
            selectedIndex = InputHandler.inputNumber(2, 1);
            if(selectedIndex == 1) {
                orders.addOrder(selected);
            }
        }
        // 메뉴처리후 다시 메인메뉴
        handleMainMenuSelection();
    }

    // 할인 정보입력
    private void handleDisCountTypeSelection(){
        System.out.println("할인 정보를 입력해주세요.");

        printList("할인 정보를 입력해주세요", Arrays.stream(DisCountType.values()).toList());

        int index = InputHandler.inputNumber(DisCountType.values().length, 1);

        DisCountType disCountType = DisCountType.values()[index - 1];

        float totalPrice = disCountType.calculate.apply(orders.getTotalPrice());
        System.out.printf("주문이 완료되었습니다. 금액은 %.1f 입니다 \n", totalPrice);
    }

    private void inputRemoveOrderMenuItem(){
        System.out.print("제거할 음식명을 입력해주세요(입력하는 단어와 겹치는 음식전부 제거) : ");
        String inputText = InputHandler.inputString();
        orders.removeOrderMenuItem(inputText);
    }

    // 리스트 출력
    private <T> void printList(String printTitle, List<T> list){
        System.out.printf("[ %s ]\n", printTitle);
        int menuNumber = 1;
        for(T m : list){
            System.out.printf("%d. %s \n", menuNumber++, m);
        }
    }
}
