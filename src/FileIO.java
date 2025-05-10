import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;
class Test implements Serializable{
   private int i;
   transient  private String s; //객체직렬화에서 제외
   static private String ss;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public static String getSs() {
        return ss;
    }

    public static void setSs(String ss) {
        Test.ss = ss;
    }
}
public class FileIO {

    static public void test() {
        String fileName1 = "c:\\a.txt"; //"c:/a.txt"  "./a.txt"

        try (FileWriter fw = new FileWriter(fileName1, true)) {
            fw.write("Hello World"); //파일에 쓰기 : 출력
            fw.write("\n");
            fw.write("Goodbye World");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //FileIO.class가 존재하는 경로에서 a.txt를 찾아 URL객체형태로 생성
//        url = FileIO.class.getClassLoader().getResource(fileName1);
        File file = new File(fileName1);
        URI uri = file.toURI();
        Path path = Paths.get(uri);
        int lineNo = 1; //final int lineNo=1;과 같음
        int []lineNos = {1};
        try (Stream<String> stream = Files.lines(path)) {
           // stream.forEach(System.out::println);
            stream.forEach(line ->{
                //System.out.println(lineNo + ": " + line);
                //lineNo++;
                System.out.println(lineNos[0] + ": " + line);
                lineNos[0]++;
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void testDataTypeIO(){
        String fileName2 = "c:\\b.dat";
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName2))){
            dos.writeInt(10);//4
            dos.writeBoolean(true); //1
            dos.writeFloat(12.3F); //4
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName2))){
            int i = dis.readInt();
            boolean bool = dis.readBoolean();
            float f = dis.readFloat();
            System.out.println(i + " : " + bool + " : " + f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void testObjectIO(){
        Test test = new Test();
        test.setI(10); test.setS("Hello World"); test.setSs("STATIC");

        String fileName3 = "c:\\c.ser";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName3))){
            java.util.Date dt = new java.util.Date();
            System.out.println(sdf.format(dt));
            oos.writeObject(dt);
            oos.writeObject(test);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("5초 후");
        //5초 후
        long millis = 5*1000; //5초
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName3))){
            java.util.Date dt =  (java.util.Date)ois.readObject();
            System.out.println(sdf.format(dt));
            Test t = (Test)ois.readObject();
            System.out.println(t.getI() + " : " + t.getS() + " : " + t.getSs());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        test();
        testDataTypeIO();
        testObjectIO();
    }
}
