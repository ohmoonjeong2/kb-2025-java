package ch06.sec08.exam02;

/**
 * 다음 결과가 나오도록 Computer 클래스를 작성하세요
 * .result1: 6
 * result2: 15
 * result3: 15
 * result4: 15
 */
public class ComputerExample
{
    public static void main(String[] args) {
        Computer myCom = new Computer(); //Computer 객체 생성
        int result1 = myCom.sum(1, 2, 3);
        System.out.println("result1: " + result1);
        int result2 = myCom.sum(1, 2, 3, 4, 5);
        System.out.println("result2: " + result2);
        int[] values = { 1, 2, 3, 4, 5 };
        int result3 = myCom.sum(values);
        System.out.println("result3: " + result3);
        int result4 = myCom.sum(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("result4: " + result4);
    }
}
