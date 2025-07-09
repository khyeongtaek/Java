package chap02_super;

import java.util.Arrays;

/*
 * super
 * 
 * 1. 상속 관계에 놓인 클래스 중 자식클래스(서브클래스)가 부모클래스(슈퍼클래스)를 지칭하는 키워드입니다.
 * 2. super() 문법은 슈퍼클래스의 생성자를 호출하는 문법입니다.
 * 3. super.멤버 문법은 슈퍼클래스의 멤버에 접근할 때 사용하는 문법입니다.
 */

public class Developer extends Person {

  private String[] skills;

  public Developer(String name, String[] skills) {
    super(name);  //----- new Developer("이름", new String[]{"기술", ...}) 에서 "이름"을 Person(String name) { } 생성자에 전달합니다.
                  //----- 슈퍼클래스의 생성자를 호출하는 코드입니다.
                  //----- 자식생성자는 반드시 부모생성자를 가장 먼저 호출해야 합니다. (부모를 먼저 만들고, 자식을 나중에 만듭니다.)
    this.skills = skills;
  }
  
  public void printInfo() {
    // super.name : Person 클래스의 name은 private 멤버이므로, 상속 관계에 있더라도 접근할 수 없습니다.
    super.printInfo();  //----- 슈퍼클래스의 멤버를 호출합니다. 즉, Person 클래스의 printInfo() 메소드를 호출합니다.
    System.out.println("기술: " + Arrays.toString(skills));
  }
  
}
