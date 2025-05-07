import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
이벤트프로그램처리 순서
 1. 이벤트종류와        이벤트 소스 결정하기
    MouseMotionEvent  frame
    MouseEvent        frame
    ActionEvent       btStart
 2. 이벤트 핸들러를 작성
 3. 이벤트소스에 핸들러를 등록
 */


/**
 * 어덥터 패턴 : 인터페이스를 사용자가 원하는 방식으로 변환
 */
class Handler extends MouseAdapter {
    protected Handler() {
        super();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
    }
}
//class Handler2 implements MouseListener {
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("mouseClicked x="+e.getX()+" y="+e.getY());
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}
//class Handler1 implements MouseMotionListener{
//    @Override
//    public void mouseDragged(MouseEvent e) {
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        System.out.println("mouseMoved: x=" + e.getX() + ", y=" + e.getY());
//    }
//}

class Horse extends Canvas implements Runnable {
    private String name; //말이름
    private int x, y;
    Horse(String name) {
        this.name = name;
        this.x = 10;
        this.y = 10;
    }

    @Override
    public void run() {
        int maxStep = 20;
        for(int i=0; i<maxStep; i++) {
            int stride = 10; //보폭
            setX(getX() + stride);
            long millis = (long)(Math.random() * 500); //0<= r < 500
            try {
                Thread.sleep(millis);
            }catch(InterruptedException ie) {}
            //horse의 update()호출 -> graphic clear -> paint()호출
            repaint();
       }
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(name, x, y);
    }

//    @Override
//    public void update(Graphics g) {
//        g.drawString(name, x, y);
//    }
}
public class HorseRace {
    private JFrame frame;
    private JTextField tf;
    private JButton btStart;
    private JButton btReady;
    private Horse[] horses;
    class MyActionHandler implements ActionListener {
        //        private JTextField tf;
//        MyActionHandler(JTextField tf) {
//            this.tf = tf;
//        }
        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("클릭되었습니다");
            tf.setText("시작버튼이 클릭되었습니다");
//            int maxStep=20;
            for(Horse horse: horses){
//                for(int i=0; i<maxStep; i++) {
//                    horse.setX(horse.getX() + 10);
//                    //horse의 update()호출 -> graphic clear -> paint()호출
//                    horse.repaint();
//                }

//                horse.start();
                new Thread(horse).start();
            }
        }
    }
    public HorseRace(){
        horses = new Horse[3];
        for(int i = 0; i < 3; i++) {
            horses[i] = new Horse("말 " + (i + 1));
        }
        tf = new JTextField();
        btStart = new JButton("Start");
        btReady = new JButton("Ready");

        frame = new JFrame(); //액자
        Container c = frame.getContentPane(); //액자 종이판
        c.setLayout(new GridLayout(3+horses.length, 1));
        c.add(tf);
        for (Horse horse : horses) {
            c.add(horse); //horse의 paint()자동호출됨
        }
        c.add(btStart);
        c.add(btReady);
        frame.setTitle("Horse Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        MyActionHandler ah = new MyActionHandler(tf);
        MyActionHandler ah = new MyActionHandler();
        btStart.addActionListener(ah);

//        btReady.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                for(Horse horse : horses) {
//                    horse.setX(10);
//                    horse.repaint();
//                }
//            }
//        });
        btReady.addActionListener((e)->{
            for(Horse horse : horses) {
                    horse.setX(10);
                    horse.repaint();
                }
        });


//        Handler1 h1 = new Handler1();
//        frame.addMouseMotionListener(h1);
//
//        Handler2 h2 = new Handler2();
//        frame.addMouseListener(h2);
        Handler h = new Handler();
        frame.addMouseListener(h);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public static void main(String[] args) {

        new HorseRace();
    }
}
