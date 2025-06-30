package chap02_method_parameter;

import java.util.Arrays;

public class Parameter {

    /**
     * @param items 정수형 배열을 전달 받음
     */
    void methodC(int[] items){
        System.out.println(Arrays.toString(items));
    }

    void methodD(int... items){
        System.out.println(Arrays.toString(items));
    }

    void methodE(int item, int ...items){
        System.out.println(item);
        System.out.println(Arrays.toString(items));
    }

    void methodF(int number, int[] numbers) {

        number = 10;
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;

    }

    void methodG(Car car, String region) {
        car.drive(region);
    }

}
