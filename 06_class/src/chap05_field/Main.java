package chap05_field;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);

        Car car1 = new Car();
        Car car2 = new Car();

//        car1.model = "Sienna";
//        car1.price = 100000;
//
//        car2.model = "Santafe";
//        car2.price = 150000;

        car1.setInfo("Sienna", 100000);
        car2.setInfo("Santafe", 150000);

        System.out.println(car1);
        System.out.println(car2);


    }
}
