package org.scoula.travel.dataimport;
import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.dao.TravelDao;
import org.scoula.travel.dao.dao.TravelDaoImp;
import org.scoula.travel.domain.TravelVO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ImportTravelData {
    /**
     * 콤마를 갖는 문자열을 분리한다. 이때 큰따옴표("")로 구성된 문자열내부의 ,는 분리하지 않는다<br>
     * 예를 들어 다음문자열인 경우<br>
     *  1,수도권,인천 개항장역사문화공간,"1883년 인천 개항장, a,b", 주소1 <br>
     * 반환 배열값은<br>
     * [0]:1, [1]:수도권, [2]:인천 개항장역사문화공간, [3]:1883년 인천 개항장, a,b, [4]: 주소1<br>
     * 이 된다
     * @param line 한 줄 문자열
     * @param size 분리할 개수
     * @return 분리된 문자열 배열
     */
    public static String[] parseCSVLine(String line, int size) {
        ArrayList<String> fields = new ArrayList<>(size);

        StringBuilder field = new StringBuilder();
        boolean insideQuotes = false;
        int length = line.length();

        for (int i = 0; i < length; i++) {
            char c = line.charAt(i);

            // 큰따옴표 처리
            if (c == '"') {
                if (insideQuotes && i + 1 < length && line.charAt(i + 1) == '"') {
                    field.append('"'); // 이스케이프된 따옴표
                    i++; // skip next quote
                } else {
                    insideQuotes = !insideQuotes; // 따옴표 여닫기
                }
            }
            // 쉼표 처리 (단, 따옴표 안이 아닐 때)
            else if (c == ',' && !insideQuotes) {
                fields.add(field.toString());
                field.setLength(0); // StringBuilder 재사용
            } else {
                field.append(c);
            }
        }

        // 마지막 필드 추가
        fields.add(field.toString());
        return fields.toArray(new String[0]); //List<String>타입인 fields를 String배열로 만든다
    }

    /**
     * clazz타입의 객체를 생성하고<br>
     * arr의 문자열값을 배열순서대로 class클래스의 멤버변수에 차례대로 자료형변환해서 대입한 후<br>
     * 객체를 반환한다
     * @param arr 배열
     * @param clazz 클래스
     * @return 클래스타입의 객체
     * @param <T> 클래스타입
     * @throws Exception
     */
    public static <T> T getInstanceArrToMemberField(String []arr, Class<T> clazz) throws Exception {
        T vo = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = TravelVO.class.getDeclaredFields();
        for (int i = 0; i < arr.length && i < fields.length; i++) {
            Field field = fields[i];

            field.setAccessible(true);
            if (field.getType() == Long.class) {
                field.set(vo, Long.parseLong(arr[i]));
            } else if (field.getType() == String.class) {
                field.set(vo, arr[i]);
            }
        }
        return vo;
    }
    public static void main(String[] args) {
        String fileName = "/travel.csv";

        try(
                InputStream is = ImportTravelData.class.getResourceAsStream(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
        ) {
            String line;
            ArrayList<TravelVO> travels = new ArrayList<>();
            br.readLine();
            while((line = br.readLine()) != null){
                int size = 6;
                String[]arr = parseCSVLine(line, size);
                TravelVO vo = getInstanceArrToMemberField(arr, TravelVO.class);
                travels.add(vo);
            }
            TravelDao dao = new TravelDaoImp();
            travels.forEach(travel -> {
                System.out.println(travel);
                dao.insert(travel);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

/*
        TravelDao dao = new TravelDaoImpl();
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(
//                                   new FileReader("travel.csv"))
                                     new InputStreamReader( ImportTravelData.class.getResourceAsStream(fileName)))
                .withType(TravelVO.class)
                .build()
                .parse();

        travels.forEach(travel -> {
            System.out.println(travel);
            dao.insert(travel);
        });
*/
    }
}
