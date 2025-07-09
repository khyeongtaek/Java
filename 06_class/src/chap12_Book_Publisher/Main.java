package chap12_Book_Publisher;

// 문제. Book 객체를 만들고 Setter를 호출하여 적절한 정보를 저장하세요.
//       정보 저장 뒤 Getter를 호출하여 해당 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {
    
    // Contact 객체
    Contact contact = new Contact();
    contact.setTel("02-1111-1111");
    contact.setFax("02-1111-1112");
    
    // Publisher 객체
    Publisher publisher = new Publisher();
    publisher.setName("가산출판사");
    publisher.setLocation("서울");
    publisher.setContact(contact);
    
    // Book 객체
    Book book = new Book();
    book.setTitle("자바마스터");
    book.setPublisher(publisher);
    
    // Getter를 이용한 정보 확인
    System.out.println(book.getTitle());
    System.out.println(book.getPublisher().getName());
    System.out.println(book.getPublisher().getLocation());
    System.out.println(book.getPublisher().getContact().getTel());
    System.out.println(book.getPublisher().getContact().getFax());
    
  }

}
