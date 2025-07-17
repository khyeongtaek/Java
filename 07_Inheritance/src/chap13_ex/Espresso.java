package chap13_ex;

public class Espresso extends Coffee {
  
  private String beanOrigin;

  public Espresso() { }
  public Espresso(String name, String beanOrigin) {
    super(name);
    this.beanOrigin = beanOrigin;
  }
  
  public String getBeanOrigin() {
    return beanOrigin;
  }
  public void setBeanOrigin(String beanOrigin) {
    this.beanOrigin = beanOrigin;
  }
  
  @Override
  public void printInfo() {
    System.out.println("beanOrigin: " + beanOrigin);
  }

}
