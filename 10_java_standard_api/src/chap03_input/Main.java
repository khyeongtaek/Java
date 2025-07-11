package chap03_input;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        while (true) {

            try {

                Scanner sc = new Scanner(System.in);

                System.out.println("이름을 입력하세요 >>> ");
                String name = sc.nextLine();
                System.out.println("입력된 이름은 " + name + "입니다.");

                System.out.println("나이를 입력하세요 >>> ");
                int age = sc.nextInt();
                System.out.println("입력된 나이는 " + age + "입니다.");

                System.out.println("키를 입력하세요 >>> ");
                double height = sc.nextDouble();
                System.out.println("입력된 키는 " + height + "입니다.");


                sc.close();
                break;

            } catch (Exception e) {
                System.out.println("올바른 타입의 정보를 입력해야 합니다.");
            }
        }


    }
}
