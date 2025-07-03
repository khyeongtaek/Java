package chap05_downcasting;

public class Main {
    public static void main(String[] args) {
        Dog chihuahua = new Chihuahua();
        chihuahua.bark();
        ((Chihuahua)chihuahua).getAngry();

        Dog husky = new Husky();
        husky.bark();
        if (husky instanceof Husky) {
            ((Husky) husky).pullSnowSled();
        }

    }

}
