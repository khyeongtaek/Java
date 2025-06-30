package chap04_method_overloading;

public class Main {
    public static void main(String[] args) {
        View view = new View();

        view.print(1);
        view.print(1.5);
        view.print(new String[]{"A", "B", "C"});
        view.print(new Car());


    }


}
