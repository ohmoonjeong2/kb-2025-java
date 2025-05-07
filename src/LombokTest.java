import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
class LombokVO{
    private String id;
    private int age;
}
public class LombokTest {
    public static void main(String[] args) {
        LombokVO vo = new LombokVO();

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println(df.format(now));
    }
}
