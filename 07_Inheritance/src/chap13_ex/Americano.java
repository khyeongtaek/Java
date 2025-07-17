package chap13_ex;

public class Americano extends Coffee {

  private Espresso espresso;
  private int shots;
  
  public Americano() { }
  public Americano(String name, Espresso espresso, int shots) {
    super(name);
    this.espresso = espresso;
    this.shots = shots;
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
  
  @Override
  public void printInfo() {
    espresso.printInfo();
    System.out.println("shots: " + shots);
  }
  
}
