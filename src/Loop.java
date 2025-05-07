public class Loop{
    public static void main(String []args){
         //A~Z까지 출력하시오
        //char : 2byte
        //char는 int로 자동형변환 가능
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

         //1,2,3,4,...숫자의 합이 100을 넘지 않는 가장 큰 수를 구하시오 : 답은 숫자13
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
        //아래 기능이 9번을 선택하여 종료되기 전까지 반복되도록 합니다.
        String opt;
        do{
          System.out.println("작업을 선택하세요[1-전체조회, 2-추가, 9-종료]:");
          opt = sc.nextLine(); //"1" "2" "9"
          switch(opt){
          case "1":  System.out.println("전체조회를 선택했습니다");
                       break;
          case "2":  System.out.println("추가를 선택했습니다");
                       break;
          case "9":  System.out.println("종료를 선택했습니다");
                       break;
          default :  System.out.println("정확히 선택하세요");
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