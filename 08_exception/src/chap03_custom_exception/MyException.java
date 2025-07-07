package chap03_custom_exception;

import java.io.Serial;

public class MyException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public MyException(String message) {
        super(message);

    }
}