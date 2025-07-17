package chap12_ex;

public class Student extends Person {

  private String studentId;
  
  public Student() { }
  public Student(String name, int age, String tel, String studentId) {
    super(name, age, tel);
    this.studentId = studentId;
  }
  @Override
  public String toString() {
    return "Student [studentId=" + studentId + ", person=" + super.toString() + "]";
  }
  
  public String getStudentId() {
    return studentId;
  }
  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }
  
}
