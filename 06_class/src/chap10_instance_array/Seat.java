package chap10_instance_array;

public class Seat {

  private Person person;

  public Seat() {
    // 자동으로 생성되는 디폴트 생성자이지만 만들어 보았습니다.
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
  
}
