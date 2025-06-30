package chap03_method_return;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Return ret = new Return();

        ret.methodA(-1);
        ret.methodA(1);

        System.out.println("methodB's return: " + ret.methodB(1, 2));

        int[] numbers = ret.methodC(3);
        System.out.println("methodC's return: " + Arrays.toString(numbers));

        String carInfo = ret.methodD();
        System.out.println("methodD's return: " + carInfo);

    }
}
