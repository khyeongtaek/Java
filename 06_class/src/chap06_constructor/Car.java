package chap06_constructor;

public class Car {
    String model;
    int price;
    Brand brand;

    Car() {
        System.out.println("Car 생성자 호출");
    }

    Car(String model) {
        this.model = model;
    }

    Car(int price) {
        this.price = price;
    }

    Car(String model, int price) {
        this(model);
        this.price = price;
    }

    Car(String model, int price, Brand brand) {
        this(model, price);
        this.brand = brand;
    }


    void printInfo() {
        if (brand != null) {
            brand.printInfo();
        }

        System.out.println(model + ", " + price);
    }

}
