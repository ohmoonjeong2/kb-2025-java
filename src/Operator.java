public class Operator{
    public static void main(String []args){
        int a, b, c;
        //��������� +, -, *, /, %
        a = 10;
        b = 3;
        c = a / b; //����/��������� ����
        System.out.println(c); //3
       // System.out.println(a/0); //�����ϼ���, ���� ArithmeticException�߻�
        
        byte b1, b2, b3;
        b1=10; b2=20;
        b3 = (byte)(b1+b2); //+����� b1�� byte���� int�� �ڵ�����ȯ
                          //b2�� int�� �ڵ�����ȯ
                          //b3�� byteŸ�Ժ����� int30���ԺҰ�
        System.out.println(b3); //30

        //���ڿ����տ����� +
        System.out.println( 1+2+"3"); //1+2,  3+"3",  "33"
        System.out.println( "1"+2+3); //"1"+"2"+"3"


        //���Կ�����  =, +=, -=, *=, /=, %=
        //���׿����� ++, --	
        a = 1;  
        b = a++;
       
        a = 1;
        b = ++a;

        b1 = 127;
        b1++;
        System.out.println(b1); //-128   

        b2 = 127;
        b2 = (byte)(b2+1); //byteŸ���� b2�� +����� int�� ����ȯ      
        System.out.println(b2); 

        //�񱳿����� ==, !=, >, >=, <, <=
        System.out.println(a > b); //����
 
        //�������� && , &, ||, |, !
       //   false &&�� ��� �������� ���� 
       //   false &   �� ��� ����������
       //   true || �� ��� �������� ���� 
       //   true |  �� ��� ����������
       System.out.println(!true); //false


    }
}