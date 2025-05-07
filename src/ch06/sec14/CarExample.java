package ch06.sec14;

/**
 * 다음 주석처럼 운영해서, 아래와 같이 출력되도록 코드를 작성하세요.
 * 현재 속도: 0
 * 현재 속도: 60
 * 현재 속도: 0
 */
public class CarExample {
    public static void main(String[] args) {
//객체 생성
        Car myCar = new Car();
//잘못된 속도(-50)로 변경
        myCar.setSpeed(-50);
        // 현재 속도 출력
        System.out.println(myCar.getSpeed());
//올바른 속도로 변경
        myCar.setSpeed(40);
        // 현재 속도 출력
        System.out.println(myCar.getSpeed());
//멈춤
        myCar.setStop(true);
// 현재 속도 출력
        System.out.println(myCar.getSpeed());
    }
}