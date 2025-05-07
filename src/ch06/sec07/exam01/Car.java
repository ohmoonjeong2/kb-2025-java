package ch06.sec07.exam01;

/**
 * 다음과 같이 클래스가 주어졌을 때, Car 클래스의 멤버 변수와 생성자를 정의하세요.
 */
public class Car {
    String model;
    String color;
    int maxSpeed;
    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
