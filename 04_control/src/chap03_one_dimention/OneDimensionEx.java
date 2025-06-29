package chap03_one_dimention;

import java.util.Arrays;


public class OneDimensionEx {
    public static void main(String[] args) {
        //--------- 스택 영역에 참조 변수 blackping가 생성됩니다.
        // ----- 힙 영역에 String 저장이 가능한 연속된 4개 메모리 공간이 생성됩니다.
        // -------그 중 첫번째 공간의 참조값을 참조 변수 blackpink에 저장합니다.
        // -------힙 영역에 생성된 4개 메모리 공간은 느리거나 줄일 수 없습니다.
        String[] blackpink = new String[4];
        // 배열 요소 사용 (배열명 뒤에 대괄호를 붙이고 인덱스를 작성)
        blackpink[0] = "제니";
        blackpink[1] = "지수";
        blackpink[2] = "로제";
        blackpink[3] = "리사";

        // Print array elements using Arrays.toString()
        System.out.println(Arrays.toString(blackpink));

        String[] frontEnd = {"HTML", "CSS", "JavaScript", "React"};
        System.out.println(Arrays.toString(frontEnd));
        String[] backEnd;
        backEnd = new String[]{"MYSQL", "Java", "JSP/Servlet", "Spring"};
        System.out.println(Arrays.toString(backEnd));


        String[] hobbies = {"travel", "game", "coding"};

        for (int i = 0; i < hobbies.length; i++) {
            System.out.print(hobbies[i] + ", ");
        }
        System.out.println();

        for (String hobby : hobbies) {
            System.out.print(hobby + ", ");
        }
        System.out.println();


        
        




    }
    
    
}

