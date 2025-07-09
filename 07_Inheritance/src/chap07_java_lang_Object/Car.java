package chap07_java_lang_Object;

import java.util.Objects;

/*
 * java.lang.Object 클래스
 * 
 * 1. 자바의 모든 클래스의 최상위 슈퍼클래스입니다.
 * 2. 별도의 슈퍼클래스 명시가 없는 클래스들은(extends가 없는 클래스) 모두 java.lang.Object 클래스를 슈퍼클래스로 가집니다.
 * 3. 모든 객체(인스턴스)들은 java.lang.Object 타입으로 up-casting 할 수 있습니다. (만능 타입입니다.)
 *    단, java.lang.Object 타입으로 up-casting된 객체는 오직 java.lang.Object 클래스의 멤버만 호출할 수 있으므로 
 *    반드시 down-casting을 이용해서 객체 자신의 메소드를 호출해야 합니다.
 */

/*
 * +------------------+
 * | java.lang.Object |
 * +------------------+
 * | equals()         | 비교하는 두 객체의 참조값을 비교해서 true 또는 false를 반환합니다.
 * | getClass()       | 어떤 클래스 타입인지 반환합니다.
 * | hashCode()       | 객체가 가지고 있는 해시코드 값을 반환합니다.
 * | toString()       | "클래스명@해시코드" 형식의 문자열을 반환합니다.
 * | notify()         | 다른 스레드에게 작업의 종료를 알립니다. (스레드 관련 메소드)
 * | notifyAll()      | 다른 모든 스레드에게 작업의 종료를 알립니다. (스레드 관련 메소드)
 * | wait()           | 다른 스레드의 작업이 종료될때까지 기다립니다. (스레드 관련 메소드)
 * +------------------+
 *           ↑
 * +------------------+
 * | Car              |
 * +------------------+
 * | @Override        |
 * | equals()         | 두 객체의 carNo가 일치하면 true 아니면 false를 반환합니다.
 * |                  |
 * | @Override        |
 * | toString()       | 모델명과 자동차번호 확인할 수 있는 문자열을 반환합니다.
 * +------------------+
 */

public class Car {

  private String carNo;
  private String model;
  
  public Car(String carNo, String model) {
    super();  //------ java.lang.Object 클래스의 생성자를 호출합니다. 디폴트 생성자의 호출이므로 생략해도 아무 문제가 없습니다.
    this.carNo = carNo;
    this.model = model;
  }
  
  public void carInfo() {
    System.out.println("차량번호: " + carNo);
    System.out.println("차량모델: " + model);
  }

  //----- equals() 메소드 오버라이드 (Car 객체의 비교를 위해 새로 만듭니다.)
  @Override
  public int hashCode() {
    return Objects.hash(carNo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Car other = (Car) obj;
    return Objects.equals(carNo, other.carNo);
  }

  //----- toString() 메소드 오버라이드 (Car 객체의 정보를 출력하기 위해 새로 만듭니다.)
  @Override
  public String toString() {
    return "Car [carNo=" + carNo + ", model=" + model + "]";
  }
  
}