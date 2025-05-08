package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "남", 92));
        totalList.add(new Student("김수영", "여", 87));
        totalList.add(new Student("감자바", "남", 95));
        totalList.add(new Student("오해영", "여", 93));

        System.out.println("성적으로 내림차순 정렬후 상위2명만 출력");
        totalList.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .limit(2)
                .forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));

        System.out.println("점수의 합 : reduce()");
        //reduce
//        int sumScore = totalList.stream()
//                .map(Student::getScore)
//                .reduce(0, (a,b)->a+b);
        int sumScore = totalList.stream()
                .map(Student::getScore)
                .reduce(0, Integer::sum);
        System.out.println(sumScore);

        System.out.println("남학생만 묶어 List생성");
        /*
        List<Student> maleList = totalList.stream()
        .filter(s->s.getSex().equals("남"))
        .collect(Collectors.toList());
        */
        List<Student> maleList = totalList.stream()
                .filter(s -> s.getSex().equals("남"))
                .toList(); //java16버전부터 제공되는 toList()
        maleList.forEach(s->System.out.println(s.getName()));

        System.out.println("맵으로 만들기(k는 학생이름, v는 점수)");
        Map<String, Integer> map =  totalList.stream()
                .collect(Collectors.toMap(s->s.getName(), s-> s.getScore()));
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("맵으로 만들기(k는 성별, v는 List<학생>)");
        Map<String, List<Student>> mapGroup = totalList.stream()
                .collect(Collectors.groupingBy(s->s.getSex()));
        mapGroup.forEach((k, v) -> System.out.println(k + ":" + v));


    }
}
