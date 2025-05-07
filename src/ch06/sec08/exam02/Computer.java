package ch06.sec08.exam02;

public class Computer {

    public int sum(int ...value){
        int sum = 0;
        for(int v: value){
            sum+=v;
        }
        return sum;
    }
}
