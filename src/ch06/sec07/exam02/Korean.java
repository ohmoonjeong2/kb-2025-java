package ch06.sec07.exam02;

/**
 * 다음 Korean 클래스에 생성자의 매개변수로 name, ssn 필드를 초기화하는 생성자를 정의하세요.
 */
public class Korean {
    //필드 선언
    String nation = "대한민국";
    String name;
    String ssn;

    //생성자 선언
    public Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

}
