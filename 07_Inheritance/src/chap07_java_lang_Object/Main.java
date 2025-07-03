package chap07_java_lang_Object;

public class Main {
    public static void main(String[] args) {
        Object car1 = new Car(new String("123가4567"), "Ray");

        if (car1 instanceof Car) {
            ((Car) car1).carInfo();
        }

        Object car2 = new Car(new String("123가4567"), "Rayeedeeeeeeeeeeeeeefefeeffefffefefefefefefefe");

        System.out.println(car1.equals(car2));

        System.out.println(car1);
        System.out.println(car2);


    }
}
