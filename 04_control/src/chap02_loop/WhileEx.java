package chap02_loop;

public class WhileEx {

  public static void main(String[] args) {
    
    // 1 ~ 100 누적하기
    int total = 0;
    int x = 0;
    while (x < 100) {
      total += ++x;
    }
    System.out.println(total);

    // 1 ~ 100 홀수만 누적하기
    int oddTotal = 0;
    int odd = 1;
    while (odd < 100) {
      oddTotal += odd;
      odd += 2;
    }
    System.out.println(oddTotal);
    
    // 1 ~ 100 짝수만 누적하기
    int evenTotal = 0;
    int even = 1;
    while (even <= 100) {
      if (even % 2 == 0) {
        evenTotal += even;
      }
      even++;
    }
    System.out.println(evenTotal);
    
  }

}
