package chap04_random;

import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static void mathRandom() {
        System.out.println(Math.random());
        System.out.println(Math.random() * 10);

        int randomNumber = (int) (Math.random() * 45) + 1;
        int cnt = 1;
        while (randomNumber != 45) {
            cnt++;
            randomNumber = (int) (Math.random() * 45) + 1;
        }
        System.out.println(cnt + " 회 만에 " + randomNumber + "가 나왔습니다.");


        Set<Integer> randomNumbers = new HashSet<>();
        int max = 1000;
        while (randomNumbers.size() < max) {
            randomNumber = (int) (Math.random() * max) + 1;
            if (!randomNumbers.add(randomNumber))
                System.out.println("랜덤 값이 중복되어 재시도...  중복된 값: "+randomNumber);
        }

        for (int i = 0; i < 1000; i++) {
            if (i % 50 == 0) {
                System.out.println();
            }
            System.out.print(randomNumbers.toArray()[i] + " ");
        }
        System.out.println();

        for (int tmp : randomNumbers) {
            System.out.print(tmp + " ");
        }


    }

    public static void secureRandom() {
        SecureRandom secureRandom = new SecureRandom();

        byte[] randomBytes = new byte[16];
        secureRandom.nextBytes(randomBytes);

        secureRandom.setSeed(randomBytes);

        System.out.println("nextDouble(): " + secureRandom.nextDouble());
        System.out.println("nextInt(): " + secureRandom.nextInt());
        System.out.println("nextInt(5): " + secureRandom.nextInt(5));
        System.out.println("nextInt(5)+1: " + (secureRandom.nextInt(5) + 1));
        System.out.println("nextInt(1,5): " + secureRandom.nextInt(1, 5));


    }

    public static void uuid() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.toString().replace("-", ""));
        System.out.println(uuid.toString().replace("-", "").substring(0, 16));
    }

    public static void main(String[] args) {
        mathRandom();
        secureRandom();
        uuid();

    }
}
