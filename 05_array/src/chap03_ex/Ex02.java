package chap03_ex;

public class Ex02 {

  public static void main(String[] args) {
    
    // 다음 정수형 배열에 저장된 모든 요소 중 최대값과 최소값을 출력하세요.
    
    int[] numbers = {42, 17, 93, 120, 117, 59, 24, 28, 39};
    int max = numbers[0];
    int min = numbers[0];

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
      }
      if (numbers[i] < min) {
        min = numbers[i];
      }
    }
    System.out.println("max = " + max);
    System.out.println("min = " + min);
    
  }
  
}
