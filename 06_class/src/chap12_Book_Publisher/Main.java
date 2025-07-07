package chap12_Book_Publisher;

// 문제. Book 객체를 만들고 Setter를 호출하여 적절한 정보를 저장하세요.
//       정보 저장 뒤 Getter를 호출하여 해당 정보를 확인하세요.

public class Main {

  public static void main(String[] args) {

    Contact contact = new Contact();
    contact.setFax("faxnumber");
    contact.setTel("telnumber");

    Publisher publisher = new Publisher();
    publisher.setName("Korea");
    publisher.setLocation("Seoul");
    publisher.setContact(contact);

    Book book = new Book();
    book.setTitle("Java");
    book.setPublisher(publisher);

    System.out.println("Book Title: " + book.getTitle());
    System.out.println("Publisher Name: " + book.getPublisher().getName());
    System.out.println("Publisher Location: " + book.getPublisher().getLocation());
    System.out.println("Publisher Fax: " + book.getPublisher().getContact().getFax());
    System.out.println("Publisher Tel: " + book.getPublisher().getContact().getTel());


  }

}
