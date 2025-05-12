import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread {
    Socket s;
    DataInputStream dis = null;
    String clientIP;
    ServerThread(Socket s) throws IOException {
        this.s = s;
        dis = new DataInputStream(s.getInputStream());
        clientIP = s.getInetAddress().getHostAddress();
        System.out.println(clientIP +"님이 들어왔어요");
    }

    public void run() {
        String readValue;
        try {
            while (true) {
                if (!"quit".equals(readValue = dis.readUTF())) {
                    System.out.println(clientIP + "가 보내준 데이터 : " + readValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            System.out.println(clientIP + "님이 나갔어요");
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

public class TCPServerThread {
    private int port = 5432;//0~65535

    public TCPServerThread() {
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(port);
            while (true) {
                try {
                    System.out.println("클라이언트의 접속 기다리기");
                    s = ss.accept();
                    new ServerThread(s).start();
//                    DataInputStream dis = null;
//                    dis = new DataInputStream(s.getInputStream());
//                    String readValue;
//                    while (!"quit".equals(readValue = dis.readUTF())) {
//                        System.out.println("클라이언트가 보내준 데이터 : " + readValue);
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                finally{
//                    if(s!=null){
//                        try {
//                            s.close();
//                        }catch(IOException e){}
//                    }
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPServerThread();
    }
}
