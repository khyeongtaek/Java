package chap13_ex;

public class Carrier {

  private Cup[] cups;
  private int count;
  private final int LIMIT = 4;
  
  public Carrier() {
    cups = new Cup[LIMIT];
  }

  public void addCup(Cup cup) {
    if (count == LIMIT) {
      System.out.println("캐리어 꽉 참");
      return;
    }
    if (cup == null) {
      System.out.println("전달된 Cup 없음");
      return;
    }
    cups[count++] = cup;
  }
  
  public void printInfo() {
    for (Cup cup : cups) {
      if (cup != null)
        cup.getCoffee().printInfo();
    }
  }

}
