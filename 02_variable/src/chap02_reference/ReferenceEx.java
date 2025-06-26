package chap02_reference;

public class ReferenceEx {

    public static void main(String[] args) {
        String a = "Hello World";

        System.out.println(System.identityHashCode(a));
    }
}
