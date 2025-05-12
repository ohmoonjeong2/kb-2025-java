import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public TCPClient() {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String serverIP = "192.168.10.54"; //"127.0.0.1";
        int serverPort = 5432;
        Socket s = null;
        DataOutputStream dos = null;
        try {
            s = new Socket(serverIP, serverPort);
            dos = new DataOutputStream(s.getOutputStream());
            String sendValue;
            do {
                sendValue = br.readLine();
                dos.writeUTF(sendValue);
            }while(!"quit".equals(sendValue));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            if(s != null){
                try{
                    s.close();
                }catch(IOException e){}
            }
        }
    }
    public static void main(String[] args) {
        new TCPClient();
    }
}
