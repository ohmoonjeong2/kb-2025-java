package ch06.sec07.exam05;

/**
 * 앞에서 정의한 Car 클래스를 이용하여, 다음 출력이 나오도록 운영하세요.
 */
public class CarExample {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car("자가용");
        Car c3 = new Car("자가용", "빨강");
        Car c4 = new Car("택시", "검정", 200);
    }
}
