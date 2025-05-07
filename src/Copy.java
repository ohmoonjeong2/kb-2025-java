class A implements Cloneable {
    int i;
    int[] arr ; //배열변수 선언 int []arr = {1,2,3};
    A(int i){
        this.i = i;
        arr = new int[]{1,2,3}; //배열초기화
    }
    A copy(){
        try {
            //return (A)this.clone(); //객체복제 shallow copy

            A copyA = (A)this.clone(); //deep copy
            int[] copyArr = (int[])this.arr.clone();
            copyA.arr = copyArr;
            return copyA;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
/**
 * 파일에 여러클래스를 작성할때
 * main메서드를 갖는 클래스만 public이어야한다
 * public class이름이 파일명이어야 한다
 */
public class Copy {
    public static void main(String[] args) {
        A a1 = new A(10); //인스턴스변수i값이 10으로 초기화
        A a2 = a1.copy();
        System.out.println(a1 == a2); //false
        System.out.println(a1.i == a2.i); //true
        System.out.println(a1.arr[0] == a2.arr[0]); //true
        System.out.println(a1.arr == a2.arr); //shallow copy : true
                                              //deep copy : false
        a2.i=20;
        System.out.println(a1.i); //10

        a2.arr[0] = 20;
        System.out.println(a1.arr[0]); //shallow copy : 20
                                       //deep copy : 1

    }
}
