package chap02_method_parameter;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    
    // 클래스 Parameter 타입의 객체 parameter 생성
    Parameter parameter = new Parameter();
    
    // 객체 parameter를 이용해서 메소드를 호출합니다.
    parameter.methodA();  //------ 매개변수(파라미터)가 없으므로 인자(Argument)를 전달하지 않습니다.
    parameter.methodB(0);  //----- 인자 0이 매개변수 x로 전달됩니다.
    
    /* int[] numbers = {1, 2, 3};
    parameter.methodC(numbers); */
    parameter.methodC(new int[] {1, 2, 3});
    
    parameter.methodD();  //--- 매개변수 int... 타입은 가변 인자 타입이므로
    parameter.methodD(1);  //-- 전달하는 인자의 개수를 마음대로 조정할 수 있습니다.
    parameter.methodD(1, 2);
    
    parameter.methodE(1);  //----- 첫 인자는 매개변수 int first로 전달
    parameter.methodE(1, 2);  //-- 두 번째 이후 인자들은 매개변수 int... rest로 전달
    
    int number = 0;
    int[] numbers = new int[3];
    parameter.methodF(number, numbers);  //------------- 기본타입변수, 참조타입변수 전달
    System.out.println("기본 타입 number: " + number);  //-- methodF가 수정한 기본타입변수는 현재 메소드의 int number에 영향을 미치지 않음
    System.out.println("참조 타입 numbers: " + Arrays.toString(numbers));  //-- methodF가 수정한 참조타입변수는 현재 메소드의 int[] numbers에 영향을 미침
    
    Car car = new Car();  //------------------- 객체 car 생성
    parameter.methodG(car, "서울");  //-------- 생성된 객체 참조변수 car 전달
    parameter.methodG(car, "경주");
    parameter.methodG(new Car(), "제주");  //-- 직접 객체를 생성해서 전달
    
  }

}
