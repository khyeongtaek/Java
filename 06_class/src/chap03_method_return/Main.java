package chap03_method_return;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    
    Return ret = new Return();
    
    ret.methodA(-1);
    ret.methodA(0);
    
    int sum = ret.methodB(1, 2);
    System.out.println("methodB's return: " + sum);
    System.out.println("methodB's return: " + ret.methodB(3, 4));
    
    int[] numbers = ret.methodC(3);
    System.out.println("methodC's return: " + Arrays.toString(numbers));
    
    String carInfo = ret.methodD();
    System.out.println("methodD's return: " + carInfo);
    
  }

}
