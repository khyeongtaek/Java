package chap07_access_modifier;

public class Main {

  public static void main(String[] args) {
    
    Car car1 = new Car();
    car1.printInfo();
    
    Car car2 = new Car("X6", 12000, new Brand("BMW", "Germany"));
    car2.printInfo();
    
    Car car3 = new Car("G80", 8000, "Genesis", "Korea");
    car3.printInfo();
    
    // Getter는 필드값을 확인할 때 사용합니다.
    System.out.println(car1.getModel());
    System.out.println(car1.getPrice());
    System.out.println(car1.getBrand().getName());
    System.out.println(car1.getBrand().getNation());
    
    // Setter는 필드값을 수정할 때 사용합니다.
    car2.setModel("Cayenne");
    car2.setPrice(15000);
    car2.getBrand().setName("Porsche");
    car2.getBrand().setNation("Germany");
    car2.printInfo();

    car3.setModel("Sorento");
    car3.setPrice(4000);
    car3.setBrand(new Brand("Kia", "Korea"));
    car3.printInfo();
    
  }

}
