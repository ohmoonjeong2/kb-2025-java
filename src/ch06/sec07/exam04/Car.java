package ch06.sec07.exam04;

/**
 * Car 클래스가 다음과 같이 정의되어 있다. 다음을 만족하는 생성자를 추가하세요
 * 매개변수 없는 생성자
 * 매개변수로 model만 가지는 생성자
 * 매개변수로 model과 color를 가지는 생성자
 * 매개변수로 model, color,maxSpeed를 가지는 생성자
 */
public class Car {
    //필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;
    public Car(){}
    public Car(String model){
        this.model = model;
    }
    public Car(String model, String color){
        this.model = model;
        this.color = color;
    }
    public Car(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}