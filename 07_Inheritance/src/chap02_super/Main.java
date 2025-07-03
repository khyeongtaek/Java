package chap02_super;

public class Main {
    public static void main(String[] args) {

        Developer developer = new Developer("뽀로로", new String[]{"Java", "Spring", "JPA", "MySQL", "Docker", "AWS", "JavaScript"});
        developer.printInfo();
    }
}
