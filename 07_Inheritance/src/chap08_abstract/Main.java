package chap08_abstract;

public class Main {
    public static void main(String[] args) {
        Animal animal;

        animal = new Lion(); animal.move();
        animal = new Shark(); animal.move();
        animal = new Eagle(); animal.move();

    }
}
