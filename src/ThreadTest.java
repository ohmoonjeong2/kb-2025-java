import java.text.SimpleDateFormat;

class One{
    public void run(){
        System.out.println("run(): 현재사용중인 스레드:" + Thread.currentThread().getName());
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
    }
}
class FirstThread extends Thread{
    @Override
    public void run(){
        System.out.println("run(): 현재사용중인 스레드:" + Thread.currentThread().getName());
        for(int i=0; i<1000; i++){
            System.out.println(i + "현재사용중인 스레드:" + Thread.currentThread().getName());
        }
    }
}
//class SecondThread extends Parent, Thread{} 다중상속안됨
class SecondThread implements Runnable{
    private SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
    @Override
    public void run() //throws InterruptedException
    {
        for(int i=0;i<10; i++){
            System.out.println(sdf.format(new java.util.Date()));
            long mills = 1000;
            try {
                Thread.sleep(mills);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class ThirdThread implements Runnable{
    int num1, num2;
    int sum;
    ThirdThread(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        for(int i=num1; i<=num2; i++){
            sum += i;
        }
    }
}
/**
 * java ThreadTest 클래스 실행시 메인스레드가 자동 만들어지고
 * 메인스레드에서 main()메서드가 호출됨
 */
public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("현재사용중인 스레드:" + Thread.currentThread().getName()); //main
        ThirdThread th1 = new ThirdThread(1, 100);
        ThirdThread th2 = new ThirdThread(1, 100);
        //new Thread(th1).start();
        Thread t3 = new Thread(th1);
        t3.start();
        try {
            t3.join();//main스레드가 t3스레드 종료까지 기다린다
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        new Thread(th2).start();
        System.out.println("th1.sum: " + th1.sum); //5050
        System.out.println("th2.sum: " + th2.sum);


//        One one = new One();
//        one.run();
        FirstThread ft1 = new FirstThread();
        FirstThread ft2 = new FirstThread();
        ft1.start();
        ft2.start();

        SecondThread st = new SecondThread();
        //st.start();
        Thread th = new Thread(st);
        th.start();
    }
}
