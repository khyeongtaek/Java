package chap13_ex;

public class CafeLatte extends Coffee {

  private Espresso espresso;
  private int shots;
  private String milk;
  
  public CafeLatte() { }
  public CafeLatte(String name, Espresso espresso, int shots, String milk) {
    super(name);
    this.espresso = espresso;
    this.shots = shots;
    this.milk = milk;
  }
  
  public Espresso getEspresso() {
    return espresso;
  }
  public void setEspresso(Espresso espresso) {
    this.espresso = espresso;
  }
  public int getShots() {
    return shots;
  }
  public void setShots(int shots) {
    this.shots = shots;
  }
  public String getMilk() {
    return milk;
  }
  public void setMilk(String milk) {
    this.milk = milk;
  }
  
  @Override
  public void printInfo() {
    espresso.printInfo();
    System.out.println("shots: " + shots);
    System.out.println("milk: " + milk);
  }
  
}
