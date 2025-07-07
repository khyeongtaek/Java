package chap03_custom_exception;

public class Main {
    public static void customException() throws MyException{
        throw new MyException("OMG");
    }

    public static void main(String[] args) {
        try {
            customException();
        } catch (MyException e) {
            System.out.println(Thread.currentThread().getName());
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
