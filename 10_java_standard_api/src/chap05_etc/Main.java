package chap05_etc;

import java.text.DecimalFormat;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        decimalFormat();
        optional();

    }

    private static void optional() {
        Optional<String> optional = Optional.of("Hello");
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }else {
            System.out.println(optional.orElse("World"));

        }
    }

    private static void decimalFormat() {
        DecimalFormat df = new DecimalFormat();

        df.applyPattern("0");
        System.out.println(df.format(1234.56));

        df.applyPattern("0.00");
        System.out.println(df.format(1234.56));

        df.applyPattern("#,##0");
        System.out.println(df.format(1234.56));

        df.applyPattern("#,##0.00");
        System.out.println(df.format(1234.56));

    }


}
