public class DataType{
    public static void main(String[]args){
        //������ ũ��
        byte b; //1byte
        short s; //2byte
        int i;     //4byte
        long lo; //8byte
        lo = 1234567890123456789L;

        //�Ǽ��� ũ��
        float f;     //4byte
        //f = 12.3; //doubleŸ���� 12.3���ͷ��� float�����޸𸮿� ���ԺҰ�	
        f = 12.3F;

        double d; //8byte

        //���Ϲ����� ũ��
        char c;  //2byte
        c = 'A';
  
        //���� : true, false�� ���԰��� 
        boolean bo; //1byte
        //bo = 1; ������ ����
       
        //�ڷ�����ȯ
        //�ڵ�����ȯ : �����ڷ��� -> ū�ڷ��� 
        //��������ȯ : ū�ڷ���  ->  �����ڷ���
        b=1;
        i = b; //�ڵ�����ȯ
        f = i; //�ڵ�����ȯ 
        System.out.println(i); //1
        System.out.println(f); //1.0

        //b = f; //������ ����
        b = (byte)f; //��������ȯ
        System.out.println(b); //1


    }
}