public class Loop{
    public static void main(String []args){
         //A~Z���� ����Ͻÿ�
        //char : 2byte
        //char�� int�� �ڵ�����ȯ ����
        //char c = 'A'; c=(char)(c+1); 
        //                  c++; 
        for(char c = 'A'; c <= 'Z'; c++){
           System.out.println(c);
        }

        int al=-1;
        while(al++<25){
            System.out.println((char)('A'+al));
        } 

        for (int i = 65; i <= 90; i++) {
            char c = (char) i;
            System.out.println(c);
        }

         //1,2,3,4,...������ ���� 100�� ���� �ʴ� ���� ū ���� ���Ͻÿ� : ���� ����13
/*
        int sum = 0;
        int count = 0;
        while (sum + (count + 1) <= 100) {
            count++;
            sum += count;
        }
        System.out.println(count);   
*/
       int sum = 0;
       int num = 0;
       while (true) {
          num++;
          sum += num;
          if (sum>100) {
             sum -=num;
             break;
          }
       }
       System.out.println(sum);
       System.out.println(num-1);


        java.util.Scanner sc = new java.util.Scanner(System.in);
        //�Ʒ� ����� 9���� �����Ͽ� ����Ǳ� ������ �ݺ��ǵ��� �մϴ�.
        String opt;
        do{
          System.out.println("�۾��� �����ϼ���[1-��ü��ȸ, 2-�߰�, 9-����]:");
          opt = sc.nextLine(); //"1" "2" "9"
          switch(opt){
          case "1":  System.out.println("��ü��ȸ�� �����߽��ϴ�");
                       break;
          case "2":  System.out.println("�߰��� �����߽��ϴ�");
                       break;
          case "9":  System.out.println("���Ḧ �����߽��ϴ�");
                       break;
          default :  System.out.println("��Ȯ�� �����ϼ���");
                       break;
          }
       }while( !opt.equals("9"));


       outer: for(int dan=2; dan<=5; dan++){
          inner: for(int i=1; i<=9; i++){
             System.out.print(dan*i + "\t"); 
             if( dan*i >30){
               break outer;
             }  
          }
          System.out.println(); 
       } 

  }

}