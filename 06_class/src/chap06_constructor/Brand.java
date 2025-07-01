package chap06_constructor;

public class Brand {
    String name;
    String nation;

    public Brand() {
    }
    public Brand(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public void printInfo() {
        System.out.println(name + ", " + nation);
    }
}
