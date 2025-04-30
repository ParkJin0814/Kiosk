package kiosk.challengelv2;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    // 숫자입력받기 최대값 최소값 받아 범위내의 값만 출력
    public static int inputNumber(int maxIndex, int startIndex){
        while (true){
            try {
                System.out.println("-----------------------------------------");
                System.out.print("번호를 입력해주세요 : ");
                String inputText = sc.nextLine();
                int index = Integer.parseInt(inputText) -1;
                // 메뉴아이템으로 넘어가기
                if(index < startIndex - 1 || index > maxIndex - 1){
                    throw new Exception();
                }
                System.out.println("-----------------------------------------");
                return index;
            } catch (Exception e){
                System.out.println("제시된 숫자중에서 입력해주세요");
            }
        }
    }

    public static String inputString(){
        return sc.nextLine();
    }
}
