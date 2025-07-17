package chap02_function_interface.c_supplier;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> s1 = () -> "Java";
        System.out.println(s1.get());

        IntSupplier s2 = () -> (int) (Math.random() * 100);
        System.out.println(s2.getAsInt());

        double[] numbers = {1.1, 2.2, 3.3, 4.4, 5.5};
        DoubleSupplier s3 = () -> {
            double result = 0;
            for (double n : numbers) {
                result += n;
            }
            return result;
        };
        System.out.println(s3.getAsDouble());
    }
}
