class S{
    static private S s = new S();
    private S(){}
    static S getInstance(){
//        return new S();
        return s;
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        //S s1 = new S();
        S s1 = S.getInstance();
        S s2 = S.getInstance();
        System.out.println(s1 == s2); //true
    }
}
