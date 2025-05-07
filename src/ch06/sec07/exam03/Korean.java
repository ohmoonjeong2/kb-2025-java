package ch06.sec07.exam03;

/**
 * Korean 클래스를 다음과 같이 정의했을 때, 생성자에서 name, ssn 필드를 초기화하세요
 */
public class Korean {
    // 필드 선언
    String nation = "대한민국";
    String name;
    String ssn;
    // 생성자 선언
    public Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

}
