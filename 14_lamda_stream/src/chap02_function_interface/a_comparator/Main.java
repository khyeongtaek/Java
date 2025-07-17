package chap02_function_interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 사과 무게를 기준으로 오름차순 정렬하는 Comparator

        Comparator<Apple> byWeight = (o1, o2) -> (int) (o1.getWeight() - o2.getWeight());

        // 사과를 저장하는 List
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(100.0));
        appleList.add(new Apple(150.0));
        appleList.add(new Apple(120.0));
        appleList.add(new Apple(200.0));
        appleList.add(new Apple(300.0));
        appleList.add(new Apple(400.0));

        appleList.sort(byWeight);


        for (Apple apple : appleList) {
            System.out.println(apple);
        }

    }
}
