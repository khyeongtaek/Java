package chap05_field;

public class Car {
    String model;
    int price;

    void setInfo(String model, int price) {
        this.model = model;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

}
