package chap01_exception.e_throw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("정수 0~100를 입력하세요.");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

        int score = Integer.parseInt(input);



    }
}
