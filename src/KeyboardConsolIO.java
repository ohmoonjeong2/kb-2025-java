import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyboardConsolIO {
    public static void main(String[] args) {
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            String line = br.readLine();
            System.out.println("한줄입력값: "+ line);
        }catch(IOException e){
            e.printStackTrace();
        }
//        InputStream is = System.in;
//        InputStreamReader isr = new InputStreamReader(is);
//        try {
//            int readValue = isr.read();
//            System.out.print("키보드 입력값:" + readValue +", 문자값:" + (char)readValue);
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        InputStream is = System.in;
//        try {
//            int readValue = is.read();
//            System.out.print("키보드 입력값:" + readValue +", 문자값:" + (char)readValue);
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }

    }
}
