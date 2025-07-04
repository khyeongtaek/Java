package chap11_Member_Address;

// 문제. 생성자를 호출하여 Member 객체를 만들고 printInfo() 메소드를 호출하여 객체의 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {
    Address home = new Address("Seoul", "Gangnam", "12345");
    Address delivery = new Address("Busan", "Haeundae", "48000");

    Member member = new Member(home, delivery);

    member.printInfo();
  }

}
