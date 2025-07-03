package chap10_instance_array.chap09_instance_array;

public class Main {
    public static void main(String[] args) {

        Bus bus = new Bus();

        bus.seatInfo();

        Person person1 = new Person("홍길동");
        Person person2 = new Person("김길동");
        Person person3 = new Person("박길동");
        Person person4 = new Person("신용권");
        Person person5 = new Person("권길동");

        bus.on(person1);
        bus.on(person2);
        bus.on(person3);
        bus.on(person4);
        bus.on(person5);

        bus.seatInfo();

        bus.off(1);
        bus.off(2);
        bus.off(3);
        bus.off(4);
        bus.seatInfo();



    }
}
