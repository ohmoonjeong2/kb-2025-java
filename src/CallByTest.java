/**
 * CallByValue : 메서드매개변수에 인자값이 복붙된다
 * @author 오문정
 * @version 1.0
 */
public class CallByTest {
    int i;
    public CallByTest(int i) {
        this.i = i;
    }
    /**
     * 매개변수 i는 기본자료형으로 값을 직접갖는다
     * @param i 
     */
    void m(int i){
        i=99;
    }

    /**
     * 매개변수 arr은 배열로 참조형이다. 참조형은 heap메모리 참조값을 갖는다
     * @param arr
     */
    void m(int[] arr){
        arr[0] = 99;
    }
    public static void main(String[] args) {
        int i = 7;
        CallByTest test = new CallByTest(1);
        test.m(i);
        System.out.println(i);//7
        int[] arr= {7,8,9};
        test.m(arr);
        System.out.println(arr[0]);
    }
}
