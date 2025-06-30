package chap02_method_parameter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Parameter parameter = new Parameter();
        parameter.methodC(new int[]{1, 2, 3});
        parameter.methodD();
        parameter.methodD(1);
        parameter.methodD(1, 2, 3);
        parameter.methodE(1, 23);

        int number = 0;
        int[] numbers = new int[3];
        parameter.methodF(number, numbers);
        System.out.println("기본 타입 number: " + number);
        System.out.println("참조 타입 numbers: " + Arrays.toString(numbers));


        // Case 1
        Car car = new Car();
        parameter.methodG(car, "서울");
        parameter.methodG(car, "인천");

        // Case 2
        parameter.methodG(new Car(), "서울");
        parameter.methodG(new Car(), "인천");

        // Case 3
        parameter.methodG(new Car(), "광주");
        


    }
}
