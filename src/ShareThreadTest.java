class T1 extends Thread {
    Share s;
    T1(Share s) {
        this.s = s;
    }
    public void run() {
        for(int i=0; i<10; i++) {
            s.plus();
        }
    }
}
class T2 extends Thread {
    Share s;
    T2(Share s) {
        this.s = s;
    }
    public void run() {
        for(int i=0; i<10; i++) {
            s.minus();
        }
    }
}
class Share{
    int money;
//    synchronized void plus(){
    void plus(){
        for(int i=0; i<100; i++){
            synchronized (this) {
                notify();
                System.out.print("before plus money: " + money);
                money++;
                System.out.println("after plus money: " + money);
            }
        }
    }
    void minus(){
        for(int i=0; i<100; i++){
            synchronized (this) {
                if(money == 0){
                    try {
                        wait(); //Causes the current thread to wait until it is awakened, typically by being notified or interrupted.
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("before minus money: " + money);
                money--;
                System.out.println("after minus money: " + money);
            }
        }
    }
}
public class ShareThreadTest {
    public static void main(String[] args) {
        Share s = new Share();
        T1 t1 = new T1(s);
        T2 t2 = new T2(s);
        t1.start();
        t2.start();
    }
}
