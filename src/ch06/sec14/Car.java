package ch06.sec14;

/**
 * 다음 Car 클래스의 필드에 대한 Getter, Setter를 정의하세요
 * speed설정 시 매개변수의 값이 0이하의 값이면 0으로 설정
 * stop설정시 매개변수 값이 true이면 speed의 값을 0으로 설정
 */

public class Car {
    //필드 선언
    private int speed;
    private boolean stop;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        if (stop) {
            speed = 0;
        }
        this.stop = stop;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
        }
        this.speed = speed;
    }
}