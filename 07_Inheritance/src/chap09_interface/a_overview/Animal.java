package chap09_interface.a_overview;

public interface Animal {
    void move();
    default void eat(){
        System.out.println("eating..");
    }

    static void breath(){
        System.out.println("breath..");
    }
}
