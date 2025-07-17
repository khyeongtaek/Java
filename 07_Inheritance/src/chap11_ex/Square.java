package chap11_ex;

public class Square extends Rectangle {

  public Square() { }

  public Square(double side) {
    super(side, side);  // width와 height를 모두 side로 설정합니다.
  }
  
}
