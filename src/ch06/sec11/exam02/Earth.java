package ch06.sec11.exam02;

/**
 * Earth 클래스에 다음과 같은 상수를 정의하세요
 * 지구 반지름 값 상수 : 초기값은 64000으로 초기화
 * 지구의 표면적 상수 : 정적블록에서 계산을 통해서 초기화 
 * 표면적 계산식 : 4*PI *반지름 *반지름
 */
public class Earth {
    static final int RADIUS = 64000;//반지름
    static final double SUPERFICIAL; //표면적
    static{
        SUPERFICIAL = 4*Math.PI *RADIUS *RADIUS;
    }
}
