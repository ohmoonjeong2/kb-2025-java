public class DataType{
    public static void main(String[]args){
        //정수형 크기
        byte b; //1byte
        short s; //2byte
        int i;     //4byte
        long lo; //8byte
        lo = 1234567890123456789L;

        //실수형 크기
        float f;     //4byte
        //f = 12.3; //double타입의 12.3리터럴은 float변수메모리에 대입불가	
        f = 12.3F;

        double d; //8byte

        //단일문자형 크기
        char c;  //2byte
        c = 'A';
  
        //논리형 : true, false만 대입가능 
        boolean bo; //1byte
        //bo = 1; 컴파일 오류
       
        //자료형변환
        //자동형변환 : 작은자료형 -> 큰자료형 
        //강제형변환 : 큰자료형  ->  작은자료형
        b=1;
        i = b; //자동형변환
        f = i; //자동형변환 
        System.out.println(i); //1
        System.out.println(f); //1.0

        //b = f; //컴파일 오류
        b = (byte)f; //강제형변환
        System.out.println(b); //1


    }
}