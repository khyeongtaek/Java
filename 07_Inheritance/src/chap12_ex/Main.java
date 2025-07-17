package chap12_ex;

public class Main {

  public static void main(String[] args) {
    
    //----- 학생을 5명 생성합니다.
    Student s1 = new Student("학생1", 20, "010-1111-1111", "10101");
    Student s2 = new Student("학생2", 20, "010-2222-2222", "10102");
    Student s3 = new Student("학생3", 20, "010-3333-3333", "10103");
    Student s4 = new Student("학생4", 20, "010-4444-4444", "10104");
    Student s5 = new Student("학생5", 20, "010-5555-5555", "10105");
    
    //----- 교수를 3명 생성합니다.
    Professor p1 = new Professor("교수1", 50, "010-6666-6666", "develop");
    Professor p2 = new Professor("교수2", 51, "010-7777-7777", "ai");
    Professor p3 = new Professor("교수3", 52, "010-8888-8888", "design");
    
    //----- 대학을 1개 생성합니다.
    College college = new College("우리대학");
    
    //----- 학생 5명과 교수 3명을 대학에 등록합니다.
    college.addStudent(s1);
    college.addStudent(s2);
    college.addStudent(s3);
    college.addStudent(s4);
    college.addStudent(s5);
    
    college.addProfessor(p1);
    college.addProfessor(p2);
    college.addProfessor(p3);
    
    //----- 학생 1명과 교수 1명을 대학에서 삭제합니다.
    Student s = college.removeStudent(s3);
    Professor p = college.removeProfessor(0);
    System.out.println("삭제된 학생: " + s);
    System.out.println("삭제된 교수: " + p);
    
    //----- 대학 정보를 출력해서 정보를 확인합니다.
    college.collegeInfo();

  }

}
