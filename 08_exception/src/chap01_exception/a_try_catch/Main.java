package chap01_exception.a_try_catch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void tryCatch() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("정수를 입력하세요: ");
            String input = sc.nextLine();
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("정수만 입력하세요.");
        }

    }

    public static void multiCatch() {

        try {
            String[] inputs = {"1", "20", "30", "40"};
            int total = 0;

            for (int i = 0; i <= inputs.length; i++) {
                total += Integer.parseInt(inputs[i]);
            }
            System.out.println("총합: " + total);

        } catch (NumberFormatException e) {
            System.out.println("정수값만 변환 후 누적할 수 있습니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 범위가 벗어났습니다.");
        }


    }

    private static void javaLangException() {
        int a = 10, b = 0;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        try {
            System.out.println(a / b);
        } catch (Exception e) {

            String exception = e.getClass().getName();
            String message = e.getMessage();
            System.out.println(exception + " : " + message);
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

//        tryCatch();
//        multiCatch();
        javaLangException();

    }


}
