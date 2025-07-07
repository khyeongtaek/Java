package chap09_interface.a_overview;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Lion();
        lion.move();
        lion.eat();
        Animal.breath();
    }
}
