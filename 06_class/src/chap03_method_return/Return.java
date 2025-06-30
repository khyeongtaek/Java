package chap03_method_return;

public class Return {
    void methodA(int x) {
        if (x < 0) {
            return;
        }
        System.out.println("methodA: " + x);
    }

    int methodB(int x, int y) {
        return x + y;
    }

    int[] methodC(int size) {
        return new int[size];
    }

    String methodD() {
        Car car = new Car();
        return "\nmodel: "
                + car.getModel() + "\n"
                + "price: "
                + car.getPrice();
    }
}
