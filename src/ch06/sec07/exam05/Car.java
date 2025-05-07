package ch06.sec07.exam05;

/**
 * Car 클래스가 다음과 같이 정의된 경우, 다른 생성자를 호출하여 필드를 초기화하도록 생성자를 수정
 * 하세요.
 */
public class Car {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;
    public Car() {}
    public Car(String model){
        this(model, null, 0);
    }
    public Car(String model, String color){
        this(model, color, 0);
    }
    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

}
