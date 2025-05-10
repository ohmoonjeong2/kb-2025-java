package ch18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadLineExample {

    public static void main(String[] args) {

        URL url =  ReadLineExample.class.getResource("data.txt");
        URI uri = null;
        try {
            uri = url.toURI();
        }catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        int lineNo1 = 1;
        try{
            File file = new File(uri);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (true) {
                String str = br.readLine();
                if (str == null) break;
                System.out.println(lineNo1 + "\t" + str);
                lineNo1++;
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        int lineNo2 = 1; //지역변수
        int []lineNo3 = new int[]{1};
        Path path = Paths.get(uri);
        try(Stream<String> lines = Files.lines(path, Charset.defaultCharset())){

            lines.forEach(str -> {
//                System.out.println(lineNo2 + "\t" + str);
//                lineNo2++;  // 라인 번호 증가
                System.out.println(lineNo3[0] + "\t" + str);
                lineNo3[0]++;
            });
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
