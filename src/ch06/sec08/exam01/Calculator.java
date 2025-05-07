package ch06.sec08.exam01;

public class Calculator {
    boolean power;
    public void powerOn() {
        power = true;
        System.out.println("전원을 켭니다");
    }
    public int plus(int num1, int num2){
            return num1 + num2;
    }

    /**
     * 
     * @param x 자료형변환
     * @param y
     * @return
     */
    public double divide(double x, double y) {
        return x/y;
    }
    public void powerOff(){
        power = false;
        System.out.println("전원을 끕니다");
    }
}
