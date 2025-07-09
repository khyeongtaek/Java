package chap11_Member_Address;

// 문제. 필드를 이용한 생성자를 만들고 정보를 출력하는 printInfo() 메소드를 구현하세요.

public class Address {

  private String zipCode;  //----- 우편번호
  private String roadAddr;  //---- 도로명주소
  private String detailAddr;  //-- 상세주소
  
  public Address(String zipCode, String roadAddr, String detailAddr) {
    super();
    this.zipCode = zipCode;
    this.roadAddr = roadAddr;
    this.detailAddr = detailAddr;
  }
  
  public void printInfo() {
    System.out.println("우편번호: " + zipCode);
    System.out.println(roadAddr + " " + detailAddr);
  }
  
}
