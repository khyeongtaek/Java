package chap02_method_parameter;

import java.util.Arrays;

/*
 * 메소드 형식
 * 
 * 반환타입 메소드명(매개변수1, 매개변수2, ...) {
 *   메소드 본문 코드
 *   return 반환값
 * }
 * 
 * 메소드명: camelCase
 */
public class Parameter {

  /**
   * @param 없음
   */
  void methodA() {
    System.out.println("methodA");
  }
  
  /**
   * @param x 정수를 전달 받음
   */
  void methodB(int x) {
    System.out.println("methodB: " + x);
  }
  
  /**
   * @param items 정수형 배열을 전달 받음
   */
  void methodC(int[] items) {
    System.out.println("methodC: " + Arrays.toString(items));
  }
  
  /**
   * 
   * @param items 가변 인자이므로 0개 이상의 정수 값을 전달 받음 (int[]과 동일하게 동작)
   */
  void methodD(int... items) {
    System.out.println("methodD: " + Arrays.toString(items));
  }
  
  /**
   * 1개 이상의 정수 값을 전달 받는 메소드
   * @param first 반드시 전달 받는 정수 값
   * @param rest 0개 이상의 정수 값
   */
  void methodE(int first, int... rest) {
    System.out.println("methodE: " + first + ", " + Arrays.toString(rest));
  }
  
  /**
   * 기본 타입과 참조 타입의 동작을 비교하기 위한 메소드
   * @param number  기본 타입
   * @param numbers 참조 타입
   */
  void methodF(int number, int[] numbers) {
    number = 10;
    numbers[0] = 1;
    numbers[1] = 2;
    numbers[2] = 3;
  }
  
  /**
   * 클래스 타입의 매개변수 활용하기
   * @param car 클래스 Car 타입의 객체가 전달되는 매개변수
   * @param region String 문자열이 전달되는 매개변수
   */
  void methodG(Car car, String region) {
    car.drive(region);
  }
  
}
