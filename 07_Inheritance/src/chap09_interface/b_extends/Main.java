package chap09_interface.b_extends;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println("전압: " + ElectronicProduct.VOLT);
        computer.powerOn();
        computer.powerOff();
        int num1 = 10;
        int num2 = 4;
        System.out.println("더엇셈 결과: " + computer.add(num1, num2));
        System.out.println("빼앨셈 결과: " + computer.sub(num1, num2));
        System.out.println("고옵셈 결과: " + computer.mul(num1, num2));
        System.out.println("나눗셈 결과: " + computer.div(num1, num2));
        System.out.print("나머지 결과: " + computer.mod(num1, num2));
    }
}
