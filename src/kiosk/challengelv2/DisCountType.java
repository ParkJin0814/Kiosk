package kiosk.challengelv2;

public enum DisCountType {
    NationalMerit("국가유공자", 10, (p) -> p*0.9f),
    Soldier("군인", 5, (p) -> p*0.95f),
    Student("학생", 3, (p) -> p*0.97f),
    Normal("일반", 0, (p) -> p)
    ;

    DisCountType(String type, int disCountRate, Calculate calculate){
        this.type = type;
        this.disCountRate = disCountRate;
        this.calculate = calculate;
    }
    final String type;
    final int disCountRate;
    final Calculate calculate;

    public static DisCountType ofCustomerType(int index){
        switch (index){
            case 1:
                return NationalMerit;
            case 2:
                return Soldier;
            case 3:
                return Student;
            case 4:
                return Normal;
        }
        return null;
    }

    @FunctionalInterface
    interface Calculate{
        float apply(float totalPrice);
    }
}
