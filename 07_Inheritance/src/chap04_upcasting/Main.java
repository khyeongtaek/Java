package chap04_upcasting;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Dog chihuahua = new Chihuahua();
        chihuahua.bark();

        Dog husky = new Husky();
        husky.bark();

        Dog[] dogs = new Dog[20];

        dogs[0] = new Chihuahua();
        dogs[1] = new Husky();

        for (Dog dog : dogs) {
            dog.bark();
        }


    }

}
