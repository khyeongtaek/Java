package chap09_interface.b_extends;

public class Main {

  public static void main(String[] args) {
    
    Computable computer = new Computer();
    
    System.out.println("전압: " + ElectronicProduct.VOLT);
    computer.powerOn();
    computer.powerOff();
    
    int a = 10, b = 4;
    System.out.println(computer.add(a, b));
    System.out.println(computer.sub(a, b));
    System.out.println(computer.mul(a, b));
    System.out.println(computer.div(a, b));
    System.out.println(computer.mod(a, b));
    
  }

}
