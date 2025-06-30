package chap04_method_overloading;


import java.util.Arrays;

public class View {

    void print(int x) {
        System.out.println("View x: " + x);
    }

    void print(double x) {
        System.out.println("View x: " + x);
    }

    void print(String[] items) {
        if (items == null) {
            return;
        }
        System.out.println("View items: " + Arrays.toString(items));
    }

    void print(Car car) {
        if (car == null) {
            return;
        }
        System.out.println("View car: " + car.getModel());

    }

}
