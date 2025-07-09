package chap09_interface.c_multi_implements;

// 인터페이스는 다중 구현할 수 있습니다.

public class SmartPhone implements Camera, Phone {

  @Override
  public void call() {
    // TODO Auto-generated method stub
    System.out.println("통화 기능");
  }

  @Override
  public void picture() {
    // TODO Auto-generated method stub
    System.out.println("카메라 기능");
  }

}
