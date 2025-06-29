package chap04_ex_answer;

public class Ex06 {

  public static void main(String[] args) {
    
    // 100부터 1까지 역순으로 값을 출력하세요.
    // 한 줄에 숫자를 10개씩 출력하세요.
    
    for (int n = 100; n > 0; n--) {
      System.out.print(n + " ");
      if (n % 10 == 1) {
        System.out.println();
      }
    }

  }

}
