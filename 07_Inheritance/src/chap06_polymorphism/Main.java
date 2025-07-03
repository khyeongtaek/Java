package chap06_polymorphism;

public class Main {
    public static void main(String[] args) {

        Person person = new Person();

        Chihuahua chihuahua = new Chihuahua("치와와");
        Husky husky = new Husky("김스키");

        person.feedFood("닭날개", chihuahua);
        person.feedFood("치와와가 먹던 닭날개 뺏어서", husky);

    }
}
