package ch06.sec08.exam03;

/**
 * gas가 있습니다.
 * 출발합니다.
 * 달립니다.(gas잔량:5)
 * 달립니다.(gas잔량:4)
 * 달립니다.(gas잔량:3)
 * 달립니다.(gas잔량:2)
 * 달립니다.(gas잔량:1)
 * 멈춥니다.(gas잔량:0)
 */
public class CarExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.setGas(5);
        car.isLeftGas();
        car.run();
        car.isLeftGas();
    }
}
