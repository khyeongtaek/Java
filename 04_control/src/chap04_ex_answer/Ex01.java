package chap04_ex_answer;

public class Ex01 {

  public static void main(String[] args) {
    
    // 정수형 변수 a와 b에 임의의 값을 저장한 뒤, 두 수의 합과 차를 출력하세요.
    // 차는 항상 양수 값으로 출력하세요.
    
    int a = 10;
    int b = 5;
    
    int addResult = a + b;
    int subResult;
    if(a >= b)
      subResult = a - b;
    else
      subResult = b - a;
    
    System.out.println("합: " + addResult);
    System.out.println("차: " + subResult);

  }

}
