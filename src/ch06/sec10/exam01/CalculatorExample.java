package ch06.sec10.exam01;

/**
 * Calculator 클래스가 다음과 같이 정의된 경우 CaculatorExample 코드를 완성하세요
 */
public class CalculatorExample {
    public static void main(String[] args) {
        double result1 = 10 * 10 * Calculator.pi; // 원의 넓이
        int result2 = Calculator.plus(10, 5); // 10, 5의 합
        int result3 = Calculator.minus(10, 5); // 10, 5의 차
        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
    }
}