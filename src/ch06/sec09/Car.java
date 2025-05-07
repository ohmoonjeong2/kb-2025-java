package ch06.sec09;

/**
 * 다음 조건을 만족하는 Car 클래스를 완성하세요.
 * model필드는 생성자로 초기화
 * speed 필드의 getter/setter메서드 정의
 * run()메서드 호출시 다음과 같이 출력
 *  xxx(model 값)가 달립니다.(시속: yyy(speed 값)km/h)
 */
public class Car {
    //필드 선언
    String model;
    int speed;
    public Car(String model) {
        this.model = model;
    }

    /**
     * 자동차의 속도를 설정한다
     * @param s
     */
    public void setSpeed(int s) {
        speed = s;
    }

    public int getSpeed() {
        return speed;
    }
}