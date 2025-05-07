public class Operator{
    public static void main(String []args){
        int a, b, c;
        //산술연산자 +, -, *, /, %
        a = 10;
        b = 3;
        c = a / b; //정수/정수결과는 정수
        System.out.println(c); //3
       // System.out.println(a/0); //컴파일성공, 실행 ArithmeticException발생
        
        byte b1, b2, b3;
        b1=10; b2=20;
        b3 = (byte)(b1+b2); //+연산시 b1이 byte에서 int로 자동형변환
                          //b2도 int로 자동형변환
                          //b3은 byte타입변수에 int30대입불가
        System.out.println(b3); //30

        //문자열결합연산자 +
        System.out.println( 1+2+"3"); //1+2,  3+"3",  "33"
        System.out.println( "1"+2+3); //"1"+"2"+"3"


        //대입연산자  =, +=, -=, *=, /=, %=
        //단항연산자 ++, --	
        a = 1;  
        b = a++;
       
        a = 1;
        b = ++a;

        b1 = 127;
        b1++;
        System.out.println(b1); //-128   

        b2 = 127;
        b2 = (byte)(b2+1); //byte타입인 b2가 +연산시 int로 형변환      
        System.out.println(b2); 

        //비교연산자 ==, !=, >, >=, <, <=
        System.out.println(a > b); //논리값
 
        //논리연산자 && , &, ||, |, !
       //   false &&인 경우 우측연산 안함 
       //   false &   인 경우 우측연산함
       //   true || 인 경우 우측연산 안함 
       //   true |  인 경우 우측연산함
       System.out.println(!true); //false


    }
}