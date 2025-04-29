package kiosk.lv4;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);
    public static int inputNumber(int length){
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
}
