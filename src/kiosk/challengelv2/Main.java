package kiosk.challengelv2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 장바구니 인스턴스화
        Orders orders = new Orders();
        // 키오스크 인스턴스화
        Kiosk kiosk = new Kiosk(createMainMenu(), orders);

        // 키오스크 시작메서드
        kiosk.start();
        System.out.println("프로그램 종료");
    }

    // 카테고리 메뉴 리스트 추가
    public static List<Menu> createMainMenu(){
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Burgers", createBurgerList()));
        menuList.add(new Menu("Drinks", createDrinkList()));
        menuList.add(new Menu("Desserts", createDessertsList()));
        return menuList;
    }

    // 버거메뉴추가
    public static List<MenuItem> createBurgerList(){
        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));
        return menuItemList;
    }

    // 드링크 메뉴추가
    public static List<MenuItem> createDrinkList(){
        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("콜라", 2.5f, "시원하고 탄산 가득한 음료"));
        menuItemList.add(new MenuItem("레몬에이드", 3.0f, "새콤달콤한 레몬음료"));
        menuItemList.add(new MenuItem("아이스티", 2.7f, "향긋한 아이스 음료"));
        menuItemList.add(new MenuItem("미네랄워터", 1.5f, "깨끗하고 상쾌한 물"));
        return menuItemList;
    }

    // 디저트메뉴추가
    public static List<MenuItem> createDessertsList(){
        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(new MenuItem("초콜릿 케이크", 4.5f, "달콤한 초콜릿으로 만든 케이크"));
        menuItemList.add(new MenuItem("바닐라 아이스크림", 3.9f, "부드럽고 풍미 가득한 아이스크림"));
        menuItemList.add(new MenuItem("딸기 타르트", 5.0f, "신선한 딸기와 바삭한 크러스트의 조화"));
        menuItemList.add(new MenuItem("치즈케이크", 4.8f, "부드럽고 고소한 치즈 디저트"));
        return menuItemList;
    }
}