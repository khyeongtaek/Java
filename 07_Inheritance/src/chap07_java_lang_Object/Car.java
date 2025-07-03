package chap07_java_lang_Object;

import java.util.Objects;

public class Car {
    private String carNo;
    private String carName;

    public Car(String carNo, String carName) {
        this.carNo = carNo;
        this.carName = carName;
    }

    public void carInfo(){
        System.out.println("차 번호 : " + this.carNo);
        System.out.println("차 모델 : " + this.carName);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carNo, car.carNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carNo);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNo='" + carNo + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}
