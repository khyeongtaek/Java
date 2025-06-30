package chap06_constructor;

public class Brand {
    String name;
    String nation;

    Brand(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    void printInfo() {
        System.out.println(name + ", " + nation);
    }
}
