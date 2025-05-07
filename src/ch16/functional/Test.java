package ch16.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
class Student {
    private String name;
    private String sex;
    private int score;
    public Student(String name, String sex, int score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }
    public String getSex() { return sex; }
    public int getScore() { return score; }
}
public class Test {
    public static void main(String[] args) {
        //1. Consumer
        Consumer<String> consumer = t -> System.out.println(t + "17");
        consumer.accept("java");

        //2. supplier
        IntSupplier intSupplier = () -> {
            int num = (int) (Math.random() * 6) + 1;
            return num;
        };
        int num = intSupplier.getAsInt();
        System.out.println("눈의 수: " + num);

        //3. Predicate
        double maleAvg = predicateAvg( t -> t.getSex().equals("남자") );
        System.out.println("남자 평균 점수: " + maleAvg);
        double femaleAvg = predicateAvg( t -> t.getSex().equals("여자") );
        System.out.println("여자 평균 점수: " + femaleAvg);

        //4.

    }
    static List<Student> list = Arrays.asList(
            new Student("홍길동", "남자", 90),
            new Student("김순희", "여자", 90),
            new Student("감자바", "남자", 95),
            new Student("박한나", "여자", 92)
    );
    static double predicateAvg(Predicate<Student> predicate) {
        int count = 0, sum = 0;
        for(Student student : list) {
            if(predicate.test(student)) {
                count++;
                sum += student.getScore();
            }
        }
        return (double) sum / count;
    }

//    private static List<Student> listFunction = Arrays.asList(
//            new Student("홍길동", 90, 96),
//            new Student("신용권", 95, 93)
//    );
     void functionPrint(Function<Student, String> function) {
        for(Student student : list) {
            System.out.print(function.apply(student) + " ");
        }
        System.out.println();
    }
}