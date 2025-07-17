package chap13_ex;

public class Main {

  public static void main(String[] args) {
  
    // Coffee 2잔
    Coffee americano = new Americano("아메리카노", new Espresso("에스프레소", "콜롬비아"), 2);
    Coffee latte = new CafeLatte("카페라떼", new Espresso("에스프레소", "탄자니아"), 1, "서울우유");
    
    // Cup 2개
    Cup cup1 = new Cup(); cup1.setCoffee(americano);
    Cup cup2 = new Cup(); cup2.setCoffee(latte);
    
    // Carrier 1개
    Carrier carrier = new Carrier();
    carrier.addCup(cup1);
    carrier.addCup(cup2);

    carrier.printInfo();
    
  }

}
