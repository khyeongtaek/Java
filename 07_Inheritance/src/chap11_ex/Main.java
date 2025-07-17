package chap11_ex;

public class Main {

  public static void main(String[] args) {
    
    //----- 직사각형을 1개 생성합니다.
    Rectangle rectangle = new Rectangle(1.5, 2.5);
    
    //----- 직사각형의 너비, 높이, 넓이를 출력합니다.
    System.out.println("너비: " + rectangle.getWidth());
    System.out.println("높이: " + rectangle.getHeight());
    System.out.println("넓이: " + rectangle.getArea());
    
    //----- 정사각형을 1개 생성합니다.
    Square square = new Square(1.5);
    
    //----- 정사각형의 너비, 높이, 넓이를 출력합니다.
    System.out.println("너비: " + square.getWidth());
    System.out.println("높이: " + square.getHeight());
    System.out.println("넓이: " + square.getArea());
    
  }

}
