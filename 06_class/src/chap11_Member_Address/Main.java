package chap11_Member_Address;

// 문제. 생성자를 호출하여 Member 객체를 만들고 printInfo() 메소드를 호출하여 객체의 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {

    Member member = new Member(
        new Address("12345", "주소1", "동호1"), 
        new Address("67890", "주소2", "동호2")
    );
    
    member.printInfo();
    
  }

}
