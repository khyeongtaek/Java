package chap06_polymorphism;

public class Person {

    public void feedFood(String food, Dog dog) {
        System.out.println(dog.getName() + "에게 " + food + " 줍니다.");

    }
}
