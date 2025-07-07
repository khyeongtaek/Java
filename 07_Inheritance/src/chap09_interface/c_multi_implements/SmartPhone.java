package chap09_interface.c_multi_implements;

public class SmartPhone implements Camera, Phone{

    @Override
    public void picture() {
        System.out.println("찰칵");
    }

    @Override
    public void call() {
        System.out.println("전화~");

    }
}
