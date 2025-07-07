package chap01_exception.b_finally;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("try 블록입니다.");
        }catch (Exception e) {
            System.out.println("catch 블록입니다.");
        }finally {
            System.out.println("항상 실행되는 finally 블록입니다.");

        }


    }



}
