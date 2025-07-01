package chap07_access_modifier;
import chap06_constructor.Brand;
import chap07_access_modifier.Car;


public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("X6", 12000);
        Car car3 = new Car("X123", 1200000, new Brand("KIA", "South Korea"));

        car1.printInfo();
        car2.printInfo();
        car3.printInfo();

        car3.setModel("Sorento");
        car3.setPrice(4000);
        car3.setBrand(new Brand("LG","North"));
        car3.printInfo();





    }
}
