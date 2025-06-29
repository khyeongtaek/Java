package chap04_ex_answer;

public class Ex04 {

  public static void main(String[] args) {
    
    // 점수와 학년에 따른 합격 여부를 출력하세요.
    // 대학 1~2학년은 60점 이상이면 "합격"이고, 3~4학년은 70점 이상이어야 "합격"입니다.
    
    int score = 65;
    int year = 3;
    
    int cutLine = 0;
    if(year <= 2)
      cutLine = 60;
    else
      cutLine = 70;
      
    boolean passed = score >= cutLine;
    
    System.out.println(passed ? "합격" : "불합격");

  }

}
