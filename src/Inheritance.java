public class Inheritance {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.hashCode()); //2003749087
        System.out.println(o2.hashCode()); //1324119927
        System.out.println(o1.toString()); //java.lang.Object@776ec8df
        System.out.println(o1.equals(o2)); //false  ==와 같음
    }
}
