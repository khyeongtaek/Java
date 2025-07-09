package chap06_polymorphism;

public class Main {

  public static void main(String[] args) {
    
    Chihuahua chihuahua = new Chihuahua("치와왕");
    Husky husky = new Husky("허숙희");
    
    Person person = new Person();
    person.feedFood("개껌", chihuahua);
    person.feedFood("육포", husky);

  }

}
