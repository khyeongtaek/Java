package chap06_constructor;

public class Main {

  public static void main(String[] args) {
    
    // 디폴트 생성자 호출
    Car car1 = new Car();
    car1.printInfo();
    
    // 일반 생성자1 호출
    Car car2 = new Car("Sorento");
    car2.printInfo();

    // 일반 생성자2 호출
    Car car3 = new Car(4000);
    car3.printInfo();
    
    // 일반 생성자3 호출
    Car car4 = new Car("Santafe", 5000);
    car4.printInfo();
    
    // 일반 생성자4 호출
    Car car5 = new Car("G80", 7000, new Brand("Genesis", "Korea"));
    car5.printInfo();
    
  }

}
