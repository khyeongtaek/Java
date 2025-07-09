package chap01_is_a;

/*
 * A는 B이다. (is-a 관계)
 * 
 * 학생은 사람이다.      Student is a Person.
 * 워커는 사람이다.      Worker is a Person.
 * 개발자는 워커이다.    Developer is a Worker.
 * 디자이너는 워커이다.  Designer is a Worker.
 */

public class Person {

  public void eat() {
    System.out.println("먹자.");
  }
  
  public void sleep() {
    System.out.println("잔다.");
  }
  
}
