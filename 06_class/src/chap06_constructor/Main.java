package chap06_constructor;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car();
        car1.printInfo();

        Car car2 = new Car("Sienna");
        car2.printInfo();

        Car car3 = new Car(100000);
        car3.printInfo();

        Car car4 = new Car("Santafe", 150000, new Brand("KIA", "South Korea"));
        car4.printInfo();
    }
}
