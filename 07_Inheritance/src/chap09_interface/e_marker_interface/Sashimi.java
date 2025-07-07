package chap09_interface.e_marker_interface;

public class Sashimi implements Food {

    @Override
    public void howToEat() {
        System.out.println("신선한 생선회를 간장에 찍어서 와사비와 함께 드세요");
    }
}
