package kiosk.challengelv2;

// 할인타입
public enum DisCountType {
    NationalMerit("국가유공자", 10, (p) -> p*0.9f),
    Soldier("군인", 5, (p) -> p*0.95f),
    Student("학생", 3, (p) -> p*0.97f),
    Normal("일반", 0, (p) -> p)
    ;

    // 생성자
    DisCountType(String type, int disCountRate, Calculate calculate){
        this.type = type;
        this.disCountRate = disCountRate;
        this.calculate = calculate;
    }
    final String type;
    final int disCountRate;
    final Calculate calculate;

    @FunctionalInterface
    interface Calculate{
        float apply(float totalPrice);
    }
}
