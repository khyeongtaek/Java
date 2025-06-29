package chap04_ex_answer;

public class Ex02 {

  public static void main(String[] args) {
    
    // 정수형 변수 3개에 임의의 값을 저장한 뒤, 그 중에서 가장 큰 수를 출력하세요.
    
    int x = 3;
    int y = 1;
    int z = 2;
    
    int max;
    
    if(x >= y && x >= z) {
      max = x;
    } else if(y >= x && y >= z) {
      max = y;
    } else {
      max = z;
    }
    
    System.out.println(max);

  }

}
